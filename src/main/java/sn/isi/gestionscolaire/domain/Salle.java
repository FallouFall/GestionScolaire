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
@Table(name = "salle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s")
    , @NamedQuery(name = "Salle.findById", query = "SELECT s FROM Salle s WHERE s.id = :id")
    , @NamedQuery(name = "Salle.findByMatricule", query = "SELECT s FROM Salle s WHERE s.matricule = :matricule")
    , @NamedQuery(name = "Salle.findByNom", query = "SELECT s FROM Salle s WHERE s.nom = :nom")
    , @NamedQuery(name = "Salle.findByDescription", query = "SELECT s FROM Salle s WHERE s.description = :description")
    , @NamedQuery(name = "Salle.findByCreation", query = "SELECT s FROM Salle s WHERE s.creation = :creation")
    , @NamedQuery(name = "Salle.findBySuperficie", query = "SELECT s FROM Salle s WHERE s.superficie = :superficie")
    , @NamedQuery(name = "Salle.findByCapacite", query = "SELECT s FROM Salle s WHERE s.capacite = :capacite")})
public class Salle implements Serializable {

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
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "creation")
    @Temporal(TemporalType.DATE)
    private Date creation;
    @Column(name = "superficie")
    private Integer superficie;
    @Basic(optional = false)
    @Column(name = "capacite")
    private int capacite;

    /**
     *
     */
    public Salle() {
    }

    /**
     *
     * @param id
     */
    public Salle(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param nom
     * @param creation
     * @param capacite
     */
    public Salle(Integer id, String matricule, String nom, Date creation, int capacite) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.creation = creation;
        this.capacite = capacite;
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
    public Integer getSuperficie() {
        return superficie;
    }

    /**
     *
     * @param superficie
     */
    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    /**
     *
     * @return
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     *
     * @param capacite
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
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
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication28.Salle[ id=" + id + " ]";
    }
    
}
