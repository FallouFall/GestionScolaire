/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Fallou
 */
@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    public void securityConfig(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.inMemoryAuthentication()
                .withUser("joe")
                .password("123")
                .roles("ADMIN");
         System.out.println("ss");
    }
    @Override
    protected void  configure(HttpSecurity http) throws Exception{
    http.
          csrf()
            .disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/index.htm")
            .permitAll(); 
        System.out.println("ss");
            
    
    }
}
