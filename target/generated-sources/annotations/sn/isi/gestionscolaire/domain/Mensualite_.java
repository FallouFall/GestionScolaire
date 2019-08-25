package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Mensualite.class)
public class Mensualite_ { 

    public static volatile SingularAttribute<Mensualite, Date> date;
    public static volatile SingularAttribute<Mensualite, Classes> idclasse;
    public static volatile SingularAttribute<Mensualite, String> matricule;
    public static volatile SingularAttribute<Mensualite, Integer> paye;
    public static volatile SingularAttribute<Mensualite, Integer> restant;
    public static volatile SingularAttribute<Mensualite, User> idetudiant;
    public static volatile SingularAttribute<Mensualite, Integer> id;
    public static volatile SingularAttribute<Mensualite, String> mois;

}