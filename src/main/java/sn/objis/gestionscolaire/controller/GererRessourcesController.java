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
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.objis.gestionscolaire.config.Connexion;
import sn.objis.gestionscolaire.domain.Filiere;
import sn.objis.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererRessourcesController {
    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    public ModelAndView mav = new ModelAndView();
    

    @RequestMapping("GererAdmin.htm")
    public ModelAndView welcome() {
     
        String sql="SELECT distinct nom,prenom, adresse,telephone,photo from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";
        List<String> image=new ArrayList<>();
        List<User> actors =new ArrayList<>();
        
        
        actors = jdtbcTemplate.query(sql,
                new Object[]{1}, (ResultSet rs, int rowNum) -> {
                    User c = new User();
                    
                    c.setNom(rs.getString(1));
                    c.setPrenom(rs.getString(2));
                    c.setAdresse(rs.getString(3));
                    c.setTelephone(rs.getString(4));
                    
                    try {
                        String encodeBase64 = Base64.encodeBase64String(rs.getBytes(5));
                        image.add(encodeBase64);
                    } catch (Exception e) {
                    }
                    return c;
        });
      
       mav.addObject("liste", actors);
       mav.addObject("listeImage", image);
        return mav;
    }
   
     @RequestMapping("gererclasse.htm")
    public ModelAndView listeClasse(HttpServletRequest req)
    {
        ModelAndView mav = new ModelAndView();
     
        mav.setViewName("ListeClasses");
        return mav;
    }
    
    
      @RequestMapping("gererfiliere.htm")
    public ModelAndView listeFiliere(HttpServletRequest req)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ListeFiliere");
        
        
          String sql = "SELECT * from filiere  ";
      List<Filiere>  filieres = jdtbcTemplate.query(sql,
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
    
      @RequestMapping(value = "gererfiliere.htm", method = RequestMethod.POST)
    public ModelAndView saveFilieres(HttpServletRequest req) {
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
        return new ModelAndView("ListeFiliere");
        
    }
    
    
    
    
    @RequestMapping(value = "index.htm",method = RequestMethod.POST)
    public void deconnection(HttpServletRequest req,HttpServletResponse rep) throws IOException
    {
	Cookie loginCookie = null;
    	Cookie[] cookies = req.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("user")){
    			loginCookie = cookie;
                      
    			break;
    		}
    	}
    	}
       
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0);
        	rep.addCookie(loginCookie);
    	}
         rep.sendRedirect("index.htm");
   
    }
}
