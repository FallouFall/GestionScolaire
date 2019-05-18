/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class GererSecretaireController {
    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    public ModelAndView mav = new ModelAndView();
    

    @RequestMapping("GererSecretaire.htm")
    public ModelAndView welcome() {
        String sql="SELECT distinct matricule, nom,prenom, adresse,telephone,photo from user,profil,account WHERE account.id=? and profil.id=user.idprofil and account.id=profil.idaccount  ";
    
        List<User> actors =new ArrayList<>();
        
        
        actors = jdtbcTemplate.query(sql,
                new Object[]{3}, (ResultSet rs, int rowNum) -> {
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
    @RequestMapping(value = "AjouterSecretaire.htm",method = RequestMethod.GET)
    public  void ajouterAdmin()          
    {
        ModelAndView mav=new ModelAndView("redirect:/AjouterSecretaire.htm");
        
      
    }
    
       @RequestMapping(value="AjouterSecretaire.htm",method = RequestMethod.POST)
    public  void saveAdmin(HttpServletRequest req)          
    {
        try {
            
       User user= new User();
       user.setNom(req.getParameter("nom"));
       user.setPrenom(req.getParameter("prenom"));
       user.setAdresse(req.getParameter("adresse"));  
       user.setTelephone(req.getParameter("telephone"));
       user.setGenre(req.getParameter("genre"));
       
       Account account =new Account(3);
       
       Profil profil=new Profil();
       profil.setIdaccount(account);
       profil.setPassword(req.getParameter("password"));
       profil.setUsername(req.getParameter("username"));
       user.setIdprofil(profil);
       
     
       String sql="insert into profil values (?,?,?,?)";
       jdtbcTemplate.update(sql,null,profil.getIdaccount().getId(),profil.getPassword(),profil.getUsername());
      
       sql="Select Max(id) from profil";
       boolean result=false;
       int count=jdtbcTemplate.queryForObject(sql, new Object[]{},Integer.class);
       if(count>0)
       {
           result= true;
       }
 
         
      sql="insert into user values (?,?,?,?,?,?,?,?,?)";
      jdtbcTemplate.update(sql,null,user.getAdresse(),user.getNom(),user.getPhoto(),user.getPrenom(),user.getTelephone(),count,"SC"+count,user.getGenre());
       
  } catch (Exception e) {
            System.out.println(e);
        }

        
      
    }
     @RequestMapping(value = "GererSecretaire.htm",method = RequestMethod.POST)
    public void deconnection(HttpServletRequest req,HttpServletResponse rep) throws IOException
    {
	Cookie loginCookie = null;
    	Cookie[] cookies = req.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("user")){
    			loginCookie = cookie;
                      
    			break;
    		}
    	}
    	}
       
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0);
        	rep.addCookie(loginCookie);
    	}
         rep.sendRedirect("index.htm");
   
    }
}
