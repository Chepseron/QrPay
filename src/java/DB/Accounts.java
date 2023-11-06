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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByIdaccounts", query = "SELECT a FROM Accounts a WHERE a.idaccounts = :idaccounts"),
    @NamedQuery(name = "Accounts.findByAccountName", query = "SELECT a FROM Accounts a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Accounts.findByCustomerCode", query = "SELECT a FROM Accounts a WHERE a.customerCode = :customerCode"),
    @NamedQuery(name = "Accounts.findByDateOpened", query = "SELECT a FROM Accounts a WHERE a.dateOpened = :dateOpened"),
    @NamedQuery(name = "Accounts.findByBalance", query = "SELECT a FROM Accounts a WHERE a.balance = :balance")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaccounts")
    private Integer idaccounts;
    @Size(max = 45)
    @Column(name = "accountName")
    private String accountName;
    @Size(max = 45)
    @Column(name = "customerCode")
    private String customerCode;
    @Column(name = "dateOpened")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOpened;
    @Column(name = "balance")
    private Long balance;
    @OneToMany(mappedBy = "fromAccount")
    private Collection<Transactions> transactionsCollection;
    @JoinColumn(name = "userCode", referencedColumnName = "idusers")
    @ManyToOne
    private Users userCode;
    @JoinColumn(name = "bankCode", referencedColumnName = "idbanks")
    @ManyToOne
    private Banks bankCode;

    public Accounts() {
    }

    public Accounts(Integer idaccounts) {
        this.idaccounts = idaccounts;
    }

    public Integer getIdaccounts() {
        return idaccounts;
    }

    public void setIdaccounts(Integer idaccounts) {
        this.idaccounts = idaccounts;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    public Users getUserCode() {
        return userCode;
    }

    public void setUserCode(Users userCode) {
        this.userCode = userCode;
    }

    public Banks getBankCode() {
        return bankCode;
    }

    public void setBankCode(Banks bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccounts != null ? idaccounts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.idaccounts == null && other.idaccounts != null) || (this.idaccounts != null && !this.idaccounts.equals(other.idaccounts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Accounts[ idaccounts=" + idaccounts + " ]";
    }
    
}
