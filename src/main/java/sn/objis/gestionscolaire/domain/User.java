
package sn.objis.gestionscolaire.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fallou
 * @since  12-12-2019
 * @version  1.0
 */
@Entity
@Table(name = "user")

public class User implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @JoinColumn(name = "idprofil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profil idprofil;

    /**
     *constructeur sans parametre
     */
    public User() {
    }

    /**
     *
     * @param id
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     * Contructeur avec parametre
     * @param id
     * @param nom
     * @param prenom
     * @param adresse
     * @param telephone
     * @param photo
     */
    public User(Integer id, String nom, String prenom, String adresse, String telephone, byte[] photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.photo = photo;
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
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     *
     * @return
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     *
     * @return
     */
    public Profil getIdprofil() {
        return idprofil;
    }

    /**
     *
     * @param idprofil
     */
    public void setIdprofil(Profil idprofil) {
        this.idprofil = idprofil;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " ";
    }
    
}
