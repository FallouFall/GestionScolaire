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
@Table(name = "domaine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domaine.findAll", query = "SELECT d FROM Domaine d")
    , @NamedQuery(name = "Domaine.findById", query = "SELECT d FROM Domaine d WHERE d.id = :id")
    , @NamedQuery(name = "Domaine.findByMatricule", query = "SELECT d FROM Domaine d WHERE d.matricule = :matricule")
    , @NamedQuery(name = "Domaine.findByNom", query = "SELECT d FROM Domaine d WHERE d.nom = :nom")
    , @NamedQuery(name = "Domaine.findByDate", query = "SELECT d FROM Domaine d WHERE d.date = :date")})
public class Domaine implements Serializable {

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
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    
      @Basic(optional = false)
    @Column(name = "description")
    private String description;

      
          @JoinColumn(name = "idacad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anneacad idacad;

    /**
     *
     */
    public Domaine() {
    }

    /**
     *
     * @return
     */
    public Anneacad getIdacad() {
        return idacad;
    }

    /**
     *
     * @param idacad
     */
    public void setIdacad(Anneacad idacad) {
        this.idacad = idacad;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param id
     */
    public Domaine(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param matricule
     * @param nom
     * @param date
     */
    public Domaine(Integer id, String matricule, String nom, String date) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.date = date;
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
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestiontestjunit4.Domaine[ id=" + id + " ]";
    }
    
}
