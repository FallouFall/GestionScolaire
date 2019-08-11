/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import javax.servlet.http.HttpServletRequest;
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
public class ComptableController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("comptable.htm")
    public ModelAndView welcome(HttpServletRequest req) {
        HttpSession sessions = req.getSession();
        String user = (String) sessions.getAttribute("user");

        if (user == null) {

            return new ModelAndView("index");
        } else {
            mav.setViewName("Comptable");
        }
        return mav;
    }

 

}
