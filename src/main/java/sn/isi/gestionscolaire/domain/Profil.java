/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.gestionscolaire.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fallou
 */
@Entity
@Table(name = "profil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profil.findAll", query = "SELECT p FROM Profil p")
    , @NamedQuery(name = "Profil.findById", query = "SELECT p FROM Profil p WHERE p.id = :id")
    , @NamedQuery(name = "Profil.findByPassword", query = "SELECT p FROM Profil p WHERE p.password = :password")
    , @NamedQuery(name = "Profil.findByUsername", query = "SELECT p FROM Profil p WHERE p.username = :username")})
public class Profil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
     @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @JoinColumn(name = "idaccount", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account idaccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofil")
    private List<User> userList;

    /**
     *
     */
    public Profil() {
    }

    /**
     *
     * @return
     */
    public String getStatut() {
        return statut;
    }

    /**
     *
     * @param statut
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     *
     * @param id
     */
    public Profil(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param password
     * @param username
     */
    public Profil(Integer id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
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
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public Account getIdaccount() {
        return idaccount;
    }

    /**
     *
     * @param idaccount
     */
    public void setIdaccount(Account idaccount) {
        this.idaccount = idaccount;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    /**
     *
     * @param userList
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication28.Profil[ id=" + id + " ]";
    }
    
}
