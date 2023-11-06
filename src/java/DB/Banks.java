/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "banks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banks.findAll", query = "SELECT b FROM Banks b"),
    @NamedQuery(name = "Banks.findByIdbanks", query = "SELECT b FROM Banks b WHERE b.idbanks = :idbanks"),
    @NamedQuery(name = "Banks.findByBankName", query = "SELECT b FROM Banks b WHERE b.bankName = :bankName"),
    @NamedQuery(name = "Banks.findByBankCode", query = "SELECT b FROM Banks b WHERE b.bankCode = :bankCode"),
    @NamedQuery(name = "Banks.findByBankUrl", query = "SELECT b FROM Banks b WHERE b.bankUrl = :bankUrl"),
    @NamedQuery(name = "Banks.findByOtherDetails", query = "SELECT b FROM Banks b WHERE b.otherDetails = :otherDetails")})
public class Banks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbanks")
    private Integer idbanks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bankName")
    private String bankName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bankCode")
    private String bankCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "bankUrl")
    private String bankUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "otherDetails")
    private String otherDetails;
    @OneToMany(mappedBy = "bankCode")
    private Collection<Accounts> accountsCollection;

    public Banks() {
    }

    public Banks(Integer idbanks) {
        this.idbanks = idbanks;
    }

    public Banks(Integer idbanks, String bankName, String bankCode, String bankUrl, String otherDetails) {
        this.idbanks = idbanks;
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.bankUrl = bankUrl;
        this.otherDetails = otherDetails;
    }

    public Integer getIdbanks() {
        return idbanks;
    }

    public void setIdbanks(Integer idbanks) {
        this.idbanks = idbanks;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankUrl() {
        return bankUrl;
    }

    public void setBankUrl(String bankUrl) {
        this.bankUrl = bankUrl;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbanks != null ? idbanks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banks)) {
            return false;
        }
        Banks other = (Banks) object;
        if ((this.idbanks == null && other.idbanks != null) || (this.idbanks != null && !this.idbanks.equals(other.idbanks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Banks[ idbanks=" + idbanks + " ]";
    }
    
}
