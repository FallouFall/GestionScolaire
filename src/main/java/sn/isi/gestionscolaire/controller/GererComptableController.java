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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Mensualite;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererComptableController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());

    /**
     *
     */
    public ModelAndView mav = new ModelAndView();
    List<Classes> classes;
    List<Filiere> filieres;
    List<Inscription> listeInscription;
    int idUser;
    int idClasse;
    int idFiliere;
    int payement;
    Inscription ins = null;
    LocalDate date = LocalDate.now();

    /**
     *
     * @return ModelView
     */
    @RequestMapping("GererComptable.htm")
    public ModelAndView welcomes() {

        String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";

        List<User> actors = new ArrayList<>();

        actors = jdtbcTemplate.query(sql,
                new Object[]{2}, (ResultSet rs, int rowNum) -> {
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
    @RequestMapping(value = "AjouterComptable.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterComptable.htm");

    }

    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "Mensualite.htm")
    public ModelAndView mensualite() {
        mav.addObject("findEtudiant", null);
        mav.setViewName("Mensualite");
        return mav;

    }

    
    
    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "controlePaye.htm")
    public ModelAndView controlePaye() {
        String  sql = "SELECT id, matricule,description from classes  ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));           
                    c.setMatricule(rs.getString(2));
                    c.setDescription(rs.getString(3));
               

                    return c;
                });
        mav.addObject("classes",classes);
           mav.addObject("paye", null);
        mav.setViewName("ControlePaye");
         mav.addObject("mensualite", null);
        return mav;

    }
    
    
    
     @RequestMapping(value = "controlePaye.htm",method = RequestMethod.GET)
    public ModelAndView controlePayement(HttpServletRequest req,HttpServletResponse response) throws IOException {
        
       
      
        String sql = "SELECT  mensualite.matricule,mensualite.date,mensualite.paye,mensualite.restant,user.nom,user.prenom,user.telephone,user.matricule FROM user,mensualite,classes WHERE mensualite.idetudiant=user.id and classes.description=? and mensualite.idclasse=classes.id and mois=? ";
        
      String ms =req.getParameter("mois");
          String cls =req.getParameter("classe");
        List<Mensualite> mens = jdtbcTemplate.query(sql,
                new Object[]{cls,ms}, (ResultSet rs, int rowNum) -> {
                    Mensualite c = new Mensualite();
                    
                    c.setMatricule(rs.getString(1));
                    c.setDate(rs.getDate(2));
                 
                    c.setPaye(rs.getInt(3));
                      c.setRestant(rs.getInt(4));
                      User u = new User();
                      u.setNom(rs.getString(5));
                      u.setPrenom(rs.getString(6));
                      u.setTelephone(rs.getString(7));
                      u.setMatricule(rs.getString(8));
           
                 c.setIdetudiant(u);
                    return c;
                });
      mav.setViewName("ListePayement");
     if(!mens.isEmpty())
     {
       mav.addObject("mensualite", mens);
         mav.addObject("cls", cls);
         mav.addObject("ms", ms);
     }
     else
     {
      mav.addObject("cls", "Pas de payements Trouves");
     }
        mav.setViewName("ControlePaye");
         response.sendRedirect("listePayement.htm");
        return mav;

    }
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "Mensualite.htm", method = RequestMethod.GET)
    public ModelAndView findEtudiant(HttpServletRequest req) {
        mav = new ModelAndView();
        String matricule = req.getParameter("matricule");
        String sql = "SELECT user.id,user.matricule,user.nom,prenom,adresse,telephone,inscription.matricule , inscription.idclasse,inscription.date,classes.mensualite,filiere.nom ,classes.nom from user,inscription,filiere,classes where user.matricule =? AND user.id=inscription.iduser AND filiere.id=classes.filiere";

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

                ins = new Inscription();
                ins.setMatricule(rs.getString(7));
                ins.setDate(rs.getDate(9));
                ins.setIduser(c);

                Classes s = new Classes();
                s.setId(rs.getInt(8));
                s.setMensualite(rs.getInt(10));

                Filiere f = new Filiere();
                f.setNom(rs.getString(11));

                s.setFiliere(f);
                ins.setIdclasse(s);
                mav.addObject("fil", rs.getString(11));
                mav.addObject("cls", rs.getString(12));
                mav.addObject("mensu", rs.getInt(10));
                mav.addObject("inscrip", ins);

                payement = rs.getInt(10);

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

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "Mensualite.htm", method = RequestMethod.POST)
    public ModelAndView validerPayement(HttpServletRequest req) {
      String mat=   "PAY" + (int) (Math.random() * 9999999) + "";
        String mois = req.getParameter("mois");
          int  paye = Integer.parseInt(req.getParameter("paye"));
          int restant=ins.getIdclasse().getMensualite()-paye;
        String sql = "insert into mensualite values (?,?,?,?,?,?,?,?)";

        jdtbcTemplate.update(sql, null,mat, java.sql.Date.valueOf(date), mois,paye,restant ,ins.getIdclasse().getId(), ins.getIduser().getId());

        return mav;

    }
 /**
     *
     */
    @RequestMapping(value = "StatComptable.htm")
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
                   Filiere fl=new Filiere();
                    Classes cls=new Classes();
                    cls.setId(rs.getInt(2));
                    fl.setId(rs.getInt(1));
                    cls.setFiliere(fl);
                    ins.setIdclasse(cls);
                    return ins;
                });
        
      int tab[] = new int [filieres.size()];
      int nbInsParPeriode[] = new int [4];
        int i=0;
        for (Filiere filiere : filieres) { 
             int cpt=0;
            for (Inscription inscription : listeInscription) {
              
                
                if( inscription.getIdclasse().getFiliere().getId() == filiere.getId())
                {
                    cpt++;
                }
              
            }
              tab[i]=cpt;
                i++;
                
        }
        
        
        
       int tabclasse[] = new int [classes.size()];
   
        int j=0;
        for (Classes classe : classes) { 
             int cpt=0;
            for (Inscription inscription : listeInscription) {
              
                
                if( inscription.getIdclasse().getId() == classe.getId())
                {
                    cpt++;
                }
              
            }
              tabclasse[j]=cpt;
                j++;
                
        }
     
     
        mav.setViewName("StatComptable");
        mav.addObject("filieres", filieres);
         mav.addObject("classes", classes);
           mav.addObject("nbParClasse", tabclasse);
         mav.addObject("nbInscriptions", tab);
        return mav; 

    }

    /**
     *
     * @param req
     */
    @RequestMapping(value = "AjouterComptable.htm", method = RequestMethod.POST)
    public void saveAdmin(HttpServletRequest req) {
        try {
            User user = new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            user.setAdresse(req.getParameter("adresse"));
            user.setTelephone(req.getParameter("telephone"));
            user.setGenre(req.getParameter("genre"));

            Account account = new Account(2);

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
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, "CP" + count, user.getGenre());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     *
     * @param req
     */
    @RequestMapping(value = "InscriptionEtudiant.htm", method = RequestMethod.POST)
    public void saveEtudiant(HttpServletRequest req) {
        try {
            User user = new User();
            user.setGenre(req.getParameter("genre"));
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

            String sql = "insert into profil values (?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, profil.getIdaccount().getId(), profil.getPassword(), profil.getUsername(),0);

            sql = "Select Max(id) from profil";
            boolean result = false;
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
                result = true;
            }
            System.out.println(count);
            sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, user.getMatricule(), user.getGenre());

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

            sql = "insert into inscription values (?,?,?,?,?,?)";

            String matri = "INS" + (int) (Math.random() * 9999999) + "";
            jdtbcTemplate.update(sql, null, matri, java.sql.Date.valueOf(LocalDate.now()), c.getId(), user.getId(), 3);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    
    
    
    
    /**
     *
     * @param req
     * @return ModelView
     */
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

    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("ListeInscription.htm")
    public ModelAndView listeInscription(HttpServletRequest req) {
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.telephone, inscription.matricule ,inscription.id,inscription.date,classes.description FROM user,inscription,classes WHERE user.id=inscription.iduser and classes.id=inscription.idclasse";
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

                    return c;
                });

        mav.addObject("inscriptions", listeInscription);
        mav.setViewName("ListeInscription");
        return mav;
    }
 
}
