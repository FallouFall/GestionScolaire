/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "matiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m")
    , @NamedQuery(name = "Matiere.findById", query = "SELECT m FROM Matiere m WHERE m.id = :id")
    , @NamedQuery(name = "Matiere.findByMatricule", query = "SELECT m FROM Matiere m WHERE m.matricule = :matricule")
    , @NamedQuery(name = "Matiere.findByNom", query = "SELECT m FROM Matiere m WHERE m.nom = :nom")
    , @NamedQuery(name = "Matiere.findByCreation", query = "SELECT m FROM Matiere m WHERE m.creation = :creation")
    , @NamedQuery(name = "Matiere.findByDescription", query = "SELECT m FROM Matiere m WHERE m.description = :description")})
public class Matiere implements Serializable {

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
    @Column(name = "coefficient")
     
    private int coefficient;
    @Basic(optional = false)
    @Column(name = "creation")
    @Temporal(TemporalType.DATE)
    private Date creation;
    @Column(name = "description")
    private String description;

    /**
     *
     */
    public Matiere() {
    }

    /**
     *
     * @param id
     */
    public Matiere(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param nom
     * @param creation
     */
    public Matiere(Integer id, String matricule, String nom, Date creation) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.creation = creation;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
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
    public Date getCreation() {
        return creation;
    }

    /**
     *
     * @param creation
     */
    public void setCreation(Date creation) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
