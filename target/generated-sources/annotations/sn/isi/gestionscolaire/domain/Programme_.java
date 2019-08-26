package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Matiere;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T15:41:35")
@StaticMetamodel(Programme.class)
public class Programme_ { 

    public static volatile SingularAttribute<Programme, Classes> idclasse;
    public static volatile SingularAttribute<Programme, Integer> heures;
    public static volatile SingularAttribute<Programme, Integer> id;
    public static volatile SingularAttribute<Programme, Matiere> idmatiere;

}