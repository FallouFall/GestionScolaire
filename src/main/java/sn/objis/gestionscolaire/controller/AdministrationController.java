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

/**
 *
 * @author Fallou
 */
@Controller
public class AdministrationController {
    Connexion con=new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("administration.htm")
    public ModelAndView welcome(HttpServletRequest req)
    {
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();
        String  photo = (String) session.getAttribute("photo");   
        mav.setViewName("Administration");
        return mav.addObject("photo", photo);
    }
    
      
    @RequestMapping("GererProfesseur.htm")
    public ModelAndView professeur(HttpServletRequest req)
    {         
        mav.setViewName("GererProfesseur");
        return mav;
    }
     @RequestMapping("GererSecretaire.htm")
    public ModelAndView secretaire(HttpServletRequest req)
    {         
        mav.setViewName("GererSecretaire");
        return mav;
    }
    
     @RequestMapping("GererComptable.htm")
    public ModelAndView comptable(HttpServletRequest req)
    {         
        mav.setViewName("GererComptable");
        return mav;
    }
     @RequestMapping("GererDirecteur.htm")
    public ModelAndView directeur(HttpServletRequest req)
    {         
        mav.setViewName("GererDirecteur");
        return mav;
    }
    
    
     @RequestMapping("ressources.htm")
    public ModelAndView ressources(HttpServletRequest req)
    {         
        mav.setViewName("GererRessources");
        return mav;
    }
      @RequestMapping(value = "administration.htm",method = RequestMethod.POST)
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
