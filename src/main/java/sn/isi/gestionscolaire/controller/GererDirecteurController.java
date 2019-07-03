/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Classes;
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
    List<Classes> classes = new ArrayList<>();
    List<Programme> programmes = new ArrayList<>();
    List<Inscription> listeInscription;
    List<User> users;
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
        mav.setViewName("GererSalles");
        mav.addObject("listeSalle", salles);

        return mav;

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
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
                    Filiere f = new Filiere();
                    f.setId(rs.getInt(8));

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
     * @param req
     * @return ModelView
     */
    @RequestMapping("detailInscription.htm")
    public ModelAndView detailIscription(HttpServletRequest req) {
       
        String userId = req.getParameter("id");
        String matricule = req.getParameter("idInscription");
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.adresse,user.telephone,user.photo, inscription.matricule ,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser and inscription.matricule=? AND inscription.idclasse=classes.id";

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
                
                ins.setIduser(c);
                ins.setIdclasse(cl);
           
               
             
                return ins;
            }
        });
         String photoEtudiant = Base64.encodeBase64String(actors.get(0).getIduser().getPhoto());
            mav.addObject("photoEtudiant",photoEtudiant);
     mav.addObject("inscription",actors.get(0));
     mav.setViewName("detailInscription");
        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "detailInscription.htm", method = RequestMethod.POST)
    public ModelAndView activerInscription(HttpServletRequest req) {

        String sql = "update inscription set validite=? where matricule=?";
        jdtbcTemplate.update(sql, 1, req.getParameter("idInscription"));
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
            String mat = req.getParameter("nomMatiere");
            matiere.stream().filter((mat1) -> (mat1.getNom().equalsIgnoreCase(mat))).forEachOrdered((mat1) -> {
                programme.setIdmatiere(mat1);
            });

            sql = "insert into programme values (?,?,?,?)";

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
    @RequestMapping("/gererProgramme.htm")
    public ModelAndView gererProgramme(HttpServletRequest req) {

        id = req.getParameter("id");
        String sql = "SELECT * from classes where id=? ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{id}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
                    Filiere f = new Filiere();
                    f.setId(rs.getInt(8));

                    c.setFiliere(filieres.stream().filter(fil -> fil.getId() == f.getId()).findFirst().orElse(null));

                    return c;
                });
        sql = "SELECT  programme.idmatiere ,programme.heures, programme.idclasse  from programme  JOIN classes on programme.idclasse=classes.id WHERE classes.id=?";
        programmes = jdtbcTemplate.query(sql,
                new Object[]{2}, (ResultSet rs, int rowNum) -> {
                    Programme p = new Programme();

                    Classes cls = new Classes();
                    cls.setId(Integer.valueOf(id));
                    cls.setNom(rs.getString(1));
                    Matiere m = new Matiere();
                    m.setId(rowNum);
                    m.setNom(rs.getString(2));
                    p.setIdclasse(cls);
                    p.setIdmatiere(m);
                    p.setHeures(rs.getInt(3));

                    return p;
                });

        mav = listeMatiere();
        mav.addObject("classes", classes);
        mav.addObject("programme", programmes);
        mav.addObject("cls", classes.get(0));
        mav.addObject("fl", classes.get(0).getFiliere().getNom());
        mav.setViewName("gererProgramme");
        return mav;

    }

    /**
     *
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
            String sql = "insert into salle values (?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, s.getMatricule(), s.getNom(), s.getDescription(), s.getCreation(), s.getSuperficie(), s.getCapacite());

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView("AjouterSalle");

    }

    /**
     *
     */
    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterDirecteur.htm");

    }

    /**
     *
     * @param req
     */
    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.POST)
    public void saveAdmin(HttpServletRequest req) {
        try {

            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setGenre(req.getParameter("genre"));

            Account account = new Account(5);

            Profil profil = new Profil();
            profil.setIdaccount(account);
            profil.setPassword(req.getParameter("password"));
            profil.setUsername(req.getParameter("username"));
            user.setIdprofil(profil);

            String sql = "insert into profil values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername(),0);

            sql = "Select Max(id) from profil";
            boolean result = false;
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }

            sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, "DG" + count, user.getGenre());
        } catch (Exception e) {
            System.out.println(e);
        }
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
            String sql = "insert into matiere values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, matiere.getMatricule(), matiere.getNom(), matiere.getCreation(), matiere.getDescription());

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
    @RequestMapping(value = "gererfiliere.htm", method = RequestMethod.POST)
    public ModelAndView saveFilieres(HttpServletRequest req) {
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
    @RequestMapping(value = "gererfiliere.htm")
    public ModelAndView listeFiliere() {
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
        mav.setViewName("ListeFiliere");
        mav.addObject("filieres", filieres);

        return mav;

    }

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("validerInscription.htm")
    public ModelAndView validerInscription(HttpServletRequest req) {
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser\n" +
"AND inscription.idclasse=classes.id";
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
        String matriculeClasse = req.getParameter("matricule");
        String classeId = req.getParameter("id");
        String nomClasse = req.getParameter("nomClasse");
        String nomFiliere = req.getParameter("nomFiliere");

        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser and inscription.idclasse='"+classeId+"' AND inscription.idclasse=classes.id";
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
        mav.addObject("effectif", nbFemmes + nbHommes);
        mav.setViewName("detailClasse");
        return mav;
    }

  

    /**
     *
     * @param response
     * @throws JRException
     * @throws IOException
     */
    @RequestMapping(value = "printInscriptions.htm", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt1(HttpServletResponse response) throws JRException, IOException {
        try {

            InputStream jasperStream = this.getClass().getResourceAsStream("/Classes.jasper");
            Map<String, Object> params = new HashMap<>();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser ";
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
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listeInscription);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ds);
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=inscription.pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
