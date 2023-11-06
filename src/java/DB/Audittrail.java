/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "audittrail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audittrail.findAll", query = "SELECT a FROM Audittrail a"),
    @NamedQuery(name = "Audittrail.findByIdauditTrail", query = "SELECT a FROM Audittrail a WHERE a.idauditTrail = :idauditTrail"),
    @NamedQuery(name = "Audittrail.findByActionPerformed", query = "SELECT a FROM Audittrail a WHERE a.actionPerformed = :actionPerformed"),
    @NamedQuery(name = "Audittrail.findByDateCreated", query = "SELECT a FROM Audittrail a WHERE a.dateCreated = :dateCreated")})
public class Audittrail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauditTrail")
    private Integer idauditTrail;
    @Size(max = 200)
    @Column(name = "actionPerformed")
    private String actionPerformed;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JoinColumn(name = "createdBy", referencedColumnName = "idusers")
    @ManyToOne
    private Users createdBy;

    public Audittrail() {
    }

    public Audittrail(Integer idauditTrail) {
        this.idauditTrail = idauditTrail;
    }

    public Integer getIdauditTrail() {
        return idauditTrail;
    }

    public void setIdauditTrail(Integer idauditTrail) {
        this.idauditTrail = idauditTrail;
    }

    public String getActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(String actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditTrail != null ? idauditTrail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audittrail)) {
            return false;
        }
        Audittrail other = (Audittrail) object;
        if ((this.idauditTrail == null && other.idauditTrail != null) || (this.idauditTrail != null && !this.idauditTrail.equals(other.idauditTrail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Audittrail[ idauditTrail=" + idauditTrail + " ]";
    }
    
}
