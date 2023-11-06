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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "userroles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userroles.findAll", query = "SELECT u FROM Userroles u"),
    @NamedQuery(name = "Userroles.findByIduserRoles", query = "SELECT u FROM Userroles u WHERE u.iduserRoles = :iduserRoles"),
    @NamedQuery(name = "Userroles.findByRoleCode", query = "SELECT u FROM Userroles u WHERE u.roleCode = :roleCode"),
    @NamedQuery(name = "Userroles.findByUserCode", query = "SELECT u FROM Userroles u WHERE u.userCode = :userCode"),
    @NamedQuery(name = "Userroles.findByDateAdded", query = "SELECT u FROM Userroles u WHERE u.dateAdded = :dateAdded")})
public class Userroles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduserRoles")
    private Integer iduserRoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roleCode")
    private int roleCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userCode")
    private int userCode;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userroles")
    private Collection<Users> usersCollection;

    public Userroles() {
    }

    public Userroles(Integer iduserRoles) {
        this.iduserRoles = iduserRoles;
    }

    public Userroles(Integer iduserRoles, int roleCode, int userCode) {
        this.iduserRoles = iduserRoles;
        this.roleCode = roleCode;
        this.userCode = userCode;
    }

    public Integer getIduserRoles() {
        return iduserRoles;
    }

    public void setIduserRoles(Integer iduserRoles) {
        this.iduserRoles = iduserRoles;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserRoles != null ? iduserRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userroles)) {
            return false;
        }
        Userroles other = (Userroles) object;
        if ((this.iduserRoles == null && other.iduserRoles != null) || (this.iduserRoles != null && !this.iduserRoles.equals(other.iduserRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Userroles[ iduserRoles=" + iduserRoles + " ]";
    }
    
}
