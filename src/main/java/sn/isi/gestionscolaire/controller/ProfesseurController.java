/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sn.isi.gestionscolaire.config.Connexion;

/**
 *
 * @author Fallou
 */
@Controller
public class ProfesseurController {
    Connexion con=new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
    
    /**
     *
     * @param req
     * @param rep
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping("professeur.htm")
    public ModelAndView welcome(HttpServletRequest req, HttpServletResponse rep) throws IOException
    {
       HttpSession sessions = req.getSession();
              String log = (String) sessions.getAttribute("log");
       if(log.equalsIgnoreCase("0"))
        {
           rep.sendRedirect("changePassword.htm");
           mav.setViewName("changePassword");
        }
       else
       {
        mav.setViewName("AccueilProfesseur");
        }
     return mav; 
    }

 

}
