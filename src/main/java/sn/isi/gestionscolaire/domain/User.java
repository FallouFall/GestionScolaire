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
import javax.persistence.Lob;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByAdresse", query = "SELECT u FROM User u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "User.findByNom", query = "SELECT u FROM User u WHERE u.nom = :nom")
    , @NamedQuery(name = "User.findByPrenom", query = "SELECT u FROM User u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "User.findByTelephone", query = "SELECT u FROM User u WHERE u.telephone = :telephone")
    , @NamedQuery(name = "User.findByMatricule", query = "SELECT u FROM User u WHERE u.matricule = :matricule")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
   
    private String imageId ;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
    
     @Basic(optional = false)
    @Column(name = "naissance")
    private String naissance;
     
      @Basic(optional = false)
    @Column(name = "log")
    private int log;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Inscription> inscriptionList;
    @JoinColumn(name = "idprofil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profil idprofil;
    @Basic(optional = false)
    @Column(name = "genre")
    private String genre;
    
     @Basic(optional = false)
    private int statut;
     
     

    /**
     *
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     */
    public User() {
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public int getLog() {
        return log;
    }

    public void setLog(int log) {
        this.log = log;
    }

    /**
     *
     * @param id
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getStatut() {
        return statut;
    }

    /**
     *
     * @param statut
     */
    public void setStatut(int statut) {
        this.statut = statut;
    }

    /**
     *
     * @param id
     * @param adresse
     * @param nom
     * @param prenom
     * @param telephone
     * @param matricule
     */
    public User(Integer id, String adresse, String nom, String prenom, String telephone, String matricule) {
        this.id = id;
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.matricule = matricule;
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
    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    /**
     *
     * @param inscriptionList
     */
    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
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
        return nom +" "+prenom;
    }

    /**
     *
     * @return
     */
    public String getImageId() {
        return imageId;
    }

    /**
     *
     * @param imageId
     */
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    
}
