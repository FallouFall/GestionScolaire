/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
public class LoginController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    public ModelAndView mav = new ModelAndView();

    @RequestMapping("index.htm")
    public ModelAndView welcome(ModelAndView view) {

        return mav;
    }

    @RequestMapping(value = "index.htm", method = RequestMethod.POST)
    public ModelAndView Connecter(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String sql = "SELECT nom,prenom,adresse,telephone, photo, idaccount from user, profil,account where username=? AND password=? AND account.id=profil.idaccount and user.idprofil=profil.id";

        List<User> actors = jdtbcTemplate.query(
                sql,
                new Object[]{username, password},
                new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User c = new User();

                c.setNom(rs.getString(1));
                c.setPrenom(rs.getString(2));
                c.setAdresse(rs.getString(3));
                c.setTelephone(rs.getString(4));
                c.setPhoto(rs.getBytes(5));

                Profil p = new Profil();
                p.setUsername(username);
                p.setPassword(password);

                Account account = new Account(rs.getInt(6));
                p.setIdaccount(account);
                c.setIdprofil(p);

                HttpSession session = req.getSession();
                String encodeBase64 = Base64.encodeBase64String(c.getPhoto());
                session.setAttribute("photo", encodeBase64);
                session.setAttribute("user", c.getPrenom()+" "+c.getNom());
                session.setMaxInactiveInterval(30 * 60);
                
                        Cookie loginCookie = new Cookie("user","user");			
			loginCookie.setMaxAge(30*60);
			rep.addCookie(loginCookie);
                        
                      
                return c;
            }
        });
        String redirect = "redirect:/index.htm";

        if (actors.size() != 0) {
            switch (actors.get(0).getIdprofil().getIdaccount().getId()) {
                case 1:
                    redirect = "redirect:/administration.htm";
                    break;
                case 2:
                    redirect = "redirect:/comptable.htm";
                    break;
                case 3:
                    redirect = "redirect:/secretaire.htm";
                    break;
                case 4:
                    redirect = "redirect:/professeur.htm";
                    break;
                case 5:
                    redirect = "redirect:/directeur.htm";
                    break;
                case 6:
                    redirect = "redirect:/etudiant.htm";
                    break;
                default: {
                    // mav.addObject("Login ou Mot de pass invalid", null);
                    redirect = "redirect:/index.htm";
                    return new ModelAndView(redirect, "user", null);
                }
            }
        } else {
            redirect = "redirect:/index.htm";
        }
        return new ModelAndView(redirect, "user", actors.get(0));
    }

}
