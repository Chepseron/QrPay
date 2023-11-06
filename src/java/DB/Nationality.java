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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "nationality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationality.findAll", query = "SELECT n FROM Nationality n"),
    @NamedQuery(name = "Nationality.findByIdnationality", query = "SELECT n FROM Nationality n WHERE n.idnationality = :idnationality"),
    @NamedQuery(name = "Nationality.findByNationalityName", query = "SELECT n FROM Nationality n WHERE n.nationalityName = :nationalityName")})
public class Nationality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnationality")
    private Integer idnationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nationalityName")
    private String nationalityName;

    public Nationality() {
    }

    public Nationality(Integer idnationality) {
        this.idnationality = idnationality;
    }

    public Nationality(Integer idnationality, String nationalityName) {
        this.idnationality = idnationality;
        this.nationalityName = nationalityName;
    }

    public Integer getIdnationality() {
        return idnationality;
    }

    public void setIdnationality(Integer idnationality) {
        this.idnationality = idnationality;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnationality != null ? idnationality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nationality)) {
            return false;
        }
        Nationality other = (Nationality) object;
        if ((this.idnationality == null && other.idnationality != null) || (this.idnationality != null && !this.idnationality.equals(other.idnationality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Nationality[ idnationality=" + idnationality + " ]";
    }
    
}
