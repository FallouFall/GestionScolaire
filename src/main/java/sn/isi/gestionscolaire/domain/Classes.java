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
@Table(name = "classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c")
    , @NamedQuery(name = "Classes.findById", query = "SELECT c FROM Classes c WHERE c.id = :id")
    , @NamedQuery(name = "Classes.findByMatricule", query = "SELECT c FROM Classes c WHERE c.matricule = :matricule")
    , @NamedQuery(name = "Classes.findByNom", query = "SELECT c FROM Classes c WHERE c.nom = :nom")
    , @NamedQuery(name = "Classes.findByCreation", query = "SELECT c FROM Classes c WHERE c.creation = :creation")
    , @NamedQuery(name = "Classes.findByDescription", query = "SELECT c FROM Classes c WHERE c.description = :description")
    , @NamedQuery(name = "Classes.findByDroitIns", query = "SELECT c FROM Classes c WHERE c.droitIns = :droitIns")})
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "creation")
    private String creation;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
     @JoinColumn(name = "droitins", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Droitinscription droitIns;
    @JoinColumn(name = "filiere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Filiere filiere;
     @Basic(optional = false)
    @Column(name = "ouverture")
    private String ouverture;
      @Basic(optional = false)
    @Column(name = "nbmois")
    private int nbmois;

    /**
     *
     */
    public Classes() {
    }

    public String getOuverture() {
        return ouverture;
    }

    public void setOuverture(String ouverture) {
        this.ouverture = ouverture;
    }

    public int getNbmois() {
        return nbmois;
    }

    public void setNbmois(int nbmois) {
        this.nbmois = nbmois;
    }

    /**
     *
     * @param id
     */
    public Classes(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param nom
     * @param creation
     * @param description
     * @param droitIns
     */
    public Classes(Integer id, String matricule, String nom, String creation, String description, Droitinscription droitIns) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.creation = creation;
        this.description = description;
        this.droitIns = droitIns;
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
    public String getMatricule() {
        return matricule;
    }

    /**
     *
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getCreation() {
        return creation;
    }

    /**
     *
     * @param creation
     */
    public void setCreation(String creation) {
        this.creation = creation;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Droitinscription getDroitIns() {
        return droitIns;
    }

    /**
     *
     * @param droitIns
     */
    public void setDroitIns(Droitinscription droitIns) {
        this.droitIns = droitIns;
    }

    /**
     *
     * @return
     */
    public Filiere getFiliere() {
        return filiere;
    }

    /**
     *
     * @param filiere
     */
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
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
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.junittestecase.presentation.Classes[ id=" + id + " ]";
    }
    
}
