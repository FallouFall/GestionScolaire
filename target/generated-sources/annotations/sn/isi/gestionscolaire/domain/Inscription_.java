package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Inscription.class)
public class Inscription_ { 

    public static volatile SingularAttribute<Inscription, Date> date;
    public static volatile SingularAttribute<Inscription, Classes> idclasse;
    public static volatile SingularAttribute<Inscription, User> iduser;
    public static volatile SingularAttribute<Inscription, String> matricule;
    public static volatile SingularAttribute<Inscription, Integer> validite;
    public static volatile SingularAttribute<Inscription, Integer> id;

}