/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

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
import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class LoginController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();

    /**
     *
     * @param view
     * @param req
     * @return
     */
    @RequestMapping("index.htm")
    public ModelAndView welcome(ModelAndView view, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {

            return new ModelAndView("index");
        } else {
            return new ModelAndView("index");
        }
    }

    /**
     *
     * @param view
     * @param req
     * @return
     */
    @RequestMapping("forget.htm")
    public ModelAndView forget(ModelAndView view, HttpServletRequest req) {
        mav=new ModelAndView();
    mav.setViewName("resetPassword");
    return  mav;
    }

    
    
    
    
    
     /**
     *
     * @param req
     * @param rep
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "forget.htm", method = RequestMethod.POST)
    public ModelAndView reserPassword(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        String username = req.getParameter("username");
        String matricule = req.getParameter("matricule");

        String sql = "SELECT profil.password from user, profil,account where username=? AND user.matricule=? AND account.id=profil.idaccount and user.idprofil=profil.id";

        List<User> actors = jdtbcTemplate.query(
                sql,
                new Object[]{username, matricule},
                new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User c = new User();
              

                Profil p = new Profil();
           
                p.setPassword(rs.getString(1));
         
                c.setIdprofil(p);

          

                return c;
            }
        });
        String redirect = "redirect:/index.htm";

        if (actors.size() != 0) {
            mav.setViewName("resetPassword");
            String paString=actors.get(0).getIdprofil().getPassword();
            int lenght=paString.length();
            paString=paString.substring(0, lenght-3);
            mav.addObject("error","Le mot de passe de votre compte est   "+ paString+"***");
            return mav;
            }
            else
            {
            mav.setViewName("resetPassword");
            mav.addObject("error", "  Aucun compte correspondant trouve");
        }

      return mav;

    }

    /**
    
     @RequestMapping("forget.htm")
    public ModelAndView forget(ModelAndView view, HttpServletRequest req) {
    mav.setViewName("resetPassword");
    return  mav;
    }

    
    /**
     *
     * @param req
     * @param rep
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "index.htm", method = RequestMethod.POST)
    public ModelAndView Connecter(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String sql = "SELECT user.id,matricule,nom,prenom,adresse,telephone, photo, idaccount,type,profil.id,profil.statut from user, profil,account where username=? AND password=? AND account.id=profil.idaccount and user.idprofil=profil.id";

        List<User> actors = jdtbcTemplate.query(
                sql,
                new Object[]{username, password},
                new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User c = new User();
                c.setId(rs.getInt(1));
                c.setMatricule(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setPrenom(rs.getString(4));
                c.setAdresse(rs.getString(5));
                c.setTelephone(rs.getString(6));
                c.setPhoto(rs.getBytes(7));

                Profil p = new Profil();
                p.setId(rs.getInt(10));
                p.setUsername(username);
                p.setPassword(password);
                p.setStatut(rs.getString(11));

                Account account = new Account(rs.getInt(8));
                account.setType(rs.getString(9));
                p.setIdaccount(account);
                c.setIdprofil(p);

                HttpSession session = req.getSession();
                String encodeBase64 = Base64.encodeBase64String(c.getPhoto());

                //session
                session.setAttribute("photo", encodeBase64);
                session.setAttribute("user", c.getPrenom() + " " + c.getNom());
                session.setAttribute("nom", c.getNom());
                session.setAttribute("id", c.getId() + "");
                session.setAttribute("idprofil", p.getId() + "");

                session.setAttribute("prenom", c.getPrenom());
                session.setAttribute("adresse", c.getAdresse());
                session.setAttribute("telephone", c.getTelephone());
                session.setAttribute("adresse", c.getAdresse());
                session.setAttribute("login", c.getIdprofil().getUsername());
                session.setAttribute("password", c.getIdprofil().getPassword());
                session.setAttribute("profil", c.getIdprofil().getIdaccount().getType());

                session.setMaxInactiveInterval(30 * 600);

                Cookie loginCookie = new Cookie("user", "user");
                loginCookie.setMaxAge(30 * 600);
                rep.addCookie(loginCookie);

                return c;
            }
        });
        String redirect = "redirect:/index.htm";

        if (actors.size() != 0) {
            if(actors.get(0).getIdprofil().getStatut().equalsIgnoreCase("0"))
            {
            mav.setViewName("index");
            mav.addObject("error", " Votre Compte est  Verrouller");
            return mav;
            }
            else
            {
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
            }
        } else {
            redirect = "redirect:/index.htm";

        }
        HttpSession session = req.getSession();
        session.setAttribute("url", redirect.substring(10));
        if (actors.isEmpty() == true) {

            mav.setViewName("index");
            mav.addObject("error", "Login ou Mot de Passe Incorrecte");
            return mav;
            // return new ModelAndView("redirect:/index.htm", "user", null);
        }

        return new ModelAndView(redirect, "user", actors.get(0));

    }

}
