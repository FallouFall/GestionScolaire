/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.domain;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    , @NamedQuery(name = "Classes.findByInscription", query = "SELECT c FROM Classes c WHERE c.inscription = :inscription")
    , @NamedQuery(name = "Classes.findByMensualite", query = "SELECT c FROM Classes c WHERE c.mensualite = :mensualite")})
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation")
    @Temporal(TemporalType.DATE)
    private Date creation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inscription")
    private int inscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mensualite")
    private int mensualite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclasse")
    private List<Inscription> inscriptionList;

    public Classes() {
    }

    public Classes(Integer id) {
        this.id = id;
    }

    public Classes(Integer id, String matricule, String nom, Date creation, String description, int inscription, int mensualite) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.creation = creation;
        this.description = description;
        this.inscription = inscription;
        this.mensualite = mensualite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInscription() {
        return inscription;
    }

    public void setInscription(int inscription) {
        this.inscription = inscription;
    }

    public int getMensualite() {
        return mensualite;
    }

    public void setMensualite(int mensualite) {
        this.mensualite = mensualite;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
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
        return "gs.serveurecole.model.Classes[ id=" + id + " ]";
    }
    
}
