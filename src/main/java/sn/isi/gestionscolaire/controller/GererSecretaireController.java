/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Anneacad;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.Note;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.Programme;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererSecretaireController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    List<Inscription> listeInscription;
    List<User> users;
    List<  Anneacad> an = new ArrayList<>();
    String id;
    int nbHommes;
    int nbFemmes;

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();

    /**
     *
     * @return
     */
    @RequestMapping("GererSecretaire.htm")
    public ModelAndView welcome() {
        String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount   ";

        List<User> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{3}, (ResultSet rs, int rowNum) -> {
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
    @RequestMapping(value = "AjouterSecretaire.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterSecretaire.htm");

    }

    /**
     *
     * @param req
     */
    @RequestMapping(value = "AjouterSecretaire.htm", method = RequestMethod.POST)
    public void saveAdmin(HttpServletRequest req) {
        try {

            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setGenre(req.getParameter("genre"));

            Account account = new Account(3);

            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(req.getParameter("password"));
            profil.setUsername(req.getParameter("username"));
            user.setIdprofil(profil);

            String sql = "insert into profil values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername(), 0);

            sql = "Select Max(id) from profil";
            boolean result = false;
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }

            sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, "SC" + count, user.getGenre());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     *
     * @return
     */
    @RequestMapping("gererNoteSec.htm")
    public ModelAndView gererNoteSec() {
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
        mav.setViewName("gererNoteSec");

        mav.addObject("annees", annees);

        return mav;
    }

    /**
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "gererNoteSec.htm", method = RequestMethod.POST)
    public ModelAndView listeClasseNotes(HttpServletRequest req) {
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
        if (req.getParameter("donnee").equalsIgnoreCase("1")) {
            mav.addObject("semestre", "1er Semestre");
            mav.addObject("numSemestre", 1);
        } else if (req.getParameter("donnee").equalsIgnoreCase("2")) {
            mav.addObject("semestre", "2ème Semestre");
            mav.addObject("numSemestre", 2);
        }
        mav.addObject("annee", req.getParameter("annee"));
         mav.addObject("idAcad", req.getParameter("idAcad"));
        mav.addObject("classes", classes);
        mav.setViewName("listeClasseNote");

        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("detailClasseNote.htm")
    public ModelAndView detailClasseNote(HttpServletRequest req) {

        nbFemmes = nbHommes = 0;
        String matriculeClasse = req.getParameter("matricule");
        String classeId = req.getParameter("id");
        String nomClasse = req.getParameter("nomClasse");
        String nomFiliere = req.getParameter("nomFiliere");
        String matricule = "";
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description,profil.id,inscription.validite,classes.matricule FROM user,inscription,classes,profil WHERE user.id=inscription.iduser and inscription.idclasse='" + classeId + "' AND profil.id=user.idprofil AND inscription.idclasse=classes.id";
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
                    s.setMatricule(rs.getString(12));
                    c.setIdclasse(s);

                    if ("Masculin".equals(rs.getString(6))) {
                        nbHommes++;
                    } else {

                        nbFemmes++;
                    }

                    return c;
                });
        if (!listeInscription.isEmpty()) {
            matricule = listeInscription.get(0).getIdclasse().getMatricule();
        }

        id = req.getParameter("id");

        sql = "SELECT  DISTINCT matiere.nom,  programme.idclasse ,programme.idmatiere ,programme.heures ,matiere.matricule,matiere.id from matiere,programme , classes  WHERE classes.id=? AND programme.idclasse=classes.id and matiere.id=programme.idmatiere";
        List<Programme> programmes = jdtbcTemplate.query(sql,
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
        mav.addObject("inscriptions", listeInscription);
        mav.addObject("users", users);
        mav.addObject("nomFiliere", nomFiliere);

        mav.addObject("nomClasse", nomClasse);
        mav.addObject("nbFeminin", nbFemmes);
        mav.addObject("nbMasculin", nbHommes);
        mav.addObject("matricule", matricule);
        mav.addObject("classeId", classeId);
        mav.addObject("effectif", nbFemmes + nbHommes);
        mav.setViewName("detailClasseNote");
        return mav;
    }

    
    
    
    /**
     *
     * @param req
     * @param rep
     * @return ModelView
     * @throws java.io.IOException
     */
    @RequestMapping(value = "detailClasseNote.htm", method = RequestMethod.POST)
    public ModelAndView gradeNote(HttpServletRequest req,HttpServletResponse rep) throws IOException {

        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.adresse,user.telephone,user.photo, inscription.matricule ,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser and classes.id=? AND inscription.idclasse=classes.id";
        String matiere = req.getParameter("donnee");
        String[] data = matiere.split("-");
        String idMatiere = data[0];
        String nomMatiere = data[1];

        List<Inscription> actors = jdtbcTemplate.query(
                sql,
                new Object[]{req.getParameter("id")},
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

        mav.addObject("findListEtudiants", actors);
        mav.addObject("nomMatiere", nomMatiere);

        mav.addObject("idMatiere", idMatiere);

        mav.setViewName("feuilleDeNote");
        rep.sendRedirect("feuilleDeNote.htm");
        return mav;
    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "feuilleDeNote.htm", method = RequestMethod.GET)
    public ModelAndView getNote(HttpServletRequest req) {

       

    
        mav.setViewName("feuilleDeNote");
        return mav;
    }

     List<Note> notes ;
      /**
     *
     * @param req
     * @param rep
     * @return ModelView
     * @throws java.io.IOException
     */
   
    @RequestMapping(value = "feuilleDeNote.htm", method = RequestMethod.POST)
    public ModelAndView saveNote(HttpServletRequest req,HttpServletResponse rep) throws IOException {

       
       String idUser=req.getParameter("idUser");
       
       String data=req.getParameter("data");
       String idClasse=req.getParameter("classeId");
       String idMatiere=req.getParameter("idMatiere");
       String semestre=req.getParameter("semestre");
       String idAcd=req.getParameter("idAcad");
         String [] idUs =idUser.split(",");
         String [] note =data.split("-");
         
              for (int i = 0; i < idUs.length; i++) {
                  System.out.println(idUs[i]);
              }
          for (int i = 0; i < note.length; i++) {
                  System.out.println(note[i]);
                  
              }
       
       int j=0;
   String    sql = "insert into note values (?,?,?,?,?,?,?,?,?)";
        for (int i = 0; i < idUs.length; i++) {
          
            try {
                
           
         jdtbcTemplate.update(sql, null, idAcd, semestre, idUs[i], idClasse, idMatiere, note[j], note[j+1], note[j+2]);
             
         
                     j=j+3;
                      } catch (Exception e) {
            }
        }
         
        
         sql ="SELECT distinct user.id ,user.prenom,user.nom,note.noteA,note.note2,note.examen FROM user,note,matiere,classes WHERE classes.id=? and matiere.id=? and semestre=? and idacad=? and note.idetudiant=user.id AND matiere.id=note.idmatiere AND note.idclasse=classes.id";
        notes = jdtbcTemplate.query(
                sql,
                new Object[]{idClasse,idMatiere,semestre,idAcd},
                new RowMapper<Note>() {
            public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                Note n = new Note();
                User c = new User();
                
            
                c.setNom(rs.getString(3));
                c.setPrenom(rs.getString(2));
                
                n.setIdetudiant(c);
                
                n.setNoteA(rs.getInt(4));
                n.setNote2(rs.getInt(5));
                n.setExamen(rs.getInt(6));
                

                return n;
            }
        });

       
       
        mav.addObject("notes", notes);
        mav.setViewName("releverNotes");
        rep.sendRedirect("releverNotes.htm");
        return mav;
    }

       /**
     *
     * @param req
     * @param rep
     * @return ModelView
     * @throws java.io.IOException
     */
    @RequestMapping(value = "releverNotes.htm")
    public ModelAndView relever(HttpServletRequest req,HttpServletResponse rep) throws IOException {
        
       mav.setViewName("releverNotes");
           mav.addObject("notes", notes);
        return mav;
    }

       /**
     *
     * @return 
     */
    @RequestMapping(value = "impression.htm")
    public ModelAndView impression() {
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
       
       mav.setViewName("impression");
       return mav;

    }

    
  /**
     *
     * @param req
     * @param req
     * @return 
     * @return  
     */
    @RequestMapping(value = "impression.htm",method = RequestMethod.POST)
    public ModelAndView impressionClasse( HttpServletRequest req) {
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
        if (req.getParameter("semestre").equalsIgnoreCase("1")) {
            mav.addObject("semestre", "1er Semestre");
            mav.addObject("numSemestre", 1);
        } else if (req.getParameter("semestre").equalsIgnoreCase("2")) {
            mav.addObject("semestre", "2ème Semestre");
            mav.addObject("numSemestre", 2);
        }
       
         mav.addObject("idAnnee", req.getParameter("idAnnee"));
              mav.addObject("acad", req.getParameter("acad"));
        mav.addObject("classes", classes);
        mav.setViewName("imprimerListeClasseNote");

        return mav;
    }
    
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("imprimerListeClasseNote.htm")
    public ModelAndView impressionDetailClasseNote(HttpServletRequest req) {

        nbFemmes = nbHommes = 0;
        String matriculeClasse = req.getParameter("matricule");
        String classeId = req.getParameter("id");
        String nomClasse = req.getParameter("nomClasse");
        String nomFiliere = req.getParameter("nomFiliere");
        String matricule = "";
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description,profil.id,inscription.validite,classes.matricule FROM user,inscription,classes,profil WHERE user.id=inscription.iduser and inscription.idclasse='" + classeId + "' AND profil.id=user.idprofil AND inscription.idclasse=classes.id";
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
                    s.setMatricule(rs.getString(12));
                    c.setIdclasse(s);
                     mav.addObject("acad", req.getParameter("acad")); 
                    if ("Masculin".equals(rs.getString(6))) {
                        nbHommes++;
                    } else {

                        nbFemmes++;
                    }

                    return c;
                });
        if (!listeInscription.isEmpty()) {
            matricule = listeInscription.get(0).getIdclasse().getMatricule();
        }

        id = req.getParameter("id");

        sql = "SELECT  DISTINCT matiere.nom,  programme.idclasse ,programme.idmatiere ,programme.heures ,matiere.matricule,matiere.id from matiere,programme , classes  WHERE classes.id=? AND programme.idclasse=classes.id and matiere.id=programme.idmatiere";
        List<Programme> programmes = jdtbcTemplate.query(sql,
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
        mav.addObject("inscriptions", listeInscription);
        mav.addObject("users", users);
        mav.addObject("nomFiliere", nomFiliere);

        mav.addObject("nomClasse", nomClasse);
        mav.addObject("nbFeminin", nbFemmes);
        mav.addObject("nbMasculin", nbHommes);
        mav.addObject("matricule", matricule);
        mav.addObject("classeId", classeId);
        mav.addObject("effectif", nbFemmes + nbHommes);
        mav.setViewName("impressionDetailClasseNote");
        return mav;
    }

    
    
    /**
     *
     * @param req
     * @param rep
     * @return ModelView
     * @throws java.io.IOException
     */
    @RequestMapping(value = "imprimerListeClasseNote.htm",method = RequestMethod.POST)
    public ModelAndView ClasseNote(HttpServletRequest req,HttpServletResponse rep) throws IOException, IOException {

        String matiere = req.getParameter("idMatiere");
        String[] data = matiere.split("-");
        String idMatiere = data[0];
        String nomMatiere = data[1];
        
       String    sql ="SELECT distinct user.id ,user.prenom,user.nom,note.noteA,note.note2,note.examen FROM user,note,matiere,classes WHERE classes.id=? and matiere.id=? and semestre=? and idacad=? and note.idetudiant=user.id AND matiere.id=note.idmatiere AND note.idclasse=classes.id";
        notes = jdtbcTemplate.query(
                sql,
                new Object[]{req.getParameter("classeId"),idMatiere,req.getParameter("semestre"),req.getParameter("idAnnee")},
                new RowMapper<Note>() {
            public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                Note n = new Note();
                User c = new User();
                
            
                c.setNom(rs.getString(3));
                c.setPrenom(rs.getString(2));
                
                n.setIdetudiant(c);
                
                n.setNoteA(rs.getInt(4));
                n.setNote2(rs.getInt(5));
                n.setExamen(rs.getInt(6));
                

                return n;
            }
        });

       
        mav.addObject("nomMatiere", nomMatiere);
        mav.addObject("acad", req.getParameter("acad")); 
       
        mav.addObject("notes", notes);
        mav.setViewName("releverNotes");
        rep.sendRedirect("releverNotes.htm");
       
        return mav;
    }
      /**
     *
     * @return 
     */
    @RequestMapping(value = "bulletin.htm")
    public ModelAndView bulletin() {
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
       
       mav.setViewName("bulletin");
       return mav;

    }
    
    
    
  /**
     *
     * @param req
     * @param req
     * @return 
     * @return  
     */
    @RequestMapping(value = "bulletin.htm",method = RequestMethod.POST)
    public ModelAndView impressionBulletinClasse( HttpServletRequest req) {
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
        if (req.getParameter("semestre").equalsIgnoreCase("1")) {
            mav.addObject("semestre", "1er Semestre");
            mav.addObject("numSemestre", 1);
        } else if (req.getParameter("semestre").equalsIgnoreCase("2")) {
            mav.addObject("semestre", "2ème Semestre");
            mav.addObject("numSemestre", 2);
        }
       
         mav.addObject("idAnnee", req.getParameter("idAnnee"));
              mav.addObject("acad", req.getParameter("acad"));
        mav.addObject("classes", classes);
        mav.setViewName("imprimerBulletinClasse");

        return mav;
    }

    
     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("imprimerBulletinDetailClasse.htm")
    public ModelAndView imprimerBulletinDetailClasse(HttpServletRequest req) {

        nbFemmes = nbHommes = 0;
        String matriculeClasse = req.getParameter("matricule");
        String classeId = req.getParameter("id");
        String nomClasse = req.getParameter("nomClasse");
        String nomFiliere = req.getParameter("nomFiliere");
        String matricule = "";
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description,profil.id,inscription.validite,classes.matricule FROM user,inscription,classes,profil WHERE user.id=inscription.iduser and inscription.idclasse='" + classeId + "' AND profil.id=user.idprofil AND inscription.idclasse=classes.id";
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
                    s.setMatricule(rs.getString(12));
                    c.setIdclasse(s);
                     mav.addObject("acad", req.getParameter("acad")); 
                    if ("Masculin".equals(rs.getString(6))) {
                        nbHommes++;
                    } else {

                        nbFemmes++;
                    }

                    return c;
                });
        if (!listeInscription.isEmpty()) {
            matricule = listeInscription.get(0).getIdclasse().getMatricule();
        }

        id = req.getParameter("id");

       
       
        mav.addObject("inscriptions", listeInscription);
        mav.addObject("users", users);
        mav.addObject("nomFiliere", nomFiliere);

        mav.addObject("nomClasse", nomClasse);
        mav.addObject("nbFeminin", nbFemmes);
        mav.addObject("nbMasculin", nbHommes);
        mav.addObject("matricule", matricule);
        mav.addObject("classeId", classeId);
        mav.addObject("effectif", nbFemmes + nbHommes);
        mav.setViewName("imprimerBulletinDetailClasse");
        return mav;
    }

    
     
    /**
     *
     * @param req
     * @param rep
     * @return ModelView
     * @throws java.io.IOException
     */
    @RequestMapping(value = "getNotesEtudiant.htm")
    public ModelAndView getNoteEtudiant(HttpServletRequest req,HttpServletResponse rep) throws IOException, IOException {

 
        
       String    sql ="SELECT DISTINCT matiere.nom ,user.prenom,user.nom,note.noteA,note.note2,note.examen FROM user,matiere,note,classes ,anneacad WHERE user.id=note.idetudiant and matiere.id=note.idmatiere AND note.idacad=anneacad.id AND note.idacad=? and user.id=? AND note.semestre=? AND classes.id=?" ;
        notes = jdtbcTemplate.query(
                sql,
                new Object[]{req.getParameter("idAnnee"),req.getParameter("idEtudiant"),req.getParameter("semestre"),req.getParameter("idClasse")},
                new RowMapper<Note>() {
            public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                Note n = new Note();
                User c = new User();
                
                Matiere m= new Matiere();
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

       
         mav.setViewName("getNotesEtudiant");
        mav.addObject("acad", req.getParameter("acad")); 
       
        mav.addObject("notes", notes);
     
       
       if(!notes.isEmpty())
       {
             mav.addObject("etu", notes.get(0));
       }
        return mav;
    }
    
}
