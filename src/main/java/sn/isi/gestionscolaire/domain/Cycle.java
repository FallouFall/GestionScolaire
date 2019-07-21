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
@Table(name = "cycle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cycle.findAll", query = "SELECT c FROM Cycle c")
    , @NamedQuery(name = "Cycle.findById", query = "SELECT c FROM Cycle c WHERE c.id = :id")
    , @NamedQuery(name = "Cycle.findByMatricule", query = "SELECT c FROM Cycle c WHERE c.matricule = :matricule")
    , @NamedQuery(name = "Cycle.findByNom", query = "SELECT c FROM Cycle c WHERE c.nom = :nom")
    , @NamedQuery(name = "Cycle.findByDate", query = "SELECT c FROM Cycle c WHERE c.date = :date")})
public class Cycle implements Serializable {

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
      
      @JoinColumn(name = "iddomaine", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Domaine domaine;   

    public Cycle() {
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cycle(Integer id) {
        this.id = id;
    }

    public Cycle(Integer id, String matricule, String nom, String date) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.date = date;
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
        if (!(object instanceof Cycle)) {
            return false;
        }
        Cycle other = (Cycle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestiontestjunit4.Cycle[ id=" + id + " ]";
    }
    
}
