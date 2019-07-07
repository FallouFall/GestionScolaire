/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Evenement;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.Questions;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class SecretaireController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();

    /**
     *
     * @return
     */
    @RequestMapping("secretaire.htm")
    public ModelAndView welcome() {
        mav.addObject("nbQuestion",getNbQuestion());

        mav.setViewName("Secreteriat");
        return mav;
    }
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
    @RequestMapping("faqResponseSec.htm")
    public ModelAndView faqResponseSec(HttpServletRequest req) {

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

        mav.setViewName("FaqResponseSec");
        return mav;
    }
  /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("detailquestionSec.htm")
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

        mav.setViewName("detailQuestionSec");
        return mav;
    }

    
     @RequestMapping(value = "detailquestionSec.htm",method = RequestMethod.POST)
    public void repondreQuestionSec(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        String id = req.getParameter("id");
        String reponse = req.getParameter("reponse");
       
      

        String sql = "update questions set reponse=?,statut=? where id=?";
        jdtbcTemplate.update(sql, reponse,1, id);
        rep.sendRedirect("faqResponseSec.htm");
       

    }

    
    /**
     *
     * @return
     */
    @RequestMapping("Annonces.htm")
    public ModelAndView annonces() {
      String sql = "SELECT * from evenement order by id desc limit 15;";

        List<Evenement> eve = jdtbcTemplate.query(
                sql,
                new Object[]{},
                new RowMapper<Evenement>() {
            public Evenement mapRow(ResultSet rs, int rowNum) throws SQLException {
                Evenement c = new Evenement();
                c.setId(rs.getInt(1));
                c.setTitre(rs.getString(2));
                c.setSoustitre(rs.getString(3));
                c.setDebut(rs.getString(4));
                c.setFin(rs.getString(5));
                c.setDescription(rs.getString(6));
                     c.setLieu(rs.getString(7));
               
     
                
                return c;
            }
        });
      mav.addObject("evenements", eve);
        mav.setViewName("Annonces");
        return mav;
    }
    
    /**
     *
     * @param req
     * @return
     */
    @RequestMapping(value="Annonces.htm",method = RequestMethod.POST)
    public  ModelAndView saveAnnonces(HttpServletRequest req)          
    {
       Evenement eve= new Evenement();
       eve.setTitre(req.getParameter("titre"));
       eve.setSoustitre(req.getParameter("soustitre"));
        eve.setFin(req.getParameter("fin"));
   eve.setDebut(req.getParameter("debut"));
       eve.setDescription(req.getParameter("description"));
              eve.setLieu(req.getParameter("lieu"));
       
    
       
       String sql="insert into evenement values (?,?,?,?,?,?,?)";
       jdtbcTemplate.update(sql,null,eve.getTitre(),eve.getSoustitre(),eve.getDebut(),eve.getFin(),eve.getDescription(),eve.getLieu());
        // String sql="SELECT * FROM user";
        //  List data = this.jdtbcTemplate.queryForList(sql);
        // mav.addObject("liste", data);
        mav=annonces();
        mav.setViewName("Annonces");
        return mav;
    }

  
}
