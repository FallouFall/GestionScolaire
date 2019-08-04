/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class HeaderController {
    Connexion con=new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();
    
    /**
     *
     * @param req
     * @return
     */
    @RequestMapping("profil.htm")
    public ModelAndView  profil(HttpServletRequest req) {
         Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
           if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("url")) {
                    loginCookie = cookie;
                    System.out.println(loginCookie);
                    break;
                }
            }
        }
        
         
        return new ModelAndView("Profil");
    }

    /**
     *
     * @param req
     * @return
     */
    @RequestMapping("updateUser.htm")
    public ModelAndView  update(HttpServletRequest req) {
  
       mav.setViewName("UpdateUser");
       return mav;
    }
    
    /**
     *
     * @param req
     * @return
     */
    @RequestMapping(value="updateUser.htm",method = RequestMethod.POST)
    public  ModelAndView updateUser(HttpServletRequest req)          
    {
        try {
            
       
       User user= new User();
     
           
       user.setNom(req.getParameter("nom"));
       user.setPrenom(req.getParameter("prenom"));
       user.setAdresse(req.getParameter("adresse"));
       user.setTelephone(req.getParameter("telephone"));
       user.setId(Integer.valueOf(req.getParameter("id").trim()));
    
   
       Profil profil=new Profil();
       profil.setId(Integer.valueOf(req.getParameter("idprofil").trim()));
       profil.setPassword(req.getParameter("password"));
       profil.setUsername(req.getParameter("username"));
       user.setIdprofil(profil);
       
       String sql="update  profil set username=? ,password=? where id=?";
       jdtbcTemplate.update(sql,profil.getUsername(),profil.getPassword(),profil.getId());
      
     
 
     sql="update user set adresse=?,telephone=? where id=?";
      jdtbcTemplate.update(sql,user.getAdresse(),user.getTelephone(),user.getId());
    
  } catch (Exception e) {
            System.out.println(e);
        }
    
          return new ModelAndView("UpdateUser");
      
    }
    
     /**
     *
     * @param req
     * @param rep
     * @param session 
     * @throws IOException
     */
      @RequestMapping("deconnecter.htm")
     public void deconnection(HttpServletRequest req, HttpServletResponse rep, HttpSession session) throws IOException {
            
      session=req.getSession(false);
        if(session!=null)
        {
      
        session.invalidate();   
        }
        rep.setHeader("Cache-Control","no-cache");
        rep.setHeader("Pragma","no-cache"); //HTTP 1.0    
        rep.setHeader("Cache-Control","no-store"); //HTTP 1.1  
        rep.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
        Cookie loginCookie = new Cookie("MSG", "AU REVOIR");
        loginCookie.setMaxAge(30 * 60);
        rep.addCookie(loginCookie);
        rep.sendRedirect("index.htm");
    }

    /**
     *
     * @param request
     * @return
     * @throws IOException
     */
    public  byte[] readBytes(HttpServletRequest request) throws IOException {
	request.setCharacterEncoding("UTF-8");
       int contentLen = request.getContentLength();
	InputStream is = request.getInputStream();
	if (contentLen > 0) {
		int readLen = 0;
		int readLengthThisTime = 0;
		byte[] message = new byte[contentLen];
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return message;
	}
	return new byte[] {};
}
 
}
