/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "filiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f")
    , @NamedQuery(name = "Filiere.findById", query = "SELECT f FROM Filiere f WHERE f.id = :id")
    , @NamedQuery(name = "Filiere.findByMatricule", query = "SELECT f FROM Filiere f WHERE f.matricule = :matricule")
    , @NamedQuery(name = "Filiere.findByNom", query = "SELECT f FROM Filiere f WHERE f.nom = :nom")
    , @NamedQuery(name = "Filiere.findByCreation", query = "SELECT f FROM Filiere f WHERE f.creation = :creation")
    , @NamedQuery(name = "Filiere.findByDescription", query = "SELECT f FROM Filiere f WHERE f.description = :description")})
public class Filiere implements Serializable {

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
    @Temporal(TemporalType.DATE)
    private Date creation;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idcycle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cycle idcycle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filiere")
    private List<Classes> classesList;

    /**
     *
     */
    public Filiere() {
    }

    /**
     *
     * @param id
     */
    public Filiere(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param nom
     * @param creation
     */
    public Filiere(Integer id, String matricule, String nom, Date creation) {
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

    /**
     *
     * @return
     */
    public Cycle getIdcycle() {
        return idcycle;
    }

    /**
     *
     * @param idcycle
     */
    public void setIdcycle(Cycle idcycle) {
        this.idcycle = idcycle;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Classes> getClassesList() {
        return classesList;
    }

    /**
     *
     * @param classesList
     */
    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
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
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
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
