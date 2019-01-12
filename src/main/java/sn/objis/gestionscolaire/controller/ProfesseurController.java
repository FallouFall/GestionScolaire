/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sn.objis.gestionscolaire.config.Connexion;

/**
 *
 * @author Fallou
 */
@Controller
public class ProfesseurController {
    Connexion con=new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("professeur.htm")
    public ModelAndView welcome()
    {
    // String sql="SELECT * FROM user";
   //  List data = this.jdtbcTemplate.queryForList(sql);
    // mav.addObject("liste", data);
        System.out.println("hee");
        mav.setViewName("AccueilProfesseur");
     return mav; 
    }
      @RequestMapping("index.htm")
    public ModelAndView deconnection()
    {
    // String sql="SELECT * FROM user";
   //  List data = this.jdtbcTemplate.queryForList(sql);
    // mav.addObject("liste", data);
        System.out.println("hee");
        mav.setViewName("index");
     return mav;
    }
}
