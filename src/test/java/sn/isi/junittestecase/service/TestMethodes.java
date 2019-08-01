package sn.isi.junittestecase.service;

import org.junit.Test;
import sn.isi.gestionscolaire.domain.Profil;
import sn.isi.gestionscolaire.domain.User;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;

public class TestMethodes {

    private OperationTest operation = new OperationTest();

    private User userToTest = new User();

    @Test
    public void test() {
        int intputA = 20;
        int intputB = 20;
        Assert.assertEquals(40, operation.somme(intputA, intputB));
    }

 

}
