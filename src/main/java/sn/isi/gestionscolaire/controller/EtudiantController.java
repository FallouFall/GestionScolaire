/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import sn.isi.gestionscolaire.domain.Anneacad;
import sn.isi.gestionscolaire.domain.Calendrier;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Documents;
import sn.isi.gestionscolaire.domain.Evenement;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.Mensualite;
import sn.isi.gestionscolaire.domain.Note;
import sn.isi.gestionscolaire.domain.Questions;
import sn.isi.gestionscolaire.domain.Salle;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class EtudiantController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
    List<Mensualite> mens = new ArrayList<>();
    List<Documents> docs = new ArrayList<>();

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("etudiant.htm")
    public ModelAndView welcome(HttpServletRequest req,HttpServletResponse rep) throws IOException {
       HttpSession sessions = req.getSession();
              String log = (String) sessions.getAttribute("log");
       if(log.equalsIgnoreCase("0"))
        {
           rep.sendRedirect("changePassword.htm");
           mav.setViewName("changePassword");
        }
       else
       {
            mav.setViewName("AccueilEtudiant");
       }
         return  mav;
     
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("aide.htm")
    public ModelAndView aide(HttpServletRequest req) {
        HttpSession session = req.getSession();

        String id = (String) session.getAttribute("id");

        String sql = "SELECT questions.matricule,user.nom,user.prenom,user.id,questions.date,questions.statut, questions.id ,questions.description ,questions.reponse FROM questions,user WHERE questions.iduser=user.id and user.id=? ";

        List<Questions> questions = new ArrayList<>();

        questions = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Questions c = new Questions();
                    c.setMatricule(rs.getString(1));
                    User u = new User();
                    u.setNom(rs.getString(2));
                    u.setPrenom(rs.getString(3));
                    u.setId(rs.getInt(4));
                    c.setDate(rs.getDate(5));
                    c.setStatut(rs.getInt(6));
                    c.setIduser(u);
                    c.setId(rs.getInt(7));
                    c.setDescription(rs.getString(8));
                    c.setReponse(rs.getString(9));
                    return c;
                });

        mav.addObject("questions", questions);

        mav.setViewName("aide");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("monCalendrier.htm")
    public ModelAndView monCalendrier(HttpServletRequest req) {

        String sql = "SELECT * from filiere  ";
        List<Filiere> filieres = jdtbcTemplate.query(sql,
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
        List<Classes> classes = jdtbcTemplate.query(sql,
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
        mav.setViewName("monCalendrier");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("moncalendrierClasse.htm")
    public ModelAndView gererCalendrierClasse(HttpServletRequest req) {

        String sql = "SELECT calendrier.heure,calendrier.jour ,matiere.nom,salle.nom,user.nom,calendrier.professeur  FROM `calendrier`,matiere,user,salle WHERE idclasse = 1 AND calendrier.professeur= user.id and calendrier.idclasse= salle.id and calendrier.idmatiere= matiere.id;";

        List<Calendrier> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Calendrier c = new Calendrier();
                    c.setHeure(rs.getString(1));
                    c.setJour(rs.getString(2));
                    Matiere m = new Matiere();
                    m.setNom(rs.getString(3));
                    c.setIdmatiere(m);
                    Salle s = new Salle();
                    s.setNom(rs.getString(4));
                    c.setIdsalle(s);
                    User u = new User();
                    u.setNom(rs.getString(5));
                    c.setProfesseur(u);
                    return c;
                });

        mav.setViewName("monCalendrierClasse");

        mav.addObject("calendrier", actors);
        mav.addObject("clas", req.getParameter("nomClasse"));
        mav.addObject("fili", req.getParameter("nomFiliere"));
        return mav;

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("documents.htm")
    public ModelAndView documents() {

        mav.setViewName("documents");
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("demanderAide.htm")
    public ModelAndView demanderAide() {

        mav.setViewName("demanderAide");
        return mav;
    }

    /**
     *
     * @param req
     * @param rep
     * @throws IOException
     */
    @RequestMapping(value = "demanderAide.htm", method = RequestMethod.POST)
    public void demanderAide(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
        String reponse = req.getParameter("question");

        String mat = "QS" + (int) (Math.random() * 9999999) + "";

        String sql = "insert into questions values (?,?,?,?,?,?,?)";
        jdtbcTemplate.update(sql, null, mat, id, java.sql.Date.valueOf(LocalDate.now()), 0, reponse, "Pas encore de reponse");
        rep.sendRedirect("aide.htm");

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("tableau.htm")
    public ModelAndView annonces() {
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
        mav.setViewName("tableau");
        return mav;
    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping("documentsMath.htm")
    public ModelAndView documentsMath() {
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
        mav.setViewName("documentsMath");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("mesPayements.htm")
    public ModelAndView mesPayemets(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("id");
        String sql = "SELECT * from mensualite where idetudiant=?";

        mens = jdtbcTemplate.query(sql,
                new Object[]{userId}, (ResultSet rs, int rowNum) -> {
                    Mensualite c = new Mensualite();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setDate(rs.getDate(3));
                    c.setMois(rs.getString(4));
                    c.setPaye(rs.getInt(5));
                    c.setRestant(rs.getInt(6));

                    return c;
                });

        mav.addObject("mensualite", mens);
        mav.setViewName("MesPayements");
        return mav;
    }

    /**
     *
     * @param req
     * @param rep
     * @throws IOException
     */
    @RequestMapping(value = "etudiant.htm", method = RequestMethod.POST)
    public void deconnection(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        HttpSession ses = req.getSession(false);
        ses.invalidate();

        rep.sendRedirect("index.htm");

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("noteEtudiant.htm")
    public ModelAndView noteEtudiant(HttpServletRequest req) {
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

        mav.addObject("annees", annees);

        mav.setViewName("noteEtudiant");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "noteEtudiant.htm", method = RequestMethod.POST)
    public ModelAndView getAllnoteEtudiant(HttpServletRequest req) {

        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        String sql = "SELECT idclasse from inscription where iduser=? ";
        List<Classes> classes = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));

                    return c;
                });

        String idClasse = "";
        if (!classes.isEmpty()) {
            idClasse = classes.get(0).getId() + "";
            sql = "SELECT description from classes where id=? ";
            classes = jdtbcTemplate.query(sql,
                    new Object[]{idClasse}, (ResultSet rs, int rowNum) -> {
                        Classes c = new Classes();
                        c.setDescription(rs.getString(1));

                        return c;
                    });

        }
        if (!classes.isEmpty()) {

            sql = "SELECT DISTINCT matiere.nom ,user.prenom,user.nom,note.noteA,note.note2,note.examen FROM user,matiere,note,classes ,anneacad WHERE user.id=note.idetudiant and matiere.id=note.idmatiere AND note.idacad=anneacad.id AND note.idacad=? and user.id=? AND note.semestre=? AND classes.id=?";
            List<Note> notes = jdtbcTemplate.query(
                    sql,
                    new Object[]{req.getParameter("idAnnee"), id, req.getParameter("semestre"), idClasse},
                    new RowMapper<Note>() {
                public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Note n = new Note();
                    User c = new User();

                    Matiere m = new Matiere();
                    m.setNom(rs.getString(1));
                    c.setNom(rs.getString(3));
                    c.setPrenom(rs.getString(2));
                    n.setIdmatiere(m);
                    n.setIdetudiant(c);

                    n.setNoteA(rs.getInt(4));
                    n.setNote2(rs.getInt(5));
                    n.setExamen(rs.getInt(6));

                    return n;
                }
            });

            mav.addObject("nomClasse", classes.get(0).getDescription());
            mav.addObject("acad", req.getParameter("acad"));
            mav.addObject("notes", notes);
            mav.addObject("semestre", req.getParameter("semestre"));

            if (!notes.isEmpty()) {

                mav.addObject("etu", notes.get(0));
            }

        }
        mav.setViewName("getAllNotesEtudiant");
        return mav;
    }
}
