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
@Table(name = "droitinscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Droitinscription.findAll", query = "SELECT d FROM Droitinscription d")
    , @NamedQuery(name = "Droitinscription.findById", query = "SELECT d FROM Droitinscription d WHERE d.id = :id")
    , @NamedQuery(name = "Droitinscription.findByMatricule", query = "SELECT d FROM Droitinscription d WHERE d.matricule = :matricule")
    , @NamedQuery(name = "Droitinscription.findByInscription", query = "SELECT d FROM Droitinscription d WHERE d.inscription = :inscription")
    , @NamedQuery(name = "Droitinscription.findByMensualite", query = "SELECT d FROM Droitinscription d WHERE d.mensualite = :mensualite")})
public class Droitinscription implements Serializable {

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
    @Column(name = "inscription")
    private int inscription;
    @Basic(optional = false)
    @Column(name = "mensualite")
    private int mensualite;

    /**
     *
     */
    public Droitinscription() {
    }

    /**
     *
     * @param id
     */
    public Droitinscription(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param inscription
     * @param mensualite
     */
    public Droitinscription(Integer id, String matricule, int inscription, int mensualite) {
        this.id = id;
        this.matricule = matricule;
        this.inscription = inscription;
        this.mensualite = mensualite;
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
    public int getInscription() {
        return inscription;
    }

    /**
     *
     * @param inscription
     */
    public void setInscription(int inscription) {
        this.inscription = inscription;
    }

    /**
     *
     * @return
     */
    public int getMensualite() {
        return mensualite;
    }

    /**
     *
     * @param mensualite
     */
    public void setMensualite(int mensualite) {
        this.mensualite = mensualite;
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
        if (!(object instanceof Droitinscription)) {
            return false;
        }
        Droitinscription other = (Droitinscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.objis.junittestecase.presentation.Droitinscription[ id=" + id + " ]";
    }
    
}
