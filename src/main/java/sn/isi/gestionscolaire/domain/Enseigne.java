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
import javax.persistence.Table;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "enseigne")

public class Enseigne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
  
    @JoinColumn(name = "idmatiere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Matiere idmatiere;
    
     @JoinColumn(name = "idprofesseur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User iduser;

    /**
     *
     */
    public Enseigne() {
    }

    /**
     *
     * @param id
     */
    public Enseigne(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Matiere getIdmatiere() {
        return idmatiere;
    }

    /**
     *
     * @param idmatiere
     */
    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
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

   
 

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseigne)) {
            return false;
        }
        Enseigne other = (Enseigne) object;
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
