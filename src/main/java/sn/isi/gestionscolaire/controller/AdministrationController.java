/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.gestionscolaire.config.Connexion;

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
        String nom = (String) session.getAttribute("nom");
        String prenom = (String) session.getAttribute("prenom");
        String id = (String) session.getAttribute("id");
        String idprofil = (String) session.getAttribute("idprofil");
        String url = (String) session.getAttribute("url");
        mav.setViewName("Administration");
        mav.addObject("tel", tel);
        mav.addObject("adresse", adresse);
        mav.addObject("login", login);
        mav.addObject("id", id);
        mav.addObject("password", password);
        mav.addObject("profil",profil);
        mav.addObject("idprofil",idprofil);
        mav.addObject("url",url);
        
        
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
    @RequestMapping("ressources.htm")
    public ModelAndView ressources(HttpServletRequest req) {
        mav.setViewName("GererRessources");
        return mav;
    }
  @RequestMapping(value = "lock.htm")
    public void lock(HttpServletRequest req,HttpServletResponse rep) {

        String back=req.getParameter("back");
         String statut=req.getParameter("statut");
        String profilId=req.getParameter("profilId");
        int lock;
        if(statut.equalsIgnoreCase("0")){
            lock=1;
        }else
        {
        lock=0;
        }
        
        
    String sql = "update profil set statut=? where id=?";
     jdtbcTemplate.update(sql, lock, profilId);
        try {
            rep.sendRedirect(back);
        } catch (IOException ex) {
            Logger.getLogger(AdministrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
  
}
