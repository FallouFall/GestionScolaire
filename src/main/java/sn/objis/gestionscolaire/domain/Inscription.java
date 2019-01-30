/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i")
    , @NamedQuery(name = "Inscription.findById", query = "SELECT i FROM Inscription i WHERE i.id = :id")
    , @NamedQuery(name = "Inscription.findByMatricule", query = "SELECT i FROM Inscription i WHERE i.matricule = :matricule")
    , @NamedQuery(name = "Inscription.findByAnnee", query = "SELECT i FROM Inscription i WHERE i.annee = :annee")})
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee")
    @Temporal(TemporalType.DATE)
    private Date annee;
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
    @JoinColumn(name = "idetudiant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idetudiant;

    public Inscription() {
    }

    public Inscription(Integer id) {
        this.id = id;
    }

    public Inscription(Integer id, String matricule, Date annee) {
        this.id = id;
        this.matricule = matricule;
        this.annee = annee;
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

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public Classes getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classes idclasse) {
        this.idclasse = idclasse;
    }

    public User getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(User idetudiant) {
        this.idetudiant = idetudiant;
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
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.gestionscolaire.domain.Inscription[ id=" + id + " ]";
    }
    
}
