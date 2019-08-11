package sn.isi.junittestecase.service;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Fallou
 */
public class TestMethodes {


     Methodes methodes=new Methodes();

    /**
     *
     */
    @Test
    public void testingEmail() {
        Assert.assertEquals(true,methodes.validerEmail("fallou@gmail.com"));
    }

 
       @Test
    public void testingName() {
        Assert.assertEquals(true,methodes.validerName("fallou"));
    }
    
    @Test
    public void testingNumber() {
        Assert.assertEquals(true,methodes.validerNumeroTelephone("776880887"));
    }
}
