/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
    , @NamedQuery(name = "Note.findById", query = "SELECT n FROM Note n WHERE n.id = :id")
    , @NamedQuery(name = "Note.findByMatricule", query = "SELECT n FROM Note n WHERE n.matricule = :matricule")
    , @NamedQuery(name = "Note.findBySemestre", query = "SELECT n FROM Note n WHERE n.semestre = :semestre")
    , @NamedQuery(name = "Note.findByNoteA", query = "SELECT n FROM Note n WHERE n.noteA = :noteA")
    , @NamedQuery(name = "Note.findByNote2", query = "SELECT n FROM Note n WHERE n.note2 = :note2")
    , @NamedQuery(name = "Note.findByExamen", query = "SELECT n FROM Note n WHERE n.examen = :examen")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
  
    @Basic(optional = false)
    @Column(name = "semestre")
    private int semestre;
    @Column(name = "noteA")
    private Integer noteA;
    @Column(name = "note2")
    private Integer note2;
    @Column(name = "examen")
    private Integer examen;
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
    @JoinColumn(name = "idetudiant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idetudiant;
    @JoinColumn(name = "idmatiere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Matiere idmatiere;
      @JoinColumn(name = "idacad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anneacad idacad;

    /**
     *
     */
    public Note() {
    }

    /**
     *
     * @param id
     */
    public Note(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param semestre
     */
    public Note(Integer id, String matricule, int semestre) {
        this.id = id;
 
        this.semestre = semestre;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Anneacad getIdacad() {
        return idacad;
    }

    /**
     *
     * @param idacad
     */
    public void setIdacad(Anneacad idacad) {
        this.idacad = idacad;
    }

    /**
     *
     * @return
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     *
     * @param semestre
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     *
     * @return
     */
    public Integer getNoteA() {
        return noteA;
    }

    /**
     *
     * @param noteA
     */
    public void setNoteA(Integer noteA) {
        this.noteA = noteA;
    }

    /**
     *
     * @return
     */
    public Integer getNote2() {
        return note2;
    }

    /**
     *
     * @param note2
     */
    public void setNote2(Integer note2) {
        this.note2 = note2;
    }

    /**
     *
     * @return
     */
    public Integer getExamen() {
        return examen;
    }

    /**
     *
     * @param examen
     */
    public void setExamen(Integer examen) {
        this.examen = examen;
    }

    /**
     *
     * @return
     */
    public Classes getIdclasse() {
        return idclasse;
    }

    /**
     *
     * @param idclasse
     */
    public void setIdclasse(Classes idclasse) {
        this.idclasse = idclasse;
    }

    /**
     *
     * @return
     */
    public User getIdetudiant() {
        return idetudiant;
    }

    /**
     *
     * @param idetudiant
     */
    public void setIdetudiant(User idetudiant) {
        this.idetudiant = idetudiant;
    }

    /**
     *
     * @return
     */
    public Matiere getIdmatiere() {
        return idmatiere;
    }

    /**
     *
     * @param idmatiere
     */
    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.junittestecase.service.Note[ id=" + id + " ]";
    }
    
}
