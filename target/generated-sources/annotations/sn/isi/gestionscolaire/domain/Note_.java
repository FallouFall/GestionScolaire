package sn.isi.gestionscolaire.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.isi.gestionscolaire.domain.Anneacad;
import sn.isi.gestionscolaire.domain.Classes;
import sn.isi.gestionscolaire.domain.Matiere;
import sn.isi.gestionscolaire.domain.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-25T03:25:45")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Integer> note2;
    public static volatile SingularAttribute<Note, Classes> idclasse;
    public static volatile SingularAttribute<Note, Integer> examen;
    public static volatile SingularAttribute<Note, User> idetudiant;
    public static volatile SingularAttribute<Note, Integer> id;
    public static volatile SingularAttribute<Note, Anneacad> idacad;
    public static volatile SingularAttribute<Note, Integer> semestre;
    public static volatile SingularAttribute<Note, Matiere> idmatiere;
    public static volatile SingularAttribute<Note, Integer> noteA;

}