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
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f")
    , @NamedQuery(name = "Formation.findById", query = "SELECT f FROM Formation f WHERE f.id = :id")
    , @NamedQuery(name = "Formation.findByMatricule", query = "SELECT f FROM Formation f WHERE f.matricule = :matricule")
    , @NamedQuery(name = "Formation.findByNom", query = "SELECT f FROM Formation f WHERE f.nom = :nom")
    , @NamedQuery(name = "Formation.findByDate", query = "SELECT f FROM Formation f WHERE f.date = :date")
    , @NamedQuery(name = "Formation.findByDescription", query = "SELECT f FROM Formation f WHERE f.description = :description")})
public class Formation implements Serializable {

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
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idcycle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cycle idcycle;

    @JoinColumn(name = "iddomaine", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Domaine iddomaine;

    /**
     *
     */
    public Formation() {
    }

    /**
     *
     * @param id
     */
    public Formation(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param nom
     * @param date
     * @param description
     */
    public Formation(Integer id, String matricule, String nom, String date, String description) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.date = date;
        this.description = description;
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
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
    public Cycle getIddomaine() {
        return idcycle;
    }

    /**
     *
     * @param iddomaine
     */
    public void setIddomaine(Cycle iddomaine) {
        this.idcycle = iddomaine;
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
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.junittestecase.service.Formation[ id=" + id + " ]";
    }

}
