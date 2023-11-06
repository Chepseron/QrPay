/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdusers", query = "SELECT u FROM Users u WHERE u.usersPK.idusers = :idusers"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.usersPK.userID = :userID"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByMiddleName", query = "SELECT u FROM Users u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByIdentificationType", query = "SELECT u FROM Users u WHERE u.identificationType = :identificationType"),
    @NamedQuery(name = "Users.findByIndentificationNumber", query = "SELECT u FROM Users u WHERE u.indentificationNumber = :indentificationNumber"),
    @NamedQuery(name = "Users.findByDob", query = "SELECT u FROM Users u WHERE u.dob = :dob"),
    @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByPostalAddress", query = "SELECT u FROM Users u WHERE u.postalAddress = :postalAddress"),
    @NamedQuery(name = "Users.findByPostalCode", query = "SELECT u FROM Users u WHERE u.postalCode = :postalCode"),
    @NamedQuery(name = "Users.findByNationality", query = "SELECT u FROM Users u WHERE u.nationality = :nationality"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByDateAdded", query = "SELECT u FROM Users u WHERE u.dateAdded = :dateAdded"),
    @NamedQuery(name = "Users.findByRoleID", query = "SELECT u FROM Users u WHERE u.roleID = :roleID")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersPK usersPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "middleName")
    private String middleName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "identificationType")
    private Integer identificationType;
    @Size(max = 45)
    @Column(name = "indentificationNumber")
    private String indentificationNumber;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Size(max = 45)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "postalAddress")
    private String postalAddress;
    @Size(max = 45)
    @Column(name = "postalCode")
    private String postalCode;
    @Size(max = 45)
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "phone")
    private Integer phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roleID")
    private int roleID;
    @JoinColumn(name = "userID", referencedColumnName = "iduserRoles", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Userroles userroles;
    @OneToMany(mappedBy = "userCode")
    private Collection<Accounts> accountsCollection;
    @OneToMany(mappedBy = "merchantsID")
    private Collection<Qrcodedetails> qrcodedetailsCollection;
    @OneToMany(mappedBy = "createdBy")
    private Collection<Audittrail> audittrailCollection;

    public Users() {
    }

    public Users(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public Users(UsersPK usersPK, String firstName, String middleName, int roleID) {
        this.usersPK = usersPK;
        this.firstName = firstName;
        this.middleName = middleName;
        this.roleID = roleID;
    }

    public Users(int idusers, int userID) {
        this.usersPK = new UsersPK(idusers, userID);
    }

    public UsersPK getUsersPK() {
        return usersPK;
    }

    public void setUsersPK(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(Integer identificationType) {
        this.identificationType = identificationType;
    }

    public String getIndentificationNumber() {
        return indentificationNumber;
    }

    public void setIndentificationNumber(String indentificationNumber) {
        this.indentificationNumber = indentificationNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Userroles getUserroles() {
        return userroles;
    }

    public void setUserroles(Userroles userroles) {
        this.userroles = userroles;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<Qrcodedetails> getQrcodedetailsCollection() {
        return qrcodedetailsCollection;
    }

    public void setQrcodedetailsCollection(Collection<Qrcodedetails> qrcodedetailsCollection) {
        this.qrcodedetailsCollection = qrcodedetailsCollection;
    }

    @XmlTransient
    public Collection<Audittrail> getAudittrailCollection() {
        return audittrailCollection;
    }

    public void setAudittrailCollection(Collection<Audittrail> audittrailCollection) {
        this.audittrailCollection = audittrailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersPK != null ? usersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usersPK == null && other.usersPK != null) || (this.usersPK != null && !this.usersPK.equals(other.usersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Users[ usersPK=" + usersPK + " ]";
    }
    
}
