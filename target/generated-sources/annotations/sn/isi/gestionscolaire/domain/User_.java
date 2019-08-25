package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Inscription;
import sn.isi.gestionscolaire.domain.Profil;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Inscription> inscriptionList;
    public static volatile SingularAttribute<User, String> imageId;
    public static volatile SingularAttribute<User, String> matricule;
    public static volatile SingularAttribute<User, Profil> idprofil;
    public static volatile SingularAttribute<User, String> adresse;
    public static volatile SingularAttribute<User, String> genre;
    public static volatile SingularAttribute<User, byte[]> photo;
    public static volatile SingularAttribute<User, String> telephone;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> nom;
    public static volatile SingularAttribute<User, String> prenom;
    public static volatile SingularAttribute<User, Integer> statut;

}