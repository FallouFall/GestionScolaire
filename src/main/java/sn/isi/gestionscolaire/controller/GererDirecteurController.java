/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
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
import sn.isi.gestionscolaire.domain.Anneacad;
import sn.isi.gestionscolaire.domain.Calendrier;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Cycle;
import sn.isi.gestionscolaire.domain.Domaine;
import sn.isi.gestionscolaire.domain.Droitinscription;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Formation;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.Programme;
import sn.isi.gestionscolaire.domain.Salle;
import sn.isi.gestionscolaire.domain.Typesalle;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererDirecteurController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();
    List<Matiere> matiere = new ArrayList<>();
    List<Filiere> filieres = new ArrayList<>();
    List<Salle> salles = new ArrayList<>();
    List<Typesalle> typeSalle = new ArrayList<>();
    List<Classes> classes = new ArrayList<>();
    List<Programme> programmes = new ArrayList<>();
    List<Inscription> listeInscription;
    List<User> users;
      List<Formation> listeForma;
 
    List<  Anneacad> an = new ArrayList<>();
    String id;
    int nbHommes;
    int nbFemmes;

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gererue.htm")
    public ModelAndView gererUe() {
        return new ModelAndView("GererUe");
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gererSalles.htm")
    public ModelAndView gererSalles() {
        
        
       
        
  String sql = "SELECT salle.id,salle.matricule,salle.nom,salle.creation,salle.description,salle.capacite,salle.superficie,typesalle.nom from salle,typesalle where salle.type=typesalle.id";
        salles = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Salle c = new Salle();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
                    c.setSuperficie(rs.getInt(7));
                    c.setCapacite(rs.getInt(6));
                    Typesalle t=new Typesalle();
                       t.setNom(rs.getString(8));
                       c.setType(t);

                    return c;
                });
        mav.setViewName("GererSalles");
        mav.addObject("listeSalle", salles);
      
        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("parametrerClasse.htm")
    public ModelAndView parametrerClasses() {
        String sql = "SELECT * from anneacad  ";
        List<  Anneacad> annees = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Anneacad c = new Anneacad();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
        mav.setViewName("parametrerClasseAcad");
        mav.addObject("annees", annees);
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "filiereParamClasse.htm")
    public ModelAndView filiereClasseParaClassee(HttpServletRequest req) {
      String sql = "SELECT  filiere.id,filiere.matricule,filiere.nom,filiere.creation,filiere.description ,cycle.nom ,cycle.id FROM filiere,cycle WHERE filiere.idcycle=cycle.id";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));

                    Cycle cy = new Cycle();
                    cy.setNom(rs.getString(6));
                    cy.setId(rs.getInt(7));
                    c.setIdcycle(cy);

                    return c;
                });

        mav.setViewName("filiereParamClasse");
        mav.addObject("filieres", filieres);

        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "classeParamClasse.htm")
    public ModelAndView classeClasseParam(HttpServletRequest req) {
        String sql = "SELECT * from classes where filiere =?  ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("id")}, (ResultSet rs, int rowNum) -> {
            Classes c = new Classes();
            c.setId(rs.getInt(1));
            c.setMatricule(rs.getString(2));
            c.setNom(rs.getString(3));
            c.setCreation(rs.getString(4));
            c.setDescription(rs.getString(5));

            return c;
        });
        mav.setViewName("classeParamClasse");
        mav.addObject("classes", classes);

        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "detailclasseParamClasse.htm")
    public ModelAndView detailclasseClasseParam(HttpServletRequest req) {
        try {
            
     
        String sql = "SELECT * from classes where id =?  ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("id")}, (ResultSet rs, int rowNum) -> {
            Classes c = new Classes();
            c.setId(rs.getInt(1));
            c.setMatricule(rs.getString(2));
            c.setNom(rs.getString(3));
            c.setCreation(rs.getString(4));
            c.setDescription(rs.getString(5));

            return c;
        });
        mav.setViewName("detailclasseParamClasse");
        mav.addObject("classes", classes.get(0));
        mav.addObject("idclasse", classes.get(0).getId());
           } catch (Exception e) {
        }
        return mav;

    }
    
    
    
     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "ajouterDroitIns.htm")
    public ModelAndView ajouterDrt() {
       
        mav.setViewName("ajouterDroitIns");
      
        return mav;

    }

     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "ajouterDroitIns.htm", method = RequestMethod.POST)
    public ModelAndView ajouterDrtInscription(HttpServletRequest req) {
        try {
            
      
   
        String matricule = ("DRT" + (int) (Math.random() * 9999999));
       
        String sql = "insert into  droitinscription values (?,?,?,?)";
        jdtbcTemplate.update(sql, null, matricule,req.getParameter("inscription"),req.getParameter("mensualite"));

        Droitinscription d= new Droitinscription();
        d.setMatricule(matricule);
        d.setInscription(Integer.valueOf(req.getParameter("inscription")));
        d.setMensualite(Integer.valueOf(req.getParameter("mensualite")));
         mav.setViewName("modalite");
         List<Droitinscription> drt= new ArrayList<>();
         drt.add(d);
         
          mav.addObject("droit", drt);
            } catch (Exception e) {
        }
         return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "detailclasseParamClasse.htm", method = RequestMethod.POST)
    public ModelAndView getdetailclasseClasseParam(HttpServletRequest req) {

        String sql = "SELECT * from droitinscription  ";
        List<Droitinscription> drt = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Droitinscription c = new Droitinscription();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setInscription(rs.getInt(3));
                    c.setMensualite(rs.getInt(4));

                    return c;
                });
        mav.setViewName("droitInscription");
        mav.addObject("droit", drt);
        mav.addObject("classe", req.getParameter("idClasse"));
        mav.addObject("nbmois", req.getParameter("nbmois"));
        mav.addObject("ouverture", req.getParameter("ouverture"));
        mav.addObject("mensualite", req.getParameter("mensualite"));
        mav.addObject("inscription", req.getParameter("inscription"));
        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gererdomaines.htm")
    public ModelAndView gestionDomaines() {
        String sql = "SELECT * from domaine  ";
        List<  Domaine> domaines = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Domaine c = new Domaine();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
        mav.setViewName("gererdomaines");
        mav.addObject("domaines", domaines);
        return mav;
    }

    
      /**
     *
     * @return ModelView
     */
    @RequestMapping("gererformations.htm")
    public ModelAndView gestionFormation() {
        String sql = "SELECT formation.id,formation.matricule,formation.nom,formation.date,formation.description,domaine.nom from formation,domaine where formation.iddomaine=domaine.id  ";
        listeForma = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Formation c = new Formation();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));
                   Domaine d= new Domaine();
                   d.setNom(rs.getString(6));
                   c.setIddomaine(d);

                    return c;
                });
        mav.setViewName("gererFormation");
        mav.addObject("formations", listeForma);
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gerercycles.htm")
    public ModelAndView gestionCycle() {
        String sql = "SELECT * from cycle ";
        List<  Cycle> cycle = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Cycle c = new Cycle();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
        mav.setViewName("gerercycles");
        mav.addObject("cycles", cycle);
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gereracad.htm")
    public ModelAndView gestionsAnnee() {
        String sql = "SELECT * from anneacad  ";
        List<  Anneacad> annees = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Anneacad c = new Anneacad();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));

                    return c;
                });
        mav.setViewName("gereracad");
        mav.addObject("annees", annees);
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("ajouterAcad.htm")
    public ModelAndView ajouterAnnee() {

        mav.setViewName("AjouterAcad");

        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "ajouterAcad.htm", method = RequestMethod.POST)
    public ModelAndView ajouterAnneeAcad(HttpServletRequest req) {

        String nom = req.getParameter("nom");
        String date = req.getParameter("date");
        String matricule = ("ACAD" + (int) (Math.random() * 9999999));
        String description = req.getParameter("description");

        String sql = "insert into  anneacad values (?,?,?,?,?)";
        jdtbcTemplate.update(sql, null, matricule, nom, date, description);

        return gestionsAnnee();
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("ajouterCycles.htm")
    public ModelAndView ajouterCycle() {

        mav.setViewName("AjouterCycles");
        String sql = "SELECT * from domaine  ";
        List<  Domaine> an = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Domaine c = new Domaine();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });

        mav.addObject("domaine", an);
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("ajouterDomaines.htm")
    public ModelAndView ajouterDomaine() {
        String sql = "SELECT * from anneacad  ";
        an = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Anneacad c = new Anneacad();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });

        mav.addObject("annee", an);
        mav.setViewName("AjouterDomaine");

        return mav;
    }

    
      /**
     *
     * @return ModelView
     */
    @RequestMapping("ajouterFormation.htm")
    public ModelAndView ajouterFormation() {
        String sql = "SELECT * from domaine  ";
      List<Domaine>  dom = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Domaine c = new Domaine();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });

        mav.addObject("domaine", dom);
        
        mav.setViewName("AjouterFormation");

        return mav;
    }
     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "ajouterFormation.htm", method = RequestMethod.POST)
    public ModelAndView ajouterForm(HttpServletRequest req) {
        Formation f=new Formation();
        f.setNom(req.getParameter("nom"));
     
     f.setDescription(req.getParameter("description")); 
        String acad = req.getParameter("id");
        Domaine d=new Domaine();
        d.setNom(req.getParameter("nomFor"));
        f.setIddomaine(d);

        f.setDate(req.getParameter("date"));
       f.setMatricule("FOR" + (int) (Math.random() * 9999999));
        String sql = "insert into formation values (?,?,?,?,?,?)";

        jdtbcTemplate.update(sql, null, f.getMatricule(), f.getNom(), f.getDate(), f.getDescription(), acad);
        
      listeForma= new ArrayList<>();
      listeForma.add(f);
      mav.setViewName("gererFormation");
      mav.addObject("formations", listeForma);

        return mav;
    }
    
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "ajouterDomaines.htm", method = RequestMethod.POST)
    public ModelAndView ajouterDomaines(HttpServletRequest req) {

        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        String acad = req.getParameter("id");

        String date = req.getParameter("date");
        String matricule = ("DOM" + (int) (Math.random() * 9999999));
        String sql = "insert into domaine values (?,?,?,?,?,?)";

        jdtbcTemplate.update(sql, null, matricule, nom, date, description, acad);

        return gestionDomaines();
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "ajouterCycles.htm", method = RequestMethod.POST)
    public ModelAndView ajouterCycles(HttpServletRequest req) {

        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        String domaine = req.getParameter("id");

        String date = req.getParameter("date");
        String matricule = ("CYL" + (int) (Math.random() * 9999999));
        String sql = "insert into cycle values (?,?,?,?,?,?)";

        jdtbcTemplate.update(sql, null, matricule, nom, date, description, domaine);

        return gestionCycle();
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gererClasses.htm")
    public ModelAndView gestionsClasses() {
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
                    c.setOuverture(rs.getString(8));
                    c.setNbmois(rs.getInt(9));

                    c.setFiliere(filieres.stream().filter(fil -> fil.getId() == f.getId()).findFirst().orElse(null));

                    return c;
                });

        mav.addObject("classes", classes);
        mav.setViewName("ListeClasses");
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("programme.htm")
    public ModelAndView Programme() {

        mav = gestionsClasses();
        mav.setViewName("programme");
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("calendrierClasse.htm")
    public ModelAndView gererCalendrierClasse(HttpServletRequest req) {
        
           String sql = "SELECT calendrier.heure,calendrier.jour ,matiere.nom,salle.nom,user.nom,calendrier.professeur  FROM `calendrier`,matiere,user,salle WHERE idclasse = ? AND calendrier.professeur= user.id and calendrier.idclasse= salle.id and calendrier.idmatiere= matiere.id;";

        List<Calendrier> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("id")}, (ResultSet rs, int rowNum) -> {
                    Calendrier c = new Calendrier();
                    c.setHeure(rs.getString(1));
                    c.setJour(rs.getString(2));
                    Matiere m=  new Matiere();
                    m.setNom(rs.getString(3));
                    c.setIdmatiere(m);
                    Salle s= new Salle();
                    s.setNom(rs.getString(4));
                    c.setIdsalle(s);
                    User u= new User();
                     u.setNom(rs.getString(5));
                     c.setProfesseur(u);
                    return c;
                });

        
        
        
        mav.setViewName("calendrierClasse");
        
        mav.addObject("calendrier", actors);
        mav.addObject("clas", req.getParameter("nomClasse"));
        mav.addObject("fili", req.getParameter("nomFiliere"));
        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("gererCalendrier.htm")
    public ModelAndView gererCalendrier() {

        mav = gestionsClasses();
        mav.setViewName("gererCalendrier");

        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("planifierCour.htm")
    public ModelAndView planifierCour() {

        mav = gestionsClasses();

        mav.setViewName("planifierCour");

        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "plageHoraire.htm", method = RequestMethod.POST)
    public ModelAndView listeProfDispo(HttpServletRequest req) {

        String sql = "SELECT DISTINCT user.matricule, user.nom, user.prenom,  user.adresse, user.telephone,user.id  from user , enseigne where enseigne.idprofesseur = user.id";

        List<User> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    User c = new User();
                    c.setMatricule(rs.getString(1));
                    c.setNom(rs.getString(2));
                    c.setPrenom(rs.getString(3));
                    c.setAdresse(rs.getString(4));
                    c.setTelephone(rs.getString(5));
                    c.setId(rs.getInt(6));
                    return c;
                });

        mav.setViewName("ListeProfDispo");
        mav.addObject("lpd", actors);
        mav.addObject("idClasse", req.getParameter("idClasse"));
        mav.addObject("idMatiere", req.getParameter("idMatiere"));
        mav.addObject("nomMatiere", req.getParameter("nomMatiere"));
        mav.addObject("jour", req.getParameter("jour"));
        mav.addObject("heure", req.getParameter("heure"));
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "listeSalleDispo.htm")
    public ModelAndView listeSallDispo(HttpServletRequest req) {

        String sql = "SELECT * from salle";
        salles = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Salle c = new Salle();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(5));
                    c.setDescription(rs.getString(4));
                    c.setSuperficie(rs.getInt(6));
                    c.setCapacite(rs.getInt(7));

                    return c;
                });
        mav.setViewName("ListeSalleDispo");
        mav.addObject("listeSalledispo", salles);
        mav.addObject("idProf", req.getParameter("idProf"));
        mav.addObject("prof", req.getParameter("prof"));
        mav.addObject("classe", req.getParameter("classe"));
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("plageHoraire.htm")
    public ModelAndView plageHoraire(HttpServletRequest req) {

        mav.setViewName("plageHoraire");
        mav.addObject("idClasse", req.getParameter("idClasse"));
        mav.addObject("classe", req.getParameter("classe"));
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("confirmerCour.htm")
    public ModelAndView confirmerCour(HttpServletRequest req) {

        mav.setViewName("confirmerCour");
        mav.addObject("idClasse", req.getParameter("idClasse"));
        mav.addObject("classe", req.getParameter("classe"));
        mav.addObject("jour", req.getParameter("jour"));
        mav.addObject("heure", req.getParameter("heure"));
        mav.addObject("idSalle", req.getParameter("idSalle"));
        mav.addObject("prof", req.getParameter("prof"));
        mav.addObject("idProf", req.getParameter("idProf"));
        mav.addObject("nomSalle", req.getParameter("nomSalle"));
          mav.addObject("idMatiere", req.getParameter("idMatiere"));
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("detailInscription.htm")
    public ModelAndView detailIscription(HttpServletRequest req) {

    
        String matricule = req.getParameter("idInscription");
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.adresse,user.telephone,user.photo, inscription.matricule ,inscription.date,classes.description ,profil.id,inscription.validite FROM user,inscription,classes,profil WHERE user.id=inscription.iduser and inscription.matricule=? AND inscription.idclasse=classes.id";

        List<Inscription> actors = jdtbcTemplate.query(
                sql,
                new Object[]{matricule},
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
                c.setIdprofil(new Profil(rs.getInt(11)));
                ins.setValidite(rs.getInt(12));
                ins.setIduser(c);
                ins.setIdclasse(cl);

                return ins;
            }
        });
        String photoEtudiant = Base64.encodeBase64String(actors.get(0).getIduser().getPhoto());
        mav.addObject("photoEtudiant", photoEtudiant);
        mav.addObject("inscription", actors.get(0));
        mav.setViewName("detailInscription");
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "cancel.htm", method = RequestMethod.GET)
    public ModelAndView cAnCEL(HttpServletRequest req) {

   
        String sql;
        String cancel = req.getParameter("cancel");

        if (cancel.equalsIgnoreCase("0")) {
            System.out.println(cancel);
            sql = "update inscription set validite=? where matricule=?";
            jdtbcTemplate.update(sql, 0, req.getParameter("idInscription"));

            sql = "update profil set statut=? where id=?";
            jdtbcTemplate.update(sql, 0, req.getParameter("profilId"));
        }
        sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.date,classes.description,inscription.validite,profil.id FROM user,inscription,classes,profil WHERE user.id=inscription.iduser\n"
                + "AND inscription.idclasse=classes.id   and profil.id=user.idprofil";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription c = new Inscription();
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setMatricule(rs.getString(2));
                    u.setNom(rs.getString(3));
                    u.setPrenom(rs.getString(4));
                    u.setTelephone(rs.getString(5));
                    c.setMatricule(rs.getString(6));
                    c.setDate(rs.getDate(7));
                    Classes s = new Classes();
                    s.setDescription(rs.getString(8));

                    c.setValidite(rs.getInt(9));
                    u.setIdprofil(new Profil(rs.getInt(10)));

                    c.setIdclasse(s);
                    c.setIduser(u);

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);

        mav.setViewName("validerInscription");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "detailInscription.htm", method = RequestMethod.POST)
    public ModelAndView activerInscription(HttpServletRequest req) {

        String validite = req.getParameter("validite");
        String sql;
        String cancel = req.getParameter("cancel");
        if (validite.equalsIgnoreCase("0")) {
            sql = "update inscription set validite=? where matricule=?";
            jdtbcTemplate.update(sql, 1, req.getParameter("idInscription"));

            sql = "update profil set statut=? where id=?";
            jdtbcTemplate.update(sql, 1, req.getParameter("profilId"));
        } else if (validite.equalsIgnoreCase("1")) {
            sql = "update inscription set validite=? where matricule=?";
            jdtbcTemplate.update(sql, 0, req.getParameter("idInscription"));

            sql = "update profil set statut=? where id=?";
            jdtbcTemplate.update(sql, 0, req.getParameter("profilId"));
        } else if (validite.equalsIgnoreCase("3")) {
            sql = "update inscription set validite=? where matricule=?";
            jdtbcTemplate.update(sql, 1, req.getParameter("idInscription"));

            sql = "update profil set statut=? where id=?";
            jdtbcTemplate.update(sql, 1, req.getParameter("profilId"));
        } else if (cancel.equalsIgnoreCase("0")) {
            System.out.println(cancel);
            sql = "update inscription set validite=? where matricule=?";
            jdtbcTemplate.update(sql, 0, req.getParameter("idInscription"));

            sql = "update profil set statut=? where id=?";
            jdtbcTemplate.update(sql, 0, req.getParameter("profilId"));
        }
        sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.date,classes.description,inscription.validite,profil.id FROM user,inscription,classes,profil WHERE user.id=inscription.iduser\n"
                + "AND inscription.idclasse=classes.id   and profil.id=user.idprofil";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription c = new Inscription();
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setMatricule(rs.getString(2));
                    u.setNom(rs.getString(3));
                    u.setPrenom(rs.getString(4));
                    u.setTelephone(rs.getString(5));
                    c.setMatricule(rs.getString(6));
                    c.setDate(rs.getDate(7));
                    Classes s = new Classes();
                    s.setDescription(rs.getString(8));

                    c.setValidite(rs.getInt(9));
                    u.setIdprofil(new Profil(rs.getInt(10)));

                    c.setIdclasse(s);
                    c.setIduser(u);

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);

        mav.setViewName("validerInscription");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "gererProgramme.htm", method = RequestMethod.POST)
    public ModelAndView addToProgramme(HttpServletRequest req) {
        try {

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

            Programme programme = new Programme();
            programme.setHeures(Integer.valueOf(req.getParameter("heures")));
            programme.setIdclasse(new Classes(Integer.valueOf(req.getParameter("id"))));
            programme.setIdmatiere(new Matiere(Integer.valueOf(req.getParameter("idMatiere"))));
       

            sql = "insert into programme values (?,?,?,?)";
            System.out.println(programme.getIdmatiere().getId());
            jdtbcTemplate.update(sql, null, programme.getIdclasse().getId(), programme.getIdmatiere().getId(), programme.getHeures());

        } catch (Exception e) {
            System.out.println(e);
        }

        return gererProgramme(req);

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("planifierProgramme.htm")
    public ModelAndView planifierProgramme(HttpServletRequest req) {

        id = req.getParameter("idClasse");

        String sql = "SELECT  DISTINCT matiere.nom,  programme.idclasse ,programme.idmatiere ,programme.heures ,matiere.matricule,matiere.id from matiere,programme , classes  WHERE classes.id=? AND programme.idclasse=classes.id and matiere.id=programme.idmatiere";
        programmes = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Programme p = new Programme();

                    Classes cls = new Classes();
                    cls.setId(Integer.valueOf(id));
                    cls.setNom(rs.getString(1));
                    Matiere m = new Matiere();

                    m.setNom(rs.getString(1));
                    m.setMatricule(rs.getString(5));
                    m.setId(rs.getInt(6));
                    p.setIdmatiere(m);
                    p.setHeures(rs.getInt(4));

                    return p;
                });

        mav.addObject("programme", programmes);
        mav.addObject("classe", req.getParameter("classe"));
        mav.addObject("idClasse", req.getParameter("idClasse"));
        mav.setViewName("planifierProgramme");
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("/gererProgramme.htm")
    public ModelAndView gererProgramme(HttpServletRequest req) {

     id = req.getParameter("id");
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
        sql = "SELECT  DISTINCT matiere.nom,  programme.idclasse ,programme.idmatiere ,programme.heures ,matiere.matricule,matiere.coefficient from matiere,programme , classes  WHERE classes.id=? AND programme.idclasse=classes.id and matiere.id=programme.idmatiere";
        programmes = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Programme p = new Programme();

                    Classes cls = new Classes();
                    cls.setId(Integer.valueOf(id));
                    cls.setNom(rs.getString(1));
                    Matiere m = new Matiere();

                    m.setNom(rs.getString(1));
                    m.setMatricule(rs.getString(5));
                    m.setCoefficient(rs.getInt(6));

                    p.setIdmatiere(m);
                    p.setHeures(rs.getInt(4));

                    return p;
                });

        mav = listeMatiere();
        mav.addObject("classes", classes);
        mav.addObject("programme", programmes);
        mav.addObject("classe", classe);
        mav.addObject("filiere", filiere);
        mav.setViewName("gererProgramme");
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("GererDirecteur.htm")
    public ModelAndView welcome(HttpServletRequest req) {

        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {

            return new ModelAndView("index");
        } else {
            String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";
            List<User> actors = new ArrayList<>();
            actors = jdtbcTemplate.query(sql,
                    new Object[]{5}, (ResultSet rs, int rowNum) -> {
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
     * @return ModelView
     */
    @RequestMapping("AjouterSalle.htm")
    public ModelAndView addSalle() {
 String sql = "SELECT * from typesalle";
        typeSalle = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Typesalle c = new Typesalle();
                    c.setId(rs.getInt(1));
                    c.setNom(rs.getString(2));
                  

                    return c;
                });
        mav.addObject("type", typeSalle);
        mav.setViewName("AjouterSalle");
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "AjouterSalle.htm", method = RequestMethod.POST)
    public ModelAndView saveSalle(HttpServletRequest req) {
        try {

            Salle s = new Salle();
            s.setNom(req.getParameter("nomSalle"));
            s.setDescription(req.getParameter("descriptionSalle"));
            s.setMatricule("SAL" + (int) (Math.random() * 9999999));
            s.setCreation(java.sql.Date.valueOf(LocalDate.now()));
            s.setSuperficie(Integer.valueOf(req.getParameter("superficie")));
            s.setCapacite(Integer.valueOf(req.getParameter("capacite")));
            
             s.setType(new Typesalle(Integer.valueOf(req.getParameter("idType"))));
            String sql = "insert into salle values (?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, s.getMatricule(), s.getNom(), s.getDescription(), s.getCreation(), s.getSuperficie(), s.getCapacite(),s.getType().getId());
        mav.setViewName("GererSalles");
        salles =new ArrayList<>();
        salles.add(s);
          mav.addObject("listeSalle", salles);
        } catch (Exception e) {
            System.out.println(e);
        }
     
      
        return mav;

    }
 /**
     *
     */
    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.GET)
    public void ajouterDirecteur() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterDirecteur.htm");

    }
   
    /**
     *
     * @param req
     */
    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.POST)
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
            Account account = new Account(5);

            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(req.getParameter("password"));
            profil.setUsername(req.getParameter("username"));
            user.setIdprofil(profil);

            String sql = "insert into profil values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername(), 0);

            sql = "Select Max(id) from profil";
     
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
            
            }
            user.setMatricule( "DG" + count);
            sql = "insert into user values (?,?,?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count,user.getMatricule(), user.getGenre(),user.getNaissance(),user.getLog());
               users = new ArrayList<>();
               mav = new ModelAndView();
               users.add(user);
               mav.addObject("liste", users);              
               mav.setViewName("GererDirecteur");
        } catch (Exception e) {
            System.out.println(e);
        }
        return  mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "gererue.htm", method = RequestMethod.POST)
    public ModelAndView saveMatiere(HttpServletRequest req) {
        try {

            Matiere matiere = new Matiere();
            matiere.setNom(req.getParameter("nomMatiere"));
            matiere.setDescription(req.getParameter("descriptionMatiere"));
            matiere.setMatricule("MTR" + (int) (Math.random() * 9999999));
            matiere.setCreation(java.sql.Date.valueOf(LocalDate.now()));
            String sql = "insert into matiere values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, matiere.getMatricule(), matiere.getNom(), matiere.getCreation(), matiere.getDescription());

        } catch (Exception e) {
            System.out.println(e);
        }
        return listeMatiere();

    }

//    @RequestMapping(value = "AjouterSalle.htm", method = RequestMethod.POST)
//    public ModelAndView saveClasse(HttpServletRequest req) {
//        try {
//
//            Salle salle = new Salle();
//            salle.setNom(req.getParameter("nomSalle"));
//            salle.setDescription(req.getParameter("descriptionSalle"));
//            salle.setMatricule("SAL" + (int) (Math.random() * 9999999));
//            salle.setCreation(java.sql.Date.valueOf(LocalDate.now()));
//            salle.setSuperficie(Integer.valueOf(req.getParameter("superficie")));
//            salle.setCapacite(Integer.valueOf(req.getParameter("capacite")));
//            String sql = "insert into salle values (?,?,?,?,?,?,?)";
//            jdtbcTemplate.update(sql, null, salle.getMatricule(), salle.getNom(), salle.getCreation(), salle.getDescription(), salle.getSuperficie(), salle.getCapacite());
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return new ModelAndView("GererUe");
//
//    }
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "listeMatiere.htm", method = RequestMethod.POST)
    public ModelAndView saveMatieres(HttpServletRequest req) {
        try {

            Matiere matiere = new Matiere();
            matiere.setNom(req.getParameter("nomMatiere"));
            matiere.setDescription(req.getParameter("descriptionMatiere"));
            matiere.setMatricule("MTR" + (int) (Math.random() * 9999999));
            matiere.setCreation(java.sql.Date.valueOf(LocalDate.now()));
            matiere.setCoefficient(Integer.valueOf(req.getParameter("coef").trim()));
            String sql = "insert into matiere values (?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, matiere.getMatricule(), matiere.getNom(), matiere.getCreation(), matiere.getDescription(),matiere.getCoefficient());

        } catch (Exception e) {
            System.out.println(e);
        }

        return listeMatiere();

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "AjouterFiliere.htm", method = RequestMethod.POST)
    public ModelAndView saveFilieres(HttpServletRequest req) {
        try {

            Filiere filiere = new Filiere();
            filiere.setNom(req.getParameter("nomFiliere"));
            filiere.setDescription(req.getParameter("descriptionFiliere"));
            filiere.setMatricule("FLR" + (int) (Math.random() * 9999999));
            filiere.setCreation(java.sql.Date.valueOf(LocalDate.now()));
            String sql = "insert into filiere values (?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, filiere.getMatricule(), filiere.getNom(), filiere.getCreation(), filiere.getDescription(), req.getParameter("id"));
            filieres.add(filiere);
        } catch (Exception e) {
            System.out.println(e);
        }

        return listeFiliere();

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "GererClasseFiliere.htm", method = RequestMethod.POST)
    public ModelAndView saveFiliere(HttpServletRequest req) {
        try {

            Filiere filiere = new Filiere();
            filiere.setNom(req.getParameter("nomFiliere"));
            filiere.setDescription(req.getParameter("descriptionFiliere"));
            filiere.setMatricule("FLR" + (int) (Math.random() * 9999999));
            filiere.setCreation(java.sql.Date.valueOf(LocalDate.now()));
            String sql = "insert into filiere values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, filiere.getMatricule(), filiere.getNom(), filiere.getCreation(), filiere.getDescription());
            filieres.add(filiere);
        } catch (Exception e) {
            System.out.println(e);
        }
        return listeFiliere();

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "listeMatiere.htm")
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
                      c.setCoefficient(rs.getInt(6));
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
    @RequestMapping(value = "addClasse.htm")
    public ModelAndView addClassee() {
         String sql = "SELECT  filiere.id,filiere.matricule,filiere.nom,filiere.creation,filiere.description ,cycle.nom ,cycle.id FROM filiere,cycle WHERE filiere.idcycle=cycle.id";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));

                    Cycle cy = new Cycle();
                    cy.setNom(rs.getString(6));
                    cy.setId(rs.getInt(7));
                    c.setIdcycle(cy);

                    return c;
                });

        mav.setViewName("addClasse");
        mav.addObject("filieres", filieres);

        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "savedetailClasseParam.htm")
    public ModelAndView savedetailClassePara(HttpServletRequest req) {

        mav.setViewName("savedetailclasseParam");
        mav.addObject("ouverture", req.getParameter("ouverture"));
        mav.addObject("inscription", req.getParameter("inscription"));
        mav.addObject("mensualite", req.getParameter("mensualite"));
        mav.addObject("mois", req.getParameter("mois"));
        mav.addObject("idClasse", req.getParameter("idClasse"));
        mav.addObject("idDroit", req.getParameter("idDroit"));
        return mav;

    }

     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "confirmerCour.htm", method = RequestMethod.POST)
    public ModelAndView confirsaveEMploi(HttpServletRequest req) {
       
        String sql = "insert into calendrier values (?,?,?,?,?,?,?)";
          int i =0;
      i =jdtbcTemplate.update(sql,null,req.getParameter("idMatiere"), req.getParameter("jour"), req.getParameter("heure"),req.getParameter("idProf"),req.getParameter("idSalle"),req.getParameter("idClasse"));
     if (i != 0) {
            mav.addObject("ajoutProgramme", " AjoutReussi");
             mav.addObject("ajoutProgrammeRes",i);
            mav.addObject("idClasse", req.getParameter("idClasse"));
        mav.addObject("classe", req.getParameter("classe"));
        mav.addObject("jour", req.getParameter("jour"));
        mav.addObject("heure", req.getParameter("heure"));
        mav.addObject("idSalle", req.getParameter("idSalle"));
        mav.addObject("prof", req.getParameter("prof"));
        mav.addObject("idProf", req.getParameter("idProf"));
        mav.addObject("nomSalle", req.getParameter("nomSalle"));
          mav.addObject("idMatiere", req.getParameter("idMatiere"));
        } else {
            mav.addObject("ajoutProgramme", "Non Reussi");
        }
      
        return mav;

    }

    
    
    
    
    
    
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "savedetailClasseParam.htm", method = RequestMethod.POST)
    public ModelAndView confirsavedetailClassePara(HttpServletRequest req) {

        String sql = "update classes set droitIns = ?,nbmois= ?,ouverture= ? where id = ? ";
        int i = 0;
        i = jdtbcTemplate.update(sql, req.getParameter("idDroit"), req.getParameter("mois"), req.getParameter("ouverture") ,req.getParameter("idClasse"));

        mav.setViewName("resultclasseParam");
        if (i != 0) {
            mav.addObject("update", "Reussi");
        } else {
            mav.addObject("update", "Non Reussi");
        }
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "saisirClasse.htm")
    public ModelAndView saisirClassee(HttpServletRequest req) {

        mav.setViewName("saisirClasse");
        mav.addObject("nomFiliere", req.getParameter("nomFiliere"));
        mav.addObject("idFiliere", req.getParameter("id"));
          mav.addObject("cycle", req.getParameter("cycle"));
        return mav;

    }

    /**
     *
     * @param req
     * @param rep
     * @return ModelView
     * @throws java.io.IOException
     */
    @RequestMapping(value = "saisirClasse.htm", method = RequestMethod.POST)
    public ModelAndView saisiriNFOClassee(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        mav.setViewName("confirmerClasse");
        mav.addObject("nom", req.getParameter("nom"));
        mav.addObject("date", req.getParameter("date"));
        mav.addObject("description", req.getParameter("description"));
        mav.addObject("matricule", "CLS" + (int) (Math.random() * 9999999));
        mav.addObject("inscription", req.getParameter("inscription"));
        mav.addObject("mensualite", req.getParameter("mensualite"));
        mav.addObject("nomFiliere", req.getParameter("nomFiliere"));
        mav.addObject("idFiliere", req.getParameter("idFiliere"));
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     * @throws java.text.ParseException
     */
    @RequestMapping(value = "confirmerClasse.htm")
    public ModelAndView confirmerClasse(HttpServletRequest req) throws ParseException {
        String sql = "insert into classes values (?,?,?,?,?,?,?,?,?)";

//        jdtbcTemplate.update(sql, null, req.getParameter("matricule"), req.getParameter("nom"),
//                req.getParameter("date"), req.getParameter("description"),
//                req.getParameter("idFiliere"),1,null,null);
              mav.setViewName("imprimerAjoutClasse");
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "gererfiliere.htm")
    public ModelAndView listeFiliere() {

        String sql = "SELECT  filiere.id,filiere.matricule,filiere.nom,filiere.creation,filiere.description ,cycle.nom ,cycle.id FROM filiere,cycle WHERE filiere.idcycle=cycle.id";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));

                    Cycle cy = new Cycle();
                    cy.setNom(rs.getString(6));
                    cy.setId(rs.getInt(7));
                    c.setIdcycle(cy);

                    return c;
                });

        mav.setViewName("ListeFiliere");

        mav.addObject("filieres", filieres);

        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "AjouterFiliere.htm")
    public ModelAndView ajouterFiliere() {

        String sql = "SELECT * from cycle ";
        List<  Cycle> cycle = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Cycle c = new Cycle();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });

        mav.setViewName("AjouterFiliere");
        mav.addObject("cycles", cycle);

        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("validerInscription.htm")
    public ModelAndView validerInscription(HttpServletRequest req) {
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.date,classes.description,inscription.validite,profil.id FROM user,inscription,classes,profil WHERE user.id=inscription.iduser\n"
                + "AND inscription.idclasse=classes.id   and profil.id=user.idprofil";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription c = new Inscription();
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setMatricule(rs.getString(2));
                    u.setNom(rs.getString(3));
                    u.setPrenom(rs.getString(4));
                    u.setTelephone(rs.getString(5));
                    c.setMatricule(rs.getString(6));
                    c.setDate(rs.getDate(7));
                    Classes s = new Classes();
                    s.setDescription(rs.getString(8));

                    c.setValidite(rs.getInt(9));
                    u.setIdprofil(new Profil(rs.getInt(10)));

                    c.setIdclasse(s);
                    c.setIduser(u);

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);
        mav.setViewName("validerInscription");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("detailClasse.htm")
    public ModelAndView detailClasse(HttpServletRequest req) {

        nbFemmes = nbHommes = 0;
       
        String classeId = req.getParameter("id");
        String nomClasse = req.getParameter("nomClasse");
        String nomFiliere = req.getParameter("nomFiliere");

        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description,profil.id,inscription.validite FROM user,inscription,classes,profil WHERE user.id=inscription.iduser and inscription.idclasse='" + classeId + "' AND profil.id=user.idprofil AND inscription.idclasse=classes.id";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription c = new Inscription();
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setMatricule(rs.getString(2));
                    u.setNom(rs.getString(3));
                    u.setPrenom(rs.getString(4));
                    u.setTelephone(rs.getString(5));
                    c.setMatricule(rs.getString(6));
                    c.setDate(rs.getDate(8));
                    Profil p = new Profil(rs.getInt(10));
                    u.setIdprofil(p);
                    c.setValidite(rs.getInt(11));
                    c.setIduser(u);
                    Classes s = new Classes();
                    s.setDescription(rs.getString(9));
                    s.setNom(rs.getString(9));
                    c.setIdclasse(s);

                    if ("Masculin".equals(rs.getString(6))) {
                        nbHommes++;
                    } else {

                        nbFemmes++;
                    }

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);
        mav.addObject("users", users);
        mav.addObject("nomFiliere", nomFiliere);
        mav.addObject("nomClasse", nomClasse);
        mav.addObject("nbFeminin", nbFemmes);
        mav.addObject("nbMasculin", nbHommes);
        mav.addObject("classeId", classeId);
          mav.addObject("ouverture", req.getParameter("ouverture"));
        mav.addObject("nbmois", req.getParameter("nbmois"));
        mav.addObject("effectif", nbFemmes + nbHommes);
        mav.setViewName("detailClasse");
        return mav;
    }

    /**
     *
     * @return 
     */
    @RequestMapping(value = "statdirecteur.htm")
    public ModelAndView statistique() {

        String sql = "SELECT id, nom from filiere  ";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setNom(rs.getString(2));

                    return c;
                });

        sql = "SELECT id, matricule,description from classes  ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setDescription(rs.getString(3));

                    return c;
                });
        sql = "SELECT classes.filiere ,inscription.idclasse from inscription,classes,filiere WHERE filiere.id=classes.filiere AND inscription.idclasse=classes.id ";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription ins = new Inscription();
                    Filiere fl = new Filiere();
                    Classes cls = new Classes();
                    cls.setId(rs.getInt(2));
                    fl.setId(rs.getInt(1));
                    cls.setFiliere(fl);
                    ins.setIdclasse(cls);
                    return ins;
                });

        int tab[] = new int[filieres.size()];
  
        int i = 0;
        for (Filiere filiere : filieres) {
            int cpt = 0;
            for (Inscription inscription : listeInscription) {

                if (inscription.getIdclasse().getFiliere().getId() == filiere.getId()) {
                    cpt++;
                }

            }
            tab[i] = cpt;
            i++;

        }

        int tabclasse[] = new int[classes.size()];

        int j = 0;
        for (Classes classe : classes) {
            int cpt = 0;
            for (Inscription inscription : listeInscription) {

                if (inscription.getIdclasse().getId() == classe.getId()) {
                    cpt++;
                }

            }
            tabclasse[j] = cpt;
            j++;

        }

        mav.setViewName("StatDirecteur");
        mav.addObject("filieres", filieres);
        mav.addObject("classes", classes);
        mav.addObject("nbParClasse", tabclasse);
        mav.addObject("nbInscriptions", tab);
        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("listeProfeMatiere.htm")
    public ModelAndView listeprof(HttpServletRequest req) {

        String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id,user.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";

        List<User> actors = new ArrayList<>();

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
                    c.setId(rs.getInt(9));

                    try {
                        String encodeBase64 = Base64.encodeBase64String(rs.getBytes(6));
                        c.setImageId(encodeBase64);
                    } catch (Exception e) {
                    }
                    return c;
                });
        mav.addObject("affecter", "");
        mav.setViewName("ListeProfMatiere");
        mav.addObject("liste", actors);
     
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "listeMatiereProf.htm")
    public ModelAndView listeMatiereProf(HttpServletRequest req) {

        String sql = "SELECT * from matiere  ";
        matiere = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Matiere c = new Matiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
                    c.setCoefficient(rs.getInt(6));

                    return c;
                });

        mav.setViewName("ListeMatiereProf");
        mav.addObject("matieres", matiere);
           mav.addObject("nomProf", req.getParameter("nomProf"));
            mav.addObject("prenomProf", req.getParameter("prenomProf"));
                mav.addObject("matriculeProf", req.getParameter("matriculeProf"));

        return mav;

    }

    /**
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "listeMatiereProf.htm", method = RequestMethod.POST)
    public ModelAndView validerAjoutMatiereProf(HttpServletRequest req) {
        try {
            
      
        String data = req.getParameter("data");
        data = data.replaceAll("[<>\\[\\],-]", "");
        data = data.substring(1);
        List<Matiere> m=new ArrayList<>();
        for (Matiere mat : matiere) {
              for (int i = 0; i < data.length(); i++) {
              if(Integer.parseInt(data.charAt(i)+ "") == mat.getId())
              {
                  m.add(mat);
              }
          }
            
        }
        

        String sql = "insert into enseigne values (?,?,?)";
        for (int i = 0; i < data.length(); i++) {

            jdtbcTemplate.update(sql, null, Integer.parseInt(data.charAt(i) + ""), req.getParameter("idProf"));
        }

        mav.setViewName("confirmerAssignation");
        mav.addObject("matAssi", m);
      } catch (Exception e) {
        }
        return mav;

    }

}
