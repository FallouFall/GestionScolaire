/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererAdminController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("GererAdmin.htm")
    public ModelAndView welcome(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {

            return new ModelAndView("index");
        } else {
            String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount ";

            List<User> actors = new ArrayList<>();

            actors = jdtbcTemplate.query(sql,
                    new Object[]{1}, (ResultSet rs, int rowNum) -> {
                        User c = new User();
                        c.setMatricule(rs.getString(1));
                        c.setNom(rs.getString(2));
                        c.setPrenom(rs.getString(3));
                        c.setAdresse(rs.getString(4));
                        c.setTelephone(rs.getString(5));
                        c.setStatut(rs.getInt(7));
                        c.setIdprofil(new Profil(rs.getInt(8)));
                        try {
                            String encodeBase64 = Base64.encodeBase64String(rs.getBytes(6));
                            c.setImageId(encodeBase64);

                        } catch (Exception e) {
                        }
                        return c;
                    });

            mav.addObject("liste", actors);
        }

        return mav;
    }


    /**
     *
     * @param req
     * @return 
     */
    @RequestMapping(value = "AjouterAdmin.htm", method = RequestMethod.POST)
    public ModelAndView saveAdmin(HttpServletRequest req) {
        try {

            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setGenre(req.getParameter("genre"));

            Account account = new Account(1);

            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(req.getParameter("password"));
            profil.setUsername(req.getParameter("username"));
            user.setIdprofil(profil);

            String sql = "insert into profil values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername(),0);

            sql = "Select Max(id) from profil";
      
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
          
            }

            sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, "AD" + count, user.getGenre());

        } catch (Exception e) {
            System.out.println(e);
        }

        return mav;

    }

 
}
