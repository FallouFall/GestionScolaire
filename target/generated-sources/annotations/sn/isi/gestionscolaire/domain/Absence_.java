package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Absence.class)
public class Absence_ { 

    public static volatile SingularAttribute<Absence, Date> date;
    public static volatile SingularAttribute<Absence, String> jour;
    public static volatile SingularAttribute<Absence, Integer> absence;
    public static volatile SingularAttribute<Absence, User> idetudiant;
    public static volatile SingularAttribute<Absence, Integer> motif;
    public static volatile SingularAttribute<Absence, String> justification;
    public static volatile SingularAttribute<Absence, Integer> id;
    public static volatile SingularAttribute<Absence, Integer> retard;

}