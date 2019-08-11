/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Questions;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class AdministrationController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("administration.htm")
    public ModelAndView welcome(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();
        String photo = (String) session.getAttribute("photo");
        String tel = (String) session.getAttribute("telephone");
        String adresse = (String) session.getAttribute("adresse");
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        String profil = (String) session.getAttribute("profil");
    
     
        String id = (String) session.getAttribute("id");
        String idprofil = (String) session.getAttribute("idprofil");
        String url = (String) session.getAttribute("url");
        mav.setViewName("Administration");
        mav.addObject("tel", tel);
        mav.addObject("adresse", adresse);
        mav.addObject("login", login);
        mav.addObject("id", id);
        mav.addObject("password", password);
        mav.addObject("profil", profil);
        mav.addObject("idprofil", idprofil);
        mav.addObject("url", url);
        mav.addObject("nbQuestion",getNbQuestion());

        return mav.addObject("photo", photo);
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("GererProfesseur.htm")
    public ModelAndView professeur(HttpServletRequest req) {
        mav.setViewName("GererProfesseur");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("GererSecretaire.htm")
    public ModelAndView secretaire(HttpServletRequest req) {
        mav.setViewName("GererSecretaire");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("GererComptable.htm")
    public ModelAndView comptable(HttpServletRequest req) {
        mav.setViewName("GererComptable");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("faqResponse.htm")
    public ModelAndView faqResponse(HttpServletRequest req) {

        String sql = "SELECT questions.matricule,user.nom,user.prenom,user.id,questions.date,questions.statut, questions.id FROM questions,user WHERE questions.iduser=user.id; ";

        List<Questions> questions = new ArrayList<>();

        questions = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Questions c = new Questions();
                    c.setMatricule(rs.getString(1));
                    User u = new User();
                    u.setNom(rs.getString(2));
                    u.setPrenom(rs.getString(3));
                    u.setId(rs.getInt(4));
                    c.setDate(rs.getDate(5));
                    c.setStatut(rs.getInt(6));
                    c.setIduser(u);
                    c.setId(rs.getInt(7));

                    return c;
                });

        mav.addObject("questions", questions);

        mav.setViewName("FaqResponse");
        return mav;
    }

    /**
     *
     * @return
     */
    public int getNbQuestion() {

        String sql = "SELECT COUNT(questions.statut) FROM questions WHERE questions.statut=0; ";

          int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
          return  count;

    }
    
    
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("GererDirecteur.htm")
    public ModelAndView directeur(HttpServletRequest req) {

        mav.setViewName("GererDirecteur");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("detailquestion.htm")
    public ModelAndView detailQuest(HttpServletRequest req) {

        String id = req.getParameter("id");
        String sql = "SELECT questions.matricule,user.nom,user.prenom,user.id,questions.date,questions.statut,user.telephone,user.photo,user.adresse,questions.description,questions.reponse FROM questions,user WHERE questions.iduser=user.id and questions.id=? ";

        List<Questions> questions = new ArrayList<>();

        questions = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Questions c = new Questions();
                    c.setMatricule(rs.getString(1));
                    User u = new User();
                    u.setNom(rs.getString(2));
                    u.setPrenom(rs.getString(3));
                    u.setId(rs.getInt(4));
                    c.setDate(rs.getDate(5));
                    c.setStatut(rs.getInt(6));
                    c.setIduser(u);
                    u.setTelephone(rs.getString(7));
                    u.setPhoto(rs.getBytes(8));
                    u.setAdresse(rs.getString(9));
                    String photoEtudiant = Base64.encodeBase64String(u.getPhoto());
                    mav.addObject("photoEtudiant", photoEtudiant);
                    c.setDescription(rs.getString(10));
 c.setReponse(rs.getString(11));
                    return c;
                });

        mav.addObject("questions", questions.get(0));

        mav.setViewName("detailQuestion");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("ressources.htm")
    public ModelAndView ressources(HttpServletRequest req) {
        mav.setViewName("GererRessources");
        return mav;
    }

    /**
     *
     * @param req
     * @param rep
     */
    @RequestMapping(value = "lock.htm")
    public void lock(HttpServletRequest req, HttpServletResponse rep) {

        String back = req.getParameter("back");
        String statut = req.getParameter("statut");
        String profilId = req.getParameter("profilId");
        int lock;
        if (statut.equalsIgnoreCase("0")) {
            lock = 1;
        } else {
            lock = 0;
        }

        String sql = "update profil set statut=? where id=?";
        jdtbcTemplate.update(sql, lock, profilId);
        try {
            rep.sendRedirect(back);
        } catch (IOException ex) {
            Logger.getLogger(AdministrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     *
     * @param req
     * @param rep
     * @throws IOException
     */
    @RequestMapping(value = "detailquestion.htm",method = RequestMethod.POST)
    public void repondreQuestion(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        String id = req.getParameter("id");
        String reponse = req.getParameter("reponse");
       
      

        String sql = "update questions set reponse=?,statut=? where id=?";
        jdtbcTemplate.update(sql, reponse,1, id);
        rep.sendRedirect("faqResponse.htm");
       

    }

}
