package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Cycle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Filiere.class)
public class Filiere_ { 

    public static volatile SingularAttribute<Filiere, String> matricule;
    public static volatile ListAttribute<Filiere, Classes> classesList;
    public static volatile SingularAttribute<Filiere, Cycle> idcycle;
    public static volatile SingularAttribute<Filiere, String> description;
    public static volatile SingularAttribute<Filiere, Integer> id;
    public static volatile SingularAttribute<Filiere, String> nom;
    public static volatile SingularAttribute<Filiere, Date> creation;

}