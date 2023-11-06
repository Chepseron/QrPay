/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "identificationtypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identificationtypes.findAll", query = "SELECT i FROM Identificationtypes i"),
    @NamedQuery(name = "Identificationtypes.findByIdidentificationTypes", query = "SELECT i FROM Identificationtypes i WHERE i.ididentificationTypes = :ididentificationTypes"),
    @NamedQuery(name = "Identificationtypes.findByIdentificationTypeName", query = "SELECT i FROM Identificationtypes i WHERE i.identificationTypeName = :identificationTypeName"),
    @NamedQuery(name = "Identificationtypes.findByIdentificationTypeDescription", query = "SELECT i FROM Identificationtypes i WHERE i.identificationTypeDescription = :identificationTypeDescription")})
public class Identificationtypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ididentificationTypes")
    private Integer ididentificationTypes;
    @Size(max = 100)
    @Column(name = "identificationTypeName")
    private String identificationTypeName;
    @Size(max = 200)
    @Column(name = "identificationTypeDescription")
    private String identificationTypeDescription;

    public Identificationtypes() {
    }

    public Identificationtypes(Integer ididentificationTypes) {
        this.ididentificationTypes = ididentificationTypes;
    }

    public Integer getIdidentificationTypes() {
        return ididentificationTypes;
    }

    public void setIdidentificationTypes(Integer ididentificationTypes) {
        this.ididentificationTypes = ididentificationTypes;
    }

    public String getIdentificationTypeName() {
        return identificationTypeName;
    }

    public void setIdentificationTypeName(String identificationTypeName) {
        this.identificationTypeName = identificationTypeName;
    }

    public String getIdentificationTypeDescription() {
        return identificationTypeDescription;
    }

    public void setIdentificationTypeDescription(String identificationTypeDescription) {
        this.identificationTypeDescription = identificationTypeDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ididentificationTypes != null ? ididentificationTypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identificationtypes)) {
            return false;
        }
        Identificationtypes other = (Identificationtypes) object;
        if ((this.ididentificationTypes == null && other.ididentificationTypes != null) || (this.ididentificationTypes != null && !this.ididentificationTypes.equals(other.ididentificationTypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Identificationtypes[ ididentificationTypes=" + ididentificationTypes + " ]";
    }
    
}
