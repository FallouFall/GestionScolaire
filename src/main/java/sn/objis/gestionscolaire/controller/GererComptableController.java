/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import org.apache.commons.codec.binary.Base64;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.objis.gestionscolaire.config.Connexion;
import sn.objis.gestionscolaire.domain.Account;
import sn.objis.gestionscolaire.domain.Classes;
import sn.objis.gestionscolaire.domain.Filiere;
import sn.objis.gestionscolaire.domain.Inscription;
import sn.objis.gestionscolaire.domain.Profil;
import sn.objis.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererComptableController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    public ModelAndView mav = new ModelAndView();
    List<Classes> classes;
    List<Filiere> filieres;
    List<Inscription> listeInscription;

    @RequestMapping("GererComptable.htm")
    public ModelAndView welcomes() {

        String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";

        List<User> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{2}, (ResultSet rs, int rowNum) -> {
                    User c = new User();
                    c.setMatricule(rs.getString(1));
                    c.setNom(rs.getString(2));
                    c.setPrenom(rs.getString(3));
                    c.setAdresse(rs.getString(4));
                    c.setTelephone(rs.getString(5));

                    try {
                        String encodeBase64 = Base64.encodeBase64String(rs.getBytes(6));
                        c.setImageId(encodeBase64);
                    } catch (Exception e) {
                    }
                    return c;
                });

        mav.addObject("liste", actors);

        return mav;
    }

    @RequestMapping(value = "AjouterComptable.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterComptable.htm");

    }

    @RequestMapping(value = "Mensualite.htm")
    public ModelAndView mensualite() {
        mav.addObject("findEtudiant", null);
        mav.setViewName("Mensualite");
        return mav;

    }

    @RequestMapping(value = "Mensualite.htm", method = RequestMethod.POST)
    public ModelAndView findEtudiant(HttpServletRequest req) {
        mav = new ModelAndView();
        String matricule = req.getParameter("matricule");
        String sql = "SELECT user.id,matricule,nom,prenom,adresse,telephone from user where user.matricule =?";

        List<User> actors = jdtbcTemplate.query(
                sql,
                new Object[]{matricule},
                new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User c = new User();
                c.setId(rs.getInt(1));
                c.setMatricule(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setPrenom(rs.getString(4));
                c.setAdresse(rs.getString(5));
                c.setTelephone(rs.getString(6));
                return c;
            }
        });
        if (!actors.isEmpty()) {
            mav.addObject("findEtudiant", actors.get(0));
            System.out.println("trouve");
        } else {
            mav.addObject("findEtudiant", null);
            System.out.println(" non trouve");
        }

        return mav;

    }

    @RequestMapping(value = "AjouterComptable.htm", method = RequestMethod.POST)
    public void saveAdmin(HttpServletRequest req) {
        try {
            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setTelephone(req.getParameter("mail"));

            Account account = new Account(2);

            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(req.getParameter("password"));
            profil.setUsername(req.getParameter("username"));
            user.setIdprofil(profil);

            String sql = "insert into profil values (?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername());

            sql = "Select Max(id) from profil";
            boolean result = false;
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }

            sql = "insert into user values (?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @RequestMapping(value = "InscriptionEtudiant.htm", method = RequestMethod.POST)
    public void saveEtudiant(HttpServletRequest req) {
        try {
            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setPhoto(null);
            user.setMatricule("ETU" + (int) (Math.random() * 9999999) + "");
            Account account = new Account(6);
            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(user.getMatricule());
            profil.setUsername(req.getParameter("mail"));
            user.setIdprofil(profil);

            String sql = "insert into profil values (?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername());

            sql = "Select Max(id) from profil";
            boolean result = false;
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }

            sql = "insert into user values (?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, user.getMatricule());

            Inscription inscription = new Inscription();
            inscription.setDate(java.sql.Date.valueOf(LocalDate.now()));
            inscription.setMatricule("INS" + (int) (Math.random() * 9999999) + "");

            String classe = req.getParameter("classe");
            String filiere = req.getParameter("filiere");

            Classes c = new Classes();
            for (Classes classe1 : classes) {
                if (classe1.getNom().equalsIgnoreCase(classe)) {
                    c = classe1;
                }
            }

            sql = "Select Max(id) from user";
            result = false;
            count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }
            user.setId(count);
            inscription.setIdclasse(c);
            inscription.setIduser(user);

            sql = "insert into inscription values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, inscription.getMatricule(), inscription.getDate(), inscription.getIdclasse().getId(), user.getId());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @RequestMapping("InscriptionEtudiant.htm")
    public ModelAndView listeFiliere(HttpServletRequest req) {
        String sql = "SELECT * from filiere  ";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });

        sql = "SELECT * from classes  ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
                    c.setInscription(rs.getInt(6));
                    c.setMensualite(rs.getInt(7));

                    return c;
                });

        mav.addObject("classes", classes);
        mav.setViewName("InscriptionEtudiant");

        mav.addObject("filieres", filieres);
        mav.setViewName("InscriptionEtudiant");
        return mav;
    }

    @RequestMapping("ListeInscription.htm")
    public ModelAndView listeInscription(HttpServletRequest req) {
        String sql = "SELECT User.matricule,User.nom,User.prenom, inscription.matricule,inscription.date,classes.nom ,filiere.nom  from user,inscription,classes,filiere WHERE user.id=inscription.id";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription c = new Inscription();
                    User u = new User();
                    u.setMatricule(rs.getString(1));
                    u.setNom(rs.getString(2));
                    u.setPrenom(rs.getString(3));
                    c.setMatricule(rs.getString(4));
                    c.setDate(rs.getDate(5));
                    Classes s = new Classes();
                    s.setNom(rs.getString(6));
                    Filiere f = new Filiere();
                    f.setNom(rs.getString(7));

                    s.setFiliere(f);
                    c.setIdclasse(s);
                    c.setIduser(u);

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);
        mav.setViewName("ListeInscription");
        return mav;
    }
 
}
