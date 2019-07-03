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
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i")
    , @NamedQuery(name = "Inscription.findById", query = "SELECT i FROM Inscription i WHERE i.id = :id")
    , @NamedQuery(name = "Inscription.findByMatricule", query = "SELECT i FROM Inscription i WHERE i.matricule = :matricule")
    , @NamedQuery(name = "Inscription.findByDate", query = "SELECT i FROM Inscription i WHERE i.date = :date")})
public class Inscription implements Serializable {

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
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User iduser;
       @Basic(optional = false)
    @Column(name = "validite")
    private Integer validite;

    /**
     *
     */
    public Inscription() {
    }

    /**
     *
     * @param id
     */
    public Inscription(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param date
     */
    public Inscription(Integer id, String matricule, Date date) {
        this.id = id;
        this.matricule = matricule;
        this.date = date;
    }

    /**
     *
     * @return
     */
    public Integer getValidite() {
        return validite;
    }

    /**
     *
     * @param validite
     */
    public void setValidite(Integer validite) {
        this.validite = validite;
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

    /**
     *
     * @return
     */
    public User getIduser() {
        return iduser;
    }

    /**
     *
     * @param iduser
     */
    public void setIduser(User iduser) {
        this.iduser = iduser;
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
        return "javaapplication28.Inscription[ id=" + id + " ]";
    }
    
}
