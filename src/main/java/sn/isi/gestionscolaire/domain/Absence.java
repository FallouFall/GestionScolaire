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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "absence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a")
    , @NamedQuery(name = "Absence.findById", query = "SELECT a FROM Absence a WHERE a.id = :id")
    , @NamedQuery(name = "Absence.findByRetard", query = "SELECT a FROM Absence a WHERE a.retard = :retard")
    , @NamedQuery(name = "Absence.findByAbsence", query = "SELECT a FROM Absence a WHERE a.absence = :absence")
    , @NamedQuery(name = "Absence.findByDate", query = "SELECT a FROM Absence a WHERE a.date = :date")})
public class Absence implements Serializable {

    @Basic(optional = false)
    @Column(name = "motif")
    private int motif;
    @Basic(optional = false)
    @Column(name = "justification")
    private String justification;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "retard")
    private int retard;
    @Basic(optional = false)
    @Column(name = "absence")
    private int absence;
    
      @Basic(optional = false)
    @Column(name = "jour")
    private String jour;

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "idetudiant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idetudiant;

    public Absence() {
    }

    public Absence(Integer id) {
        this.id = id;
    }

    public Absence(Integer id, int retard, int absence, Date date) {
        this.id = id;
        this.retard = retard;
        this.absence = absence;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRetard() {
        return retard;
    }

    public void setRetard(int retard) {
        this.retard = retard;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.junittestecase.presentation.Absence[ id=" + id + " ]";
    }

    public int getMotif() {
        return motif;
    }

    public void setMotif(int motif) {
        this.motif = motif;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }
    
}
