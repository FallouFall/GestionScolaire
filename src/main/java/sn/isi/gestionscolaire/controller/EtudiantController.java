/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.lucene.util.IOUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Documents;
import sn.isi.gestionscolaire.domain.Evenement;
import sn.isi.gestionscolaire.domain.Mensualite;

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
     * @return ModelView
     */
    @RequestMapping("etudiant.htm")
    public ModelAndView welcome(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {

            return new ModelAndView("index");
        } else {

            mav.setViewName("AccueilEtudiant");
        }
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

   
}
