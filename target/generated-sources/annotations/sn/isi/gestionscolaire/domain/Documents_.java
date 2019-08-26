package sn.isi.gestionscolaire.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Matiere;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T15:41:35")
@StaticMetamodel(Documents.class)
public class Documents_ { 

    public static volatile SingularAttribute<Documents, Date> date;
    public static volatile SingularAttribute<Documents, String> cover;
    public static volatile SingularAttribute<Documents, byte[]> image;
    public static volatile SingularAttribute<Documents, String> publue;
    public static volatile SingularAttribute<Documents, String> matricule;
    public static volatile SingularAttribute<Documents, Integer> id;
    public static volatile SingularAttribute<Documents, Matiere> idmatiere;
    public static volatile SingularAttribute<Documents, String> nom;

}