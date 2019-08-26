/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import sn.isi.gestionscolaire.domain.Calendrier;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Documents;
import sn.isi.gestionscolaire.domain.Evenement;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.Programme;
import sn.isi.gestionscolaire.domain.Salle;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererProfesseurController {
   List<Documents> docs = new ArrayList<>();
    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
      List<User> actors ;

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();
    List<Classes> classes;
    List<Filiere> filieres;
       List<Matiere> matiere = new ArrayList<>();

    /**
     *
     * @return ModelView
     */
    @RequestMapping("documentsProf.htm")
    public ModelAndView upload() {
        mav.setViewName("documentsProf");
        return mav;
    }
    
    /**
     *
     * @return ModelView
     */
    @RequestMapping("AjouterDocuments.htm")
    public ModelAndView uploadDocum() {
           String sql = "SELECT * from matiere  ";
            matiere = jdtbcTemplate.query(sql,
                    new Object[]{}, (ResultSet rs, int rowNum) -> {
                        Matiere c = new Matiere();
                        c.setId(rs.getInt(1));
                        c.setMatricule(rs.getString(2));
                        c.setNom(rs.getString(3));
                        c.setCreation(rs.getDate(4));
                        c.setDescription(rs.getString(5));

                        return c;
                    });
           mav.addObject("matiere", matiere);
         
        mav.setViewName("AjouterDocuments");
        return mav;
    }
    
    /**
     *
     * @return ModelView
     */
    @RequestMapping("documentsMathProf.htm")
    public ModelAndView uploadMath() {
          String sql = "SELECT * from documents where idmatiere=?";
        docs = jdtbcTemplate.query(sql,
                new Object[]{1}, (ResultSet rs, int rowNum) -> {
                    Documents c = new Documents();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setPublue(rs.getString(3));
                    c.setNom(rs.getString(4));
                    c.setDate(rs.getDate(5));
                  try {
                        String encodeBase64 = Base64.encodeBase64String(rs.getBytes(6));
                        c.setCover(encodeBase64);
                       
                       
                    } catch (Exception e) {
                    }
                    return c;
                });
   
     


         mav.addObject("documents", docs);
        mav.setViewName("documentsMathProf");
        return mav;
    }
    
    /**
     *
     * @return ModelView
     */
    @RequestMapping("GererProfesseur.htm")
    public ModelAndView welcome() {

        String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";

         actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{4}, (ResultSet rs, int rowNum) -> {
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

        return mav;
    }

  /**
     *
     */
    @RequestMapping(value = "AjouterProfesseur.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterProfesseur.htm");

    }

    /**
     *
     * @param req
     */
    @RequestMapping(value = "AjouterProfesseur.htm", method = RequestMethod.POST)
    public ModelAndView saveAdmin(HttpServletRequest req) {
        try {

            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setGenre(req.getParameter("genre"));
                  user.setNaissance(req.getParameter("naissance"));
            user.setLog(0);
            Account account = new Account(4);

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

            sql = "insert into user values (?,?,?,?,?,?,?,?,?,?,?)";
              user.setMatricule("PROF" + count);
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, user.getMatricule(), user.getGenre(),user.getNaissance(),user.getLog());
               actors = new ArrayList<>();
               mav = new ModelAndView();
               actors.add(user);
               mav.addObject("liste", actors);              
               mav.setViewName("GererProfesseur");
        } catch (Exception e) {
            System.out.println(e);
        }
        return mav;
    }

    /**
     *
     * @param req
     * @param rep
     * @throws IOException
     */
    @RequestMapping(value = "GererProfesseur.htm", method = RequestMethod.POST)
      public void deconnection(HttpServletRequest req, HttpServletResponse rep) throws IOException {
HttpSession ses=req.getSession(false);
ses.invalidate();

        rep.sendRedirect("index.htm");

    }
    /**
     *
     * @return ModelView
     */
    @RequestMapping("gererNote.htm")
    public ModelAndView gradeNote() {
        mav.addObject("findListEtudiants", null);
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
                    c.setCreation(rs.getString(4));
                    c.setDescription(rs.getString(5));
                   

                    return c;
                });

        mav.addObject("classes", classes);
        mav.addObject("filieres", filieres);

        mav.setViewName("GradeBook");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "gererNote.htm", method = RequestMethod.GET)
    public ModelAndView findEtudiants(HttpServletRequest req) {
        mav.addObject("findListEtudiants", null);
        String classe = req.getParameter("classe");
  
       
 

       String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.adresse,user.telephone,user.photo, inscription.matricule ,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser and classes.description=? AND inscription.idclasse=classes.id";

        List<Inscription> actors = jdtbcTemplate.query(
                sql,
                new Object[]{classe},
                new RowMapper<Inscription>() {
            public Inscription mapRow(ResultSet rs, int rowNum) throws SQLException {
                Inscription ins = new Inscription();
                User c = new User();
                c.setId(rs.getInt(1));
                c.setMatricule(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setPrenom(rs.getString(4));
                c.setAdresse(rs.getString(5));
                c.setTelephone(rs.getString(6));
                c.setPhoto(rs.getBytes(7));
                
                ins.setMatricule(rs.getString(8));
                ins.setDate(rs.getDate(9));
                
                
                Classes cl = new Classes();
                cl.setDescription(rs.getString(10));
                
                ins.setIduser(c);
                ins.setIdclasse(cl);
           
               
             
                return ins;
            }
        });
        if (!actors.isEmpty()) {
            mav.addObject("findListEtudiants", actors);
                //   mav.addObject("nomClasse", actors.get(0).getIdclasse().getDescription());

        } else {
            mav.addObject("findListEtudiants", null);

        }
        
        mav.setViewName("GradeBook");
     
        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("professeur.htm")
    public ModelAndView accueilProfesseur() {

        mav.setViewName("AccueilProfesseur");
        return mav;
    }

    
     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("/programmeProf.htm")
    public ModelAndView gererProgramme(HttpServletRequest req) {
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
                    c.setCreation(rs.getString(4));
                    c.setDescription(rs.getString(5));
                    Filiere f = new Filiere();
                    f.setId(rs.getInt(6));

                    c.setFiliere(filieres.stream().filter(fil -> fil.getId() == f.getId()).findFirst().orElse(null));

                    return c;
                });

        mav.addObject("classes", classes);
        mav.setViewName("programmeProf");
        return mav;

    }
    
    
     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("/gererProgrammeProf.htm")
    public ModelAndView gererProgrammeOrof(HttpServletRequest req) {

     String id = req.getParameter("id");
        String classe = req.getParameter("classe");
        String filiere = req.getParameter("filiere");
        String sql = "SELECT    * from classes where id=? ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
        sql = "SELECT  DISTINCT matiere.nom,  programme.idclasse ,programme.idmatiere ,programme.heures ,matiere.matricule from matiere,programme , classes  WHERE classes.id=? AND programme.idclasse=classes.id and matiere.id=programme.idmatiere";
     List<Programme>   programmes = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Programme p = new Programme();

                    Classes cls = new Classes();
                    cls.setId(Integer.valueOf(id));
                    cls.setNom(rs.getString(1));
                    Matiere m = new Matiere();

                    m.setNom(rs.getString(1));
                    m.setMatricule(rs.getString(5));

                    p.setIdmatiere(m);
                    p.setHeures(rs.getInt(4));

                    return p;
                });

        mav = listeMatiere();
        mav.addObject("classes", classes);
        mav.addObject("programme", programmes);
        mav.addObject("classe", classe);
        mav.addObject("filiere", filiere);
        mav.setViewName("ProgrammeClassePro");
        return mav;

    }
    
     /**
     *
     * @return ModelView
     */
   
    public ModelAndView listeMatiere() {

        String sql = "SELECT * from matiere  ";
        matiere = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Matiere c = new Matiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
        mav.setViewName("ListeMatiere");
        mav.addObject("matieres", matiere);

        return mav;

    }
    
      /**
     *
     * @return ModelView
     */
    @RequestMapping("tableauProf.htm")
    public ModelAndView infos() {
        String sql = "SELECT * from evenement order by id desc limit 15;";

        List<Evenement> eve = jdtbcTemplate.query(
                sql,
                new Object[]{},
                new RowMapper<Evenement>() {
            public Evenement mapRow(ResultSet rs, int rowNum) throws SQLException {
                Evenement c = new Evenement();
                c.setId(rs.getInt(1));
                c.setTitre(rs.getString(2));
                c.setSoustitre(rs.getString(3));
                c.setDebut(rs.getString(4));
                c.setFin(rs.getString(5));
                c.setDescription(rs.getString(6));
                c.setLieu(rs.getString(7));

                return c;
            }
        });
        mav.addObject("evenements", eve);
        mav.setViewName("tableauProf");
        return mav;
    }
    
    
       /**
     *
     * @return ModelView
     */
    @RequestMapping("coursProf.htm")
    public ModelAndView coursPr(HttpServletRequest req) {
        HttpSession ses=req.getSession();
        String id=(String) ses.getAttribute("id");
       
        String sql = "SELECT  calendrier.jour ,calendrier.heure,salle.nom,matiere.nom ,classes.description FROM calendrier,salle,matiere ,user,classes WHERE\n" +
"calendrier.idmatiere=matiere.id AND calendrier.idsalle=salle.id AND calendrier.professeur=user.id AND \n" +
"user.id=? AND classes.id=calendrier.idclasse; ";

        List<Calendrier> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Calendrier c = new Calendrier();
                    c.setJour(rs.getString(1));
                    c.setHeure(rs.getString(2));
                    Salle s = new Salle();
                    s.setNom(rs.getString(3));
                     Classes ss = new Classes();
                    ss.setNom(rs.getString(5));
                        Matiere m = new Matiere();
                    m.setNom(rs.getString(4));
                    
                    c.setIdsalle(s);
                    c.setIdmatiere(m);
                    c.setIdclasse(ss);

                    return c;
                });
        mav.setViewName("courProf");
        mav.addObject("listeCour", actors);
     

        return mav;
    }
}
