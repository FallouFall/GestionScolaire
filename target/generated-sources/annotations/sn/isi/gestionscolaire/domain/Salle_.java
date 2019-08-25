package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Typesalle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Salle.class)
public class Salle_ { 

    public static volatile SingularAttribute<Salle, Integer> capacite;
    public static volatile SingularAttribute<Salle, String> matricule;
    public static volatile SingularAttribute<Salle, Integer> superficie;
    public static volatile SingularAttribute<Salle, String> description;
    public static volatile SingularAttribute<Salle, Integer> id;
    public static volatile SingularAttribute<Salle, Typesalle> type;
    public static volatile SingularAttribute<Salle, String> nom;
    public static volatile SingularAttribute<Salle, Date> creation;

}