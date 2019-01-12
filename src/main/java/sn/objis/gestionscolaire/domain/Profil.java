
package sn.objis.gestionscolaire.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fallou
 * @since 12-12-2018
 * @version 1.0
 */
@Entity
@Table(name = "profil")

public class Profil implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;
    @JoinColumn(name = "idaccount", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account idaccount;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofil")
    private List<User> userList;

    /**
     *Constructeur sans parametre
     */
    public Profil() {
    }

    /**
     *
     * @param id
     */
    public Profil(Integer id) {
        this.id = id;
    }

    /**
     * Constructeur avec parametres
     * @param id
     * @param nom
     * @param username
     * @param password
     */
    public Profil(Integer id, String nom, String username, String password) {
        this.id = id;
        this.nom = nom;
        this.username = username;
        this.password = password;
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
        return  id + " ";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Account idaccount) {
        this.idaccount = idaccount;
    }
    
}
