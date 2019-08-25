package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Bibliotheque.class)
public class Bibliotheque_ { 

    public static volatile SingularAttribute<Bibliotheque, String> debut;
    public static volatile SingularAttribute<Bibliotheque, String> matricule;
    public static volatile SingularAttribute<Bibliotheque, User> inscription;
    public static volatile SingularAttribute<Bibliotheque, String> fin;
    public static volatile SingularAttribute<Bibliotheque, Integer> id;

}