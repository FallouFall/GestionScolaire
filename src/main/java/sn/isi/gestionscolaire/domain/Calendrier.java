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
@Table(name = "calendrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendrier.findAll", query = "SELECT c FROM Calendrier c")
    , @NamedQuery(name = "Calendrier.findById", query = "SELECT c FROM Calendrier c WHERE c.id = :id")
    , @NamedQuery(name = "Calendrier.findByJour", query = "SELECT c FROM Calendrier c WHERE c.jour = :jour")
    , @NamedQuery(name = "Calendrier.findByHeure", query = "SELECT c FROM Calendrier c WHERE c.heure = :heure")})
public class Calendrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "jour")
    private String jour;
    @Basic(optional = false)
    @Column(name = "heure")
    private String heure;
    @JoinColumn(name = "idmatiere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Matiere idmatiere;
    @JoinColumn(name = "professeur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User professeur;
    @JoinColumn(name = "idsalle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Salle idsalle;
      @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;

    public Calendrier() {
    }

    public Calendrier(Integer id) {
        this.id = id;
    }

    public Calendrier(Integer id, String jour, String heure) {
        this.id = id;
        this.jour = jour;
        this.heure = heure;
    }

    public Classes getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classes idclasse) {
        this.idclasse = idclasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Matiere getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

    public User getProfesseur() {
        return professeur;
    }

    public void setProfesseur(User professeur) {
        this.professeur = professeur;
    }

    public Salle getIdsalle() {
        return idsalle;
    }

    public void setIdsalle(Salle idsalle) {
        this.idsalle = idsalle;
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
        if (!(object instanceof Calendrier)) {
            return false;
        }
        Calendrier other = (Calendrier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.junittestecase.presentation.Calendrier[ id=" + id + " ]";
    }
    
}
