package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, Date> date;
    public static volatile SingularAttribute<Questions, String> reponse;
    public static volatile SingularAttribute<Questions, User> iduser;
    public static volatile SingularAttribute<Questions, String> matricule;
    public static volatile SingularAttribute<Questions, String> description;
    public static volatile SingularAttribute<Questions, Integer> id;
    public static volatile SingularAttribute<Questions, Integer> statut;

}