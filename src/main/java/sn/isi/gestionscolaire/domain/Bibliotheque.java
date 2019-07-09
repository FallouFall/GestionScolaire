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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "bibliotheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliotheque.findAll", query = "SELECT b FROM Bibliotheque b")
    , @NamedQuery(name = "Bibliotheque.findById", query = "SELECT b FROM Bibliotheque b WHERE b.id = :id")
    , @NamedQuery(name = "Bibliotheque.findByMatricule", query = "SELECT b FROM Bibliotheque b WHERE b.matricule = :matricule")
    , @NamedQuery(name = "Bibliotheque.findByDebut", query = "SELECT b FROM Bibliotheque b WHERE b.debut = :debut")
    , @NamedQuery(name = "Bibliotheque.findByFin", query = "SELECT b FROM Bibliotheque b WHERE b.fin = :fin")})
public class Bibliotheque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 23)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 23)
    @Column(name = "debut")
    private String debut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 23)
    @Column(name = "fin")
    private String fin;
    @JoinColumn(name = "inscription", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User inscription;

    public Bibliotheque() {
    }

    public Bibliotheque(Integer id) {
        this.id = id;
    }

    public Bibliotheque(Integer id, String matricule, String debut, String fin) {
        this.id = id;
        this.matricule = matricule;
        this.debut = debut;
        this.fin = fin;
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

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public User getInscription() {
        return inscription;
    }

    public void setInscription(User inscription) {
        this.inscription = inscription;
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
        if (!(object instanceof Bibliotheque)) {
            return false;
        }
        Bibliotheque other = (Bibliotheque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gs.serveurecole.model.Bibliotheque[ id=" + id + " ]";
    }
    
}
