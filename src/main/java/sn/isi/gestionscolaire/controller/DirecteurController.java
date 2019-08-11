/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

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
public class DirecteurController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();

    /**
     *
     * @param req
     * @param rep
     * @return ModelView
     */
    @RequestMapping("directeur.htm")
    public ModelAndView welcome(HttpServletRequest req, HttpServletResponse rep) {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {

            return new ModelAndView("index");
        } else {
            mav.setViewName("AccueilDirecteur");

        }
        return mav;
    }

  
}
