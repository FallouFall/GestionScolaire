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

public class Mensualite implements Serializable {

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
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "mois")
    private String mois;
    
       @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "paye")
    private int paye;
       
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "restant")
    private int restant;
    
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
   
    
    @JoinColumn(name = "idetudiant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idetudiant;

    /**
     *
     */
    public Mensualite() {
    }

    public User getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(User idetudiant) {
        this.idetudiant = idetudiant;
    }

    public int getPaye() {
        return paye;
    }

    public void setPaye(int paye) {
        this.paye = paye;
    }

    public int getRestant() {
        return restant;
    }

    public void setRestant(int restant) {
        this.restant = restant;
    }

    /**
     *
     * @param id
     */
    public Mensualite(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     *
     * @param id
     * @param mat
     * @param date
     * @param mois
     */
    public Mensualite(Integer id,String mat, Date date, String mois) {
        this.id = id;
        this.date = date;
        this.mois = mois;
        this.matricule=mat;
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
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getMois() {
        return mois;
    }

    /**
     *
     * @param mois
     */
    public void setMois(String mois) {
        this.mois = mois;
    }

    /**
     *
     * @return
     */
    public Classes getIdclasse() {
        return idclasse;
    }

    /**
     *
     * @param idclasse
     */
    public void setIdclasse(Classes idclasse) {
        this.idclasse = idclasse;
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
