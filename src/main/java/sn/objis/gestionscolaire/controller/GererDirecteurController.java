/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

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
import sn.objis.gestionscolaire.config.Connexion;
import sn.objis.gestionscolaire.domain.Account;
import sn.objis.gestionscolaire.domain.Classes;
import sn.objis.gestionscolaire.domain.Filiere;
import sn.objis.gestionscolaire.domain.Inscription;
import sn.objis.gestionscolaire.domain.Matiere;
import sn.objis.gestionscolaire.domain.Profil;
import sn.objis.gestionscolaire.domain.Programme;
import sn.objis.gestionscolaire.domain.Salle;
import sn.objis.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererDirecteurController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
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

    @RequestMapping("gererue.htm")
    public ModelAndView gererUe() {
        return new ModelAndView("GererUe");
    }

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

    @RequestMapping("programme.htm")
    public ModelAndView Programme() {

        mav = gestionsClasses();
        mav.setViewName("programme");
        return mav;

    }

    @RequestMapping("gererCalendrier.htm")
    public ModelAndView gererCalendrier() {

        mav = gestionsClasses();
        mav.setViewName("gererCalendrier");
        return mav;

    }

    @RequestMapping("detailInscription.htm")
    public ModelAndView detailIscription(HttpServletRequest req) {

        String userId = req.getParameter("id");
        String matricule = req.getParameter("matricule");
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.adresse,user.telephone  from user,classes,inscription WHERE classes.matricule='" + matricule + "' AND inscription.iduser=user.id;";

        List<User> actors = jdtbcTemplate.query(
                sql,
                new Object[]{userId},
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

                Account account = new Account(rs.getInt(8));
                account.setType(rs.getString(9));
                p.setIdaccount(account);
                c.setIdprofil(p);
                return c;
            }
        });
        if (!actors.isEmpty()) {
            mav.addObject("inscription", actors.get(0));
        }
        listeInscription.stream().filter((detail) -> (detail.getMatricule().equals(req.getParameter("idInscription")))).forEachOrdered((detail) -> {
            mav.addObject("detail", detail);
        });
        mav.setViewName("detailInscription");
        return mav;

    }

    @RequestMapping(value = "detailInscription.htm", method = RequestMethod.POST)
    public ModelAndView activerInscription(HttpServletRequest req) {

        String sql = "update inscription set validite=? where matricule=?";
        jdtbcTemplate.update(sql, 1, req.getParameter("idInscription"));
        mav.setViewName("validerInscription");
        return mav;
    }

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
        mav.setViewName("gererProgramme");
        return mav;

    }

    @RequestMapping("GererDirecteur.htm")
    public ModelAndView welcome() {

        String sql = "SELECT matricule,nom,prenom,adresse,telephone, photo, idaccount from user, profil,account where account.id=profil.idaccount and user.idprofil=profil.id and account.id=? ";
        List<User> actors = new ArrayList<>();
        actors = jdtbcTemplate.query(sql,
                new Object[]{5}, (ResultSet rs, int rowNum) -> {
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
        System.out.println(actors);
        mav.addObject("liste", actors);

        return mav;
    }

    @RequestMapping("AjouterSalle.htm")
    public ModelAndView addSalle() {

        mav.setViewName("AjouterSalle");
        return mav;

    }

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

    @RequestMapping(value = "AjouterDirecteur.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterDirecteur.htm");

    }

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

            String sql = "insert into profil values (?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername());

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

    @RequestMapping("validerInscription.htm")
    public ModelAndView validerInscription(HttpServletRequest req) {
        String sql = "SELECT User.id,User.matricule,User.nom,User.prenom, inscription.matricule,inscription.date,classes.nom ,filiere.nom  from user,inscription,classes,filiere WHERE user.id=inscription.id";
        listeInscription = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Inscription c = new Inscription();
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setMatricule(rs.getString(2));
                    u.setNom(rs.getString(3));
                    u.setPrenom(rs.getString(4));
                    c.setMatricule(rs.getString(5));
                    c.setDate(rs.getDate(6));
                    Classes s = new Classes();
                    s.setNom(rs.getString(7));
                    Filiere f = new Filiere();
                    f.setNom(rs.getString(8));

                    s.setFiliere(f);
                    c.setIdclasse(s);
                    c.setIduser(u);

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);
        mav.setViewName("validerInscription");
        return mav;
    }

    @RequestMapping("detailClasse.htm")
    public ModelAndView detailClasse(HttpServletRequest req) {

        nbFemmes = nbHommes = 0;
        String matriculeClasse = req.getParameter("matricule");
        String classeId = req.getParameter("id");
        String nomClasse = req.getParameter("nomClasse");
        String nomFiliere = req.getParameter("nomFiliere");

        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser and classes.id='"+classeId+"'";
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

    @RequestMapping(value = "GererDirecteur.htm", method = RequestMethod.POST)
    public void deconnection(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    loginCookie = cookie;

                    break;
                }
            }
        }

        if (loginCookie != null) {
            loginCookie.setMaxAge(0);
            rep.addCookie(loginCookie);
        }
        rep.sendRedirect("index.htm");

    }
    
  @RequestMapping(value = "printInscriptions.htm", method = RequestMethod.GET)
  @ResponseBody
  public void getRpt1(HttpServletResponse response) throws JRException, IOException {
      try {
         
   
    InputStream jasperStream = this.getClass().getResourceAsStream("/Classes.jasper");
    Map<String,Object> params = new HashMap<>();
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
  JRBeanCollectionDataSource ds=new JRBeanCollectionDataSource(listeInscription);

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
