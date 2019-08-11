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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererRessourcesController {
    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();
    
    /**
     *
     * @return
     */
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
   
  
   
    
    /**
     *
     * @param req
     * @param rep
     * @throws IOException
     */
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
