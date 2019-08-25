package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Droitinscription;
import sn.isi.gestionscolaire.domain.Filiere;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Classes.class)
public class Classes_ { 

    public static volatile SingularAttribute<Classes, Droitinscription> droitIns;
    public static volatile SingularAttribute<Classes, Filiere> filiere;
    public static volatile SingularAttribute<Classes, String> matricule;
    public static volatile SingularAttribute<Classes, String> description;
    public static volatile SingularAttribute<Classes, String> ouverture;
    public static volatile SingularAttribute<Classes, Integer> id;
    public static volatile SingularAttribute<Classes, String> nom;
    public static volatile SingularAttribute<Classes, Integer> nbmois;
    public static volatile SingularAttribute<Classes, String> creation;

}