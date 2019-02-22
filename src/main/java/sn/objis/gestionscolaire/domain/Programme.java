/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.objis.gestionscolaire.domain;

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
@Table(name = "programme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p")
    , @NamedQuery(name = "Programme.findById", query = "SELECT p FROM Programme p WHERE p.id = :id")
    , @NamedQuery(name = "Programme.findByIdclasse", query = "SELECT p FROM Programme p WHERE p.idclasse = :idclasse")
    , @NamedQuery(name = "Programme.findByIdmatiere", query = "SELECT p FROM Programme p WHERE p.idmatiere = :idmatiere")
    , @NamedQuery(name = "Programme.findByHeures", query = "SELECT p FROM Programme p WHERE p.heures = :heures")})
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idclasse", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classes idclasse;
    @JoinColumn(name = "idmatiere", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Matiere idmatiere;
    @Basic(optional = false)
    @Column(name = "heures")
    private int heures;

    public Programme() {
    }

    public Programme(Integer id) {
        this.id = id;
    }

    public Programme(Integer id, Classes idclasse, Matiere idmatiere, int heures) {
        this.id = id;
        this.idclasse = idclasse;
        this.idmatiere = idmatiere;
        this.heures = heures;
    }

    public Classes getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classes idclasse) {
        this.idclasse = idclasse;
    }

    public Matiere getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
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
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication28.Programme[ id=" + id + " ]";
    }
    
}
