/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 *
 * @author Fallou
 */
public class Connexion {
  

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
