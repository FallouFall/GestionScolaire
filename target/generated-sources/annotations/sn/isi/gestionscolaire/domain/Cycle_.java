package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Filiere;
import sn.isi.gestionscolaire.domain.Formation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T15:41:35")
@StaticMetamodel(Cycle.class)
public class Cycle_ { 

    public static volatile SingularAttribute<Cycle, String> date;
    public static volatile SingularAttribute<Cycle, String> matricule;
    public static volatile ListAttribute<Cycle, Formation> formationList;
    public static volatile SingularAttribute<Cycle, String> description;
    public static volatile SingularAttribute<Cycle, Integer> id;
    public static volatile ListAttribute<Cycle, Filiere> filiereList;
    public static volatile SingularAttribute<Cycle, String> nom;
    public static volatile SingularAttribute<Cycle, Formation> idformation;

}