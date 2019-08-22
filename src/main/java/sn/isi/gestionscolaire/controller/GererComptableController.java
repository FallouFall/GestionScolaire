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
import sn.isi.gestionscolaire.domain.Bibliotheque;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Cycle;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Formation;
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
    List<User> actors;
    /**
     *
     * @return ModelView
     */
    @RequestMapping("GererComptable.htm")
    public ModelAndView welcomes() {

        String sql = "SELECT distinct matricule,nom,prenom, adresse,telephone,photo,statut,profil.id from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";

       actors = new ArrayList<>();

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
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "bibliotheque.htm", method = RequestMethod.GET)
    public ModelAndView findInscr(HttpServletRequest req) {
        mav = new ModelAndView();
         mav.addObject("findEtudiant", null);
        mav.setViewName("Biblio");
        String matricule = req.getParameter("matricule");
        String sql = "SELECT DISTINCT user.id,user.matricule,user.nom,prenom,adresse,telephone,inscription.matricule , inscription.idclasse,inscription.date,filiere.nom ,classes.nom,droitinscription.mensualite,droitinscription.inscription from user,inscription,filiere,classes,droitinscription where user.matricule =? AND user.id=inscription.iduser AND filiere.id=classes.filiere and classes.droitIns=droitinscription.id AND inscription.idclasse=classes.id";

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
          

                Filiere f = new Filiere();
                f.setNom(rs.getString(11));

                s.setFiliere(f);
                ins.setIdclasse(s);
               mav.addObject("fil", rs.getString(10));
              mav.addObject("cls", rs.getString(11));
                 mav.addObject("mensu", rs.getInt(12));
                mav.addObject("inscrip", ins);

              //  payement = rs.getInt(10);

                return c;
            }
        });
        if (!actors.isEmpty()) {
            mav.addObject("findEtudiant", actors.get(0));
     
                mav.addObject("id", actors.get(0).getId());
        } else {
            mav.addObject("findEtudiant", null);
      
        }

        return mav;

    }

    
    
    
    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "controlePaye.htm",method = RequestMethod.GET)
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
   
        mav.setViewName("ControlePaye");
         mav.addObject("mensualite", null);
        return mav;

    }

    /**
     *
     * @param req
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "controlePaye.htm",method = RequestMethod.POST)
    public ModelAndView listePayement(HttpServletRequest req,HttpServletResponse response) throws IOException {
        
       
       
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
            
        if(mens.size()!=0)
        {
         mav.setViewName("ListePayement");
         mav.addObject("mensualite", mens);
         mav.addObject("cls", "Payement :"+cls);
         mav.addObject("ms", ms);
   
        }
        else
        {
              mav.setViewName("ListePayement");
      mav.addObject("cls", "Pas de payements Trouves");
       mav.addObject("ms", ms);

        }
  
    
        return mav;

    }
    
    
    
       
    /**
     *
     * @return ModelView
     */
    @RequestMapping(value = "controleNonPaye.htm",method = RequestMethod.GET)
    public ModelAndView controleNonPaye() {
         
        String  sql = "SELECT id, matricule,description from classes  ";
        classes = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));           
                    c.setMatricule(rs.getString(2));
                    c.setDescription(rs.getString(3));
               

                    return c;
                });
   
        mav.setViewName("ControleNonPaye");
         mav.addObject("mensualite", null);
        return mav;

    }

    /**
     *
     * @param req
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "controleNonPaye.htm",method = RequestMethod.POST)
    public ModelAndView listeNonPayement(HttpServletRequest req,HttpServletResponse response) throws IOException {
        
       
       
        String sql = "SELECT user.nom,user.prenom,user.telephone,user.matricule,user.id FROM user,classes,inscription WHERE  classes.description=?" +
"and inscription.idclasse=classes.id  and inscription.iduser=user.id ";
        
      String ms =req.getParameter("mois");
          String cls =req.getParameter("classe");
        List<User> users = jdtbcTemplate.query(sql,
                new Object[]{cls}, (ResultSet rs, int rowNum) -> {
                   
                      User u = new User();
                      u.setNom(rs.getString(1));
                      u.setPrenom(rs.getString(2));
                      u.setTelephone(rs.getString(3));
                      u.setMatricule(rs.getString(4));
                      u.setId(rs.getInt(5));
           
              
                    return u;
                });
        
        sql = "SELECT  mensualite.matricule,mensualite.date,mensualite.paye,mensualite.restant,user.nom,user.prenom,user.telephone,user.matricule FROM user,mensualite,classes WHERE mensualite.idetudiant=user.id and classes.description=? and mensualite.idclasse=classes.id and mois=? ";
        
        
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
     
     
         for (User user : users) {
       
             for (Mensualite mensualite : mens) {
                 if(user.getId().equals(mensualite.getIdetudiant().getId()))
                 {
                     users.remove(mensualite.getIdetudiant());
                 }
                 
             }
           
         }
        

        if(mens.size()!=0)
        {
         mav.setViewName("ListeNonPayement");
         mav.addObject("user", users);
         mav.addObject("cls", " Non Payees :"+cls);
         mav.addObject("ms", ms);
   
        }
        else
        {
              mav.setViewName("ListeNonPayement");
      mav.addObject("cls", "Pas de payements Trouves");
       mav.addObject("ms", ms);

        }
  
    
        return mav;

    }
    
 /**
     *
     * @param req
     * @return ModelView
     */
   @RequestMapping(value = "abonnementListe.htm")
      public ModelAndView abonnement(HttpServletRequest req) {
    
        String sql = "SELECT user.id,user.matricule,user.nom,user.prenom,user.adresse,user.telephone,bibliotheque.matricule from user,bibliotheque where user.id=bibliotheque.inscription";

         List<Bibliotheque> bl = jdtbcTemplate.query(sql,
                new Object[]{}, (ResultSet rs, int rowNum) -> {
                Bibliotheque c = new Bibliotheque();
                User u= new User();
                u.setId(rs.getInt(1));
                u.setMatricule(rs.getString(2));
                u.setNom(rs.getString(3));
                u.setPrenom(rs.getString(4));
              u.setAdresse(rs.getString(5));
              u.setTelephone(rs.getString(6));
                c.setMatricule(rs.getString(7));
             
                c.setInscription(u);

               return c;
                });
         mav.setViewName("AbonBiblio");
            mav.addObject("liste", bl);
        
        

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
        String sql = "SELECT DISTINCT user.id,user.matricule,user.nom,prenom,adresse,telephone,inscription.matricule , inscription.idclasse,inscription.date,filiere.nom ,classes.nom,droitinscription.mensualite,droitinscription.inscription from user,inscription,filiere,classes,droitinscription where user.matricule =? AND user.id=inscription.iduser AND filiere.id=classes.filiere and classes.droitIns=droitinscription.id AND inscription.idclasse=classes.id";

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
             

                Filiere f = new Filiere();
                f.setNom(rs.getString(11));

                s.setFiliere(f);
                ins.setIdclasse(s);
                mav.addObject("fil", rs.getString(10));
                mav.addObject("cls", rs.getString(11));
               mav.addObject("mensu", rs.getInt(12));
                mav.addObject("inscrip", ins);
       mav.addObject("prixinscrip", rs.getInt(13));
              //  payement = rs.getInt(12);

                return c;
            }
        });
        
        
      
        
        if (!actors.isEmpty()) {
            mav.addObject("findEtudiant", actors.get(0));
            
             sql = "SELECT distinct id, SUM(paye),SUM(restant) FROM mensualite WHERE idetudiant=?";

      List<Mensualite>  mensualite = jdtbcTemplate.query(
                sql,
                new Object[]{actors.get(0).getId()},
                new RowMapper<Mensualite>() {
            public Mensualite mapRow(ResultSet rs, int rowNum) throws SQLException {
                Mensualite men = new Mensualite();
                men.setPaye(rs.getInt(2));
                men.setRestant(rs.getInt(3));
                return men;
            }
        });
             if (!mensualite.isEmpty()) {
            mav.addObject("payementTotal", mensualite.get(0).getPaye());
            mav.addObject("resteTotal", mensualite.get(0).getRestant());
             mav.addObject("aPayer", mensualite.get(0).getRestant()- mensualite.get(0).getPaye());
            }
          
        }
        
        else {
            mav.addObject("findEtudiant", null);
           
        }

        return mav;

    }

     
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping(value = "bibliotheque.htm", method = RequestMethod.POST)
    public ModelAndView validerPayementBiblio(HttpServletRequest req) {
        String id= req.getParameter("idet");
         String debut= req.getParameter("debut");
          String fin= req.getParameter("fin");
        String mat=   "BIBLIO" + (int) (Math.random() * 9999999) + "";
        String sql = "insert into bibliotheque values (?,?,?,?,?)";
       
        jdtbcTemplate.update(sql, null,mat, debut, fin ,id);
        
        mav.setViewName("Biblio");
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
          int  mensualite = Integer.parseInt(req.getParameter("mensualite"));
        String sql = "insert into mensualite values (?,?,?,?,?,?,?,?)";

        jdtbcTemplate.update(sql, null,mat, java.sql.Date.valueOf(date), mois,paye,mensualite-paye ,ins.getIdclasse().getId(), ins.getIduser().getId());

        return mav;

    }
 /**
     *
     * @return 
     * @return  
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
     */
    @RequestMapping(value = "AjouterComptable.htm", method = RequestMethod.GET)
    public void ajouterAdmin() {
        ModelAndView mav = new ModelAndView("redirect:/AjouterComptable.htm");

    }
    /**
     *
     * @param req
     */
    @RequestMapping(value = "AjouterComptable.htm", method = RequestMethod.POST)
    public ModelAndView saveAdmin(HttpServletRequest req) {
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
      
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
             
            }
            user.setMatricule("CP" + count);
            sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, user.getMatricule(), user.getGenre());
               actors = new ArrayList<>();
               mav = new ModelAndView();
               actors.add(user);
               mav.addObject("liste", actors);              
               mav.setViewName("GererComptable");
        } catch (Exception e) {
            System.out.println(e);
        }
        return mav;
    }

    
    
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("domaineById.htm")
    public ModelAndView DomainesByIdAcad(HttpServletRequest req) {
        String sql = "SELECT * from domaine where idacad =? ";
      List<  Anneacad> domaines = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("id")}, (ResultSet rs, int rowNum) -> {
                    Anneacad c = new Anneacad();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
      mav.setViewName("domaineById");
      mav.addObject("domaines", domaines);
      mav.addObject("annee", req.getParameter("annee"));
       mav.addObject("matriculeEtu", "ETU"+(int)(Math.random()*9999));
      return  mav;
    }
    
     /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("formationById.htm")
    public ModelAndView formationByIdAcad(HttpServletRequest req) {
        String sql = "SELECT * from formation where iddomaine =? ";
      List<  Formation> formations = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("domaine")}, (ResultSet rs, int rowNum) -> {
                    Formation c = new Formation();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
      mav.setViewName("formationById");
      mav.addObject("domaine",  req.getParameter("domaine"));
         mav.addObject("dmn",  req.getParameter("dmn"));
      mav.addObject("annee", req.getParameter("annee"));
      mav.addObject("formations", formations);
 
      return  mav;
    }
    
       /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("filiereIns.htm")
    public ModelAndView filiereInscrip(HttpServletRequest req) {
     String  sql = "SELECT filiere.id,filiere.matricule,filiere.nom ,filiere.creation,filiere.description ,cycle.nom from filiere,cycle,formation  where filiere.idcycle= ? AND cycle.id=filiere.idcycle and formation.idcycle=cycle.id and formation.id=?";
        filieres = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("cycle"),req.getParameter("formation")}, (ResultSet rs, int rowNum) -> {
                    Filiere c = new Filiere();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getDate(4));
                    c.setDescription(rs.getString(5));
                    Cycle sc = new Cycle();
                    sc.setNom(rs.getString(6));
                 
 
                    return c;
                });
      mav.setViewName("ListeFiliereIns");
      mav.addObject("filieres", filieres);
           mav.addObject("domaine",  req.getParameter("domaine"));
      mav.addObject("annee", req.getParameter("annee"));
      mav.addObject("cyn", req.getParameter("cyn"));
      return  mav;
    }
    
    
    
    
       /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("classeIns.htm")
    public ModelAndView classeInscrip(HttpServletRequest req) {
   String    sql = "SELECT * from classes   where filiere=?";
        classes = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("idfiliere")}, (ResultSet rs, int rowNum) -> {
                    Classes c = new Classes();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setCreation(rs.getString(4));
                    c.setDescription(rs.getString(5));
                  

                    return c;
                });

      mav.addObject("classes", classes);
      mav.setViewName("ListeClasseIns");
        mav.addObject("filiere", req.getParameter("filiere"));
         mav.addObject("idfiliere", req.getParameter("idfiliere"));
         
      return  mav;
    }
       /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("infoInscription.htm")
    public ModelAndView infoInscrip(HttpServletRequest req) {
    mav.addObject("classe", req.getParameter("classe"));
      mav.setViewName("InfoInscription");
    
   
      return  mav;
    }
    
    
    
    
      /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("cycleInscription.htm")
    public ModelAndView Cycleformation(HttpServletRequest req) {
        String sql = "SELECT * from cycle where idformation=?  ";
      List<  Cycle> cycle = jdtbcTemplate.query(sql,
                new Object[]{req.getParameter("formation")}, (ResultSet rs, int rowNum) -> {
                    Cycle c = new Cycle();
                    c.setId(rs.getInt(1));
                    c.setMatricule(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDate(rs.getString(4));
                    c.setDescription(rs.getString(5));

                    return c;
                });
      mav.setViewName("cycleInscription");
      mav.addObject("cyclefor", cycle);
      mav.addObject("formation",req.getParameter("formation"));
        mav.addObject("frn",  req.getParameter("frn"));
      return  mav;
    }
    
    /**
     *
     * @param req
     * @return 
     */
    @RequestMapping(value = "infoInscription.htm", method = RequestMethod.POST)
    public ModelAndView saveEtudiant(HttpServletRequest req) {
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
 
            int count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
          
            }
            System.out.println(count);
            sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
            jdtbcTemplate.update(sql, null, user.getAdresse(), user.getNom(), user.getPhoto(), user.getPrenom(), user.getTelephone(), count, user.getMatricule(), user.getGenre());

        
          

            sql = "Select Max(id) from user";
           
            count = jdtbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
            if (count > 0) {
          
            }
            user.setId(count);

            sql = "insert into inscription values (?,?,?,?,?,?)";

            String matri = "INS" + (int) (Math.random() * 9999999) + "";
            jdtbcTemplate.update(sql, null, matri, java.sql.Date.valueOf(LocalDate.now()), req.getParameter("idClasse"), user.getId(), 3);

        } catch (Exception e) {
            System.out.println(e);
        }
mav.setViewName("InscriptionEtudiant");
return mav;
    }

    
    
    
    
    
    /**
     *
     * @param req
     * @return ModelView
     */
    @RequestMapping("InscriptionEtudiant.htm")
    public ModelAndView listeFiliere(HttpServletRequest req) {
        
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
     
         mav.addObject("annees", annees);
        
        
        
     sql = "SELECT * from filiere  ";
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
