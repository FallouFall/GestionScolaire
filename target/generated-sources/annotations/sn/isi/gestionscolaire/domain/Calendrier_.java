package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.Salle;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T15:41:35")
@StaticMetamodel(Calendrier.class)
public class Calendrier_ { 

    public static volatile SingularAttribute<Calendrier, String> heure;
    public static volatile SingularAttribute<Calendrier, Classes> idclasse;
    public static volatile SingularAttribute<Calendrier, String> jour;
    public static volatile SingularAttribute<Calendrier, Salle> idsalle;
    public static volatile SingularAttribute<Calendrier, User> professeur;
    public static volatile SingularAttribute<Calendrier, Integer> id;
    public static volatile SingularAttribute<Calendrier, Matiere> idmatiere;

}