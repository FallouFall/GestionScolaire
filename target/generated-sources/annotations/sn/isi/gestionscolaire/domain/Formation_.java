package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Domaine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T15:41:35")
@StaticMetamodel(Formation.class)
public class Formation_ { 

    public static volatile SingularAttribute<Formation, String> date;
    public static volatile SingularAttribute<Formation, String> matricule;
    public static volatile SingularAttribute<Formation, String> description;
    public static volatile SingularAttribute<Formation, Integer> id;
    public static volatile SingularAttribute<Formation, Domaine> iddomaine;
    public static volatile SingularAttribute<Formation, String> nom;

}