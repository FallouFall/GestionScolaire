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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "anneacad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anneacad.findAll", query = "SELECT a FROM Anneacad a")
    , @NamedQuery(name = "Anneacad.findById", query = "SELECT a FROM Anneacad a WHERE a.id = :id")
    , @NamedQuery(name = "Anneacad.findByMatricule", query = "SELECT a FROM Anneacad a WHERE a.matricule = :matricule")
    , @NamedQuery(name = "Anneacad.findByNom", query = "SELECT a FROM Anneacad a WHERE a.nom = :nom")
    , @NamedQuery(name = "Anneacad.findByDate", query = "SELECT a FROM Anneacad a WHERE a.date = :date")})
public class Anneacad implements Serializable {

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

    public Anneacad() {
    }

    public Anneacad(Integer id) {
        this.id = id;
    }

    public Anneacad(Integer id, String matricule, String nom, String date) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }
 public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        if (!(object instanceof Anneacad)) {
            return false;
        }
        Anneacad other = (Anneacad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestiontestjunit4.Anneacad[ id=" + id + " ]";
    }
    
}
