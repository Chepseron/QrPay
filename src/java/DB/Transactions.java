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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PROBOOK
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByIdtransactions", query = "SELECT t FROM Transactions t WHERE t.idtransactions = :idtransactions"),
    @NamedQuery(name = "Transactions.findByTransactionDate", query = "SELECT t FROM Transactions t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transactions.findByTotalAmount", query = "SELECT t FROM Transactions t WHERE t.totalAmount = :totalAmount"),
    @NamedQuery(name = "Transactions.findByToAccount", query = "SELECT t FROM Transactions t WHERE t.toAccount = :toAccount"),
    @NamedQuery(name = "Transactions.findByTransactionTypeCode", query = "SELECT t FROM Transactions t WHERE t.transactionTypeCode = :transactionTypeCode"),
    @NamedQuery(name = "Transactions.findByProductAmount", query = "SELECT t FROM Transactions t WHERE t.productAmount = :productAmount"),
    @NamedQuery(name = "Transactions.findByTransactionChargeCode", query = "SELECT t FROM Transactions t WHERE t.transactionChargeCode = :transactionChargeCode")})
public class Transactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransactions")
    private Integer idtransactions;
    @Column(name = "transactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Column(name = "totalAmount")
    private Long totalAmount;
    @Column(name = "toAccount")
    private Integer toAccount;
    @Column(name = "transactionTypeCode")
    private Integer transactionTypeCode;
    @Column(name = "productAmount")
    private Long productAmount;
    @Column(name = "transactionChargeCode")
    private Integer transactionChargeCode;
    @JoinColumn(name = "fromAccount", referencedColumnName = "idaccounts")
    @ManyToOne
    private Accounts fromAccount;

    public Transactions() {
    }

    public Transactions(Integer idtransactions) {
        this.idtransactions = idtransactions;
    }

    public Integer getIdtransactions() {
        return idtransactions;
    }

    public void setIdtransactions(Integer idtransactions) {
        this.idtransactions = idtransactions;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getToAccount() {
        return toAccount;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccount = toAccount;
    }

    public Integer getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(Integer transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public Long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Long productAmount) {
        this.productAmount = productAmount;
    }

    public Integer getTransactionChargeCode() {
        return transactionChargeCode;
    }

    public void setTransactionChargeCode(Integer transactionChargeCode) {
        this.transactionChargeCode = transactionChargeCode;
    }

    public Accounts getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Accounts fromAccount) {
        this.fromAccount = fromAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransactions != null ? idtransactions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.idtransactions == null && other.idtransactions != null) || (this.idtransactions != null && !this.idtransactions.equals(other.idtransactions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Transactions[ idtransactions=" + idtransactions + " ]";
    }
    
}
