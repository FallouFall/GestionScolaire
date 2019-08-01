/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.junittestecase.presentation;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import sn.isi.junittestecase.service.TestMethodes;

/**
 *
 * @author Fallou
 */
public class Main {
   

    public static void  main( String args [])
    {
        
    Result resultat =JUnitCore.runClasses(TestMethodes.class);
    System.out.println(resultat.wasSuccessful());
       
    List<Failure> failures=resultat.getFailures();
    failures.stream().forEach(fail->System.out.println(fail.getMessage()));
    }
  
}
