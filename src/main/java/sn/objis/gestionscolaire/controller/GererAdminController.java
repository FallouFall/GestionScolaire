/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import org.apache.commons.codec.binary.Base64;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import sn.objis.gestionscolaire.domain.Profil;
import sn.objis.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class GererAdminController {
    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    public ModelAndView mav = new ModelAndView();
    

    @RequestMapping("GererAdmin.htm")
    public ModelAndView welcome() {
        
        String sql="SELECT distinct nom,prenom, adresse,telephone,photo from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";
        List<String> image=new ArrayList<>();
        List<User> actors =new ArrayList<>();
        
        
        actors = jdtbcTemplate.query(sql,
                new Object[]{1}, (ResultSet rs, int rowNum) -> {
                    User c = new User();
                    
                    c.setNom(rs.getString(1));
                    c.setPrenom(rs.getString(2));
                    c.setAdresse(rs.getString(3));
                    c.setTelephone(rs.getString(4));
                    
                    try {
                        String encodeBase64 = Base64.encodeBase64String(rs.getBytes(5));
                        image.add(encodeBase64);
                    } catch (Exception e) {
                    }
                    return c;
        });
      
       mav.addObject("liste", actors);
       mav.addObject("listeImage", image);
        return mav;
    }
    @RequestMapping(value = "AjouterAdmin.htm",method = RequestMethod.GET)
    public  void ajouterAdmin()          
    {
        ModelAndView mav=new ModelAndView("redirect:/AjouterAdmin.htm");
        
      
    }
    
       @RequestMapping(value="AjouterAdmin.htm",method = RequestMethod.POST)
    public  void saveAdmin(HttpServletRequest req)          
    {
        try {
            
      
       User user= new User();
       user.setNom(req.getParameter("nom"));
       user.setPrenom(req.getParameter("prenom"));
       user.setAdresse(req.getParameter("adresse"));
       user.setTelephone(req.getParameter("telephone"));
       user.setTelephone(req.getParameter("mail"));
        Account account =new Account(1);
       
       Profil profil=new Profil();
       profil.setIdaccount(account);
       profil.setPassword(req.getParameter("password"));
       profil.setUsername(req.getParameter("username"));
       user.setIdprofil(profil);
       
       String sql="insert into profil values (?,?,?)";
      int of= jdtbcTemplate.update(sql,profil.getIdaccount().getId(),profil.getPassword(),profil.getUsername());
            System.out.println(of+"");
       
       sql="insert into user values (?,?,?,?,?)";
       jdtbcTemplate.update(sql,user.getAdresse(),user.getNom(),user.getPrenom(),user.getTelephone(),user.getIdprofil().getId());
       
  } catch (Exception e) {
            System.out.println(e);
        }

        
      
    }
}
