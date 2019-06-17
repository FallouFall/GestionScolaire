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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "mensualite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensualite.findAll", query = "SELECT m FROM Mensualite m")
    , @NamedQuery(name = "Mensualite.findById", query = "SELECT m FROM Mensualite m WHERE m.id = :id")
    , @NamedQuery(name = "Mensualite.findByDate", query = "SELECT m FROM Mensualite m WHERE m.date = :date")
    , @NamedQuery(name = "Mensualite.findByMois", query = "SELECT m FROM Mensualite m WHERE m.mois = :mois")})
public class Mensualite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "mois")
    private String mois;
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
    @JoinColumn(name = "idfiliere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Filiere idfiliere;

    public Mensualite() {
    }

    public Mensualite(Integer id) {
        this.id = id;
    }

    public Mensualite(Integer id, Date date, String mois) {
        this.id = id;
        this.date = date;
        this.mois = mois;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Classes getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classes idclasse) {
        this.idclasse = idclasse;
    }

    public Filiere getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(Filiere idfiliere) {
        this.idfiliere = idfiliere;
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
        if (!(object instanceof Mensualite)) {
            return false;
        }
        Mensualite other = (Mensualite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gs.serveurecole.model.Mensualite[ id=" + id + " ]";
    }
    
}
