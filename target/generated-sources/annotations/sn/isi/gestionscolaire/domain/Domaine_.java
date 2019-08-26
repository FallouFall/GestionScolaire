package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Anneacad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T15:41:35")
@StaticMetamodel(Domaine.class)
public class Domaine_ { 

    public static volatile SingularAttribute<Domaine, String> date;
    public static volatile SingularAttribute<Domaine, String> matricule;
    public static volatile SingularAttribute<Domaine, String> description;
    public static volatile SingularAttribute<Domaine, Integer> id;
    public static volatile SingularAttribute<Domaine, Anneacad> idacad;
    public static volatile SingularAttribute<Domaine, String> nom;

}