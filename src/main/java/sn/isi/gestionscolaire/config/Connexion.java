/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 *
 * @author Fallou
 * @version 1.0
 * @since  2019/06
 *
 * Classe contenant les parametres de  connection 
 */
public class Connexion {
  
    /**
     *Parametre de connexions a la base de donnees MySQL
     * VERIFIER D'ABORD QUE LE SERVEURDE BASE XAMP EST ALLUME
     * @return DriverManagerDataSource
     */
    public  DriverManagerDataSource Connection()
    {
        
      DriverManagerDataSource  dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/serveurlycee");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        return dataSource;
    }

   
    
    
}
