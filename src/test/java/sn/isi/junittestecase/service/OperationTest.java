/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.junittestecase.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sn.isi.gestionscolaire.config.Connexion;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

/**
 *
 * @author Fallou
 */
public class OperationTest {

	Connexion con = new Connexion();
	JdbcTemplate jdtbcTemplate = new JdbcTemplate(con.Connection());
    
    
  public int somme(int valA,int valB)
  {
     return valA+valB;
       
      
  }
  
  public boolean authentification(User userToTest)
  {
    
		 String sql = "SELECT user.id,matricule,nom,prenom,adresse,telephone, photo, idaccount,type,profil.id from user, profil,account where username=? AND password=? AND account.id=profil.idaccount and user.idprofil=profil.id";
	        List<User> actors = jdtbcTemplate.query(
	                sql,
	                new Object[]{userToTest.getIdprofil().getUsername(), userToTest.getIdprofil().getPassword()},
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
	                p.setUsername(userToTest.getIdprofil().getUsername());
	                p.setPassword(userToTest.getIdprofil().getPassword());

	                Account account = new Account(rs.getInt(8));
	                account.setType(rs.getString(9));
	                p.setIdaccount(account);
	                c.setIdprofil(p);
	                
	                return c;
	            }
	        });

	     if(   actors.size() != 0)
	     {
	    	 return true;
	     }
	     else {
			return false;
		}
      
  }
  
  public void inscription(Inscription inscription)
  {
    
       
      
  }
}
