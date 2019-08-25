package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Enseigne.class)
public class Enseigne_ { 

    public static volatile SingularAttribute<Enseigne, User> iduser;
    public static volatile SingularAttribute<Enseigne, Integer> id;
    public static volatile SingularAttribute<Enseigne, Matiere> idmatiere;

}