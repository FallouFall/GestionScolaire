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
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
      @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User iduser;
    @Column(name = "validite")
    private String validite;

    public Inscription() {
    }

    public Inscription(Integer id) {
        this.id = id;
    }

    public Inscription(Integer id, String matricule, Date date) {
        this.id = id;
        this.matricule = matricule;
        this.date = date;
        this.validite=null;
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

    public Date getDate() {
        return date;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Classes getIdclasse() {
        return idclasse;
    }

        public String getValidite() {
        return validite;
    }

    public void setValidite(String validite) {
        this.validite = validite;
    }

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
        return "gs.serveurecole.model.Inscription[ id=" + id + " ]";
    }
    
}
