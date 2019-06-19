/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.lucene.util.IOUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sn.objis.gestionscolaire.config.Connexion;
import sn.objis.gestionscolaire.domain.Documents;

/**
 *
 * @author Fallou
 */
@Controller
public class EtudiantController {
    Connexion con=new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
        List<Documents> docs = new ArrayList<>();
    @RequestMapping("etudiant.htm")
    public ModelAndView welcome()
    {
   
      
        mav.setViewName("AccueilEtudiant");
     return mav;
    }
        @RequestMapping("documents.htm")
    public ModelAndView documents()
    {
   
      
        mav.setViewName("documents");
     return mav;
    }
    
        @RequestMapping("documentsMath.htm")
    public ModelAndView documentsMath()
    {
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
    
    
    
    
      @RequestMapping("index.htm")
    public ModelAndView deconnection()
    {
 
        mav.setViewName("index");
     return mav;
    }
}
