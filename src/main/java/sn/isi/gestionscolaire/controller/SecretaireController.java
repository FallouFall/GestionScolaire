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
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import sn.isi.gestionscolaire.domain.Evenement;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
@Controller
public class SecretaireController {

    Connexion con = new Connexion();
    JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    ModelAndView mav = new ModelAndView();

    /**
     *
     * @return
     */
    @RequestMapping("secretaire.htm")
    public ModelAndView welcome() {
        // String sql="SELECT * FROM user";
        //  List data = this.jdtbcTemplate.queryForList(sql);
        // mav.addObject("liste", data);

        mav.setViewName("Secreteriat");
        return mav;
    }

    /**
     *
     * @return
     */
    @RequestMapping("Annonces.htm")
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
        mav.setViewName("Annonces");
        return mav;
    }
    
    /**
     *
     * @param req
     * @return
     */
    @RequestMapping(value="Annonces.htm",method = RequestMethod.POST)
    public  ModelAndView saveAnnonces(HttpServletRequest req)          
    {
       Evenement eve= new Evenement();
       eve.setTitre(req.getParameter("titre"));
       eve.setSoustitre(req.getParameter("soustitre"));
        eve.setFin(req.getParameter("fin"));
   eve.setDebut(req.getParameter("debut"));
       eve.setDescription(req.getParameter("description"));
              eve.setLieu(req.getParameter("lieu"));
       
    
       
       String sql="insert into evenement values (?,?,?,?,?,?,?)";
       jdtbcTemplate.update(sql,null,eve.getTitre(),eve.getSoustitre(),eve.getDebut(),eve.getFin(),eve.getDescription(),eve.getLieu());
        // String sql="SELECT * FROM user";
        //  List data = this.jdtbcTemplate.queryForList(sql);
        // mav.addObject("liste", data);
        mav=annonces();
        mav.setViewName("Annonces");
        return mav;
    }

  
}
