/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import java.io.IOException;
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
import sn.objis.gestionscolaire.domain.Account;
import sn.objis.gestionscolaire.domain.Profil;
import sn.objis.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class HeaderController {
    Connexion con=new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
    
       @RequestMapping("profil.htm")
    public ModelAndView  profil(HttpServletRequest req) {
         Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
           if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("url")) {
                    loginCookie = cookie;
                    System.out.println(loginCookie);
                    break;
                }
            }
        }
        
         
        return new ModelAndView("Profil");
    }
   @RequestMapping("updateUser.htm")
    public ModelAndView  update(HttpServletRequest req) {
  
       mav.setViewName("UpdateUser");
       return mav;
    }
    
      @RequestMapping(value="updateUser.htm",method = RequestMethod.POST)
    public  ModelAndView updateUser(HttpServletRequest req)          
    {
        try {
            
       
       User user= new User();
       user.setNom(req.getParameter("nom"));
       user.setPrenom(req.getParameter("prenom"));
       user.setAdresse(req.getParameter("adresse"));
       user.setTelephone(req.getParameter("telephone"));
       user.setId(Integer.valueOf(req.getParameter("id").trim()));
    
   
       Profil profil=new Profil();
       profil.setId(Integer.valueOf(req.getParameter("idprofil").trim()));
       profil.setPassword(req.getParameter("password"));
       profil.setUsername(req.getParameter("username"));
       user.setIdprofil(profil);
       
       String sql="update  profil set username=? ,password=? where id=?";
       jdtbcTemplate.update(sql,profil.getUsername(),profil.getPassword(),profil.getId());
      
     
 
     sql="update user set adresse=?,telephone=? where id=?";
      jdtbcTemplate.update(sql,user.getAdresse(),user.getTelephone(),user.getId());
    
  } catch (Exception e) {
            System.out.println(e);
        }
    
          return new ModelAndView("UpdateUser");
      
    }
    
         @RequestMapping(value = "profil.htm", method = RequestMethod.POST)
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
