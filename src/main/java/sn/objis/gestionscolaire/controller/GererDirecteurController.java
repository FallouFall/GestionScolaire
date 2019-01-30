/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.objis.gestionscolaire.config.Connexion;
import sn.objis.gestionscolaire.domain.Account;
import sn.objis.gestionscolaire.domain.Filiere;
import sn.objis.gestionscolaire.domain.Matiere;
import sn.objis.gestionscolaire.domain.Profil;
import sn.objis.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererDirecteurController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    public ModelAndView mav = new ModelAndView();
    List<Matiere> matiere = new ArrayList<>();
     List<Filiere> filieres = new ArrayList<>();
  
    
    @RequestMapping("gererue.htm")
    public ModelAndView gererUe() {        
        return new ModelAndView("GererUe");
    }
    
     @RequestMapping("GererClasseFiliere.htm")
    public ModelAndView gererClasseFiliere() {        
        return new ModelAndView("GererRessources");
    }
    
    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterDirecteur.htm");
        
    }
    
    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.POST)
    public void saveAdmin(HttpServletRequest req) {
        try {
            
            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setTelephone(req.getParameter("mail"));
            
            Account account = new Account(5);
            
            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(req.getParameter("password"));
            profil.setUsername(req.getParameter("username"));
            user.setIdprofil(profil);
            
            String sql = "insert into profil values (?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername());
            
            sql = "Select Max(id) from profil";
            boolean result = false;
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }
            
            sql = "insert into user values (?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @RequestMapping(value = "gererue.htm", method = RequestMethod.POST)
    public ModelAndView saveMatiere(HttpServletRequest req) {
        try {
            
            Matiere matiere = new Matiere();
            matiere.setNom(req.getParameter("nomMatiere"));
            matiere.setDescription(req.getParameter("descriptionMatiere"));
            matiere.setMatricule("MTR" + (int) (Math.random() * 9999999));
            matiere.setCreation(java.sql.Date.valueOf(LocalDate.now()));        
            String sql = "insert into matiere values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, matiere.getMatricule(), matiere.getNom(), matiere.getCreation(), matiere.getDescription());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView("GererUe");
        
    }
    
    
     @RequestMapping(value = "GererClasseFiliere.htm", method = RequestMethod.POST)
    public ModelAndView saveFiliere(HttpServletRequest req) {
        try {
           
            Filiere filiere = new Filiere();
            filiere.setNom(req.getParameter("nomFiliere"));
            filiere.setDescription(req.getParameter("descriptionFiliere"));
            filiere.setMatricule("FLR" + (int) (Math.random() * 9999999));
            filiere.setCreation(java.sql.Date.valueOf(LocalDate.now()));
            
            String sql = "insert into filiere values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, filiere.getMatricule(), filiere.getNom(), filiere.getCreation(), filiere.getDescription());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView("GererUe");
        
    }
    
    
     @RequestMapping(value = "listeMatiere.htm")
    public ModelAndView listeMatiere() {
     
       String sql = "SELECT * from matiere  ";
        matiere = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Matiere c = new Matiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
               
                 
                    return c;
                });
        mav.setViewName("ListeMatiere");
        mav.addObject("matieres", matiere);
        
        
        return mav;
        
    }
    
     @RequestMapping(value = "gererfiliere.htm")
     public ModelAndView listeFiliere() { 
       String sql = "SELECT * from filiere  ";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
               
                 
                    return c;
                });
        mav.setViewName("ListeFiliere");
        mav.addObject("filieres", filieres);
       
        
        
        return mav;
        
    }
    
    @RequestMapping(value = "GererDirecteur.htm", method = RequestMethod.POST)
    public void deconnection(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    loginCookie = cookie;
                    
                    break;
                }
            }
        }
        
        if (loginCookie != null) {
            loginCookie.setMaxAge(0);
            rep.addCookie(loginCookie);
        }
        rep.sendRedirect("index.htm");
        
    }
}
