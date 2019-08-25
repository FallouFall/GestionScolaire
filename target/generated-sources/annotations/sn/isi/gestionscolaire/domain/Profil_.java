package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Account;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Profil.class)
public class Profil_ { 

    public static volatile SingularAttribute<Profil, String> password;
    public static volatile ListAttribute<Profil, User> userList;
    public static volatile SingularAttribute<Profil, Account> idaccount;
    public static volatile SingularAttribute<Profil, Integer> id;
    public static volatile SingularAttribute<Profil, String> statut;
    public static volatile SingularAttribute<Profil, String> username;

}