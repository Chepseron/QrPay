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
@Table(name = "transactioncharges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactioncharges.findAll", query = "SELECT t FROM Transactioncharges t"),
    @NamedQuery(name = "Transactioncharges.findByIdtransactionCharges", query = "SELECT t FROM Transactioncharges t WHERE t.idtransactionCharges = :idtransactionCharges"),
    @NamedQuery(name = "Transactioncharges.findByTransactionChargeID", query = "SELECT t FROM Transactioncharges t WHERE t.transactionChargeID = :transactionChargeID"),
    @NamedQuery(name = "Transactioncharges.findByFromAmount", query = "SELECT t FROM Transactioncharges t WHERE t.fromAmount = :fromAmount"),
    @NamedQuery(name = "Transactioncharges.findByToAmount", query = "SELECT t FROM Transactioncharges t WHERE t.toAmount = :toAmount"),
    @NamedQuery(name = "Transactioncharges.findByCharge", query = "SELECT t FROM Transactioncharges t WHERE t.charge = :charge"),
    @NamedQuery(name = "Transactioncharges.findByTransactionTypeCode", query = "SELECT t FROM Transactioncharges t WHERE t.transactionTypeCode = :transactionTypeCode"),
    @NamedQuery(name = "Transactioncharges.findByDateCreated", query = "SELECT t FROM Transactioncharges t WHERE t.dateCreated = :dateCreated")})
public class Transactioncharges implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransactionCharges")
    private Integer idtransactionCharges;
    @Column(name = "transactionChargeID")
    private Integer transactionChargeID;
    @Column(name = "fromAmount")
    private Long fromAmount;
    @Column(name = "toAmount")
    private Long toAmount;
    @Column(name = "charge")
    private Long charge;
    @Column(name = "transactionTypeCode")
    private Integer transactionTypeCode;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public Transactioncharges() {
    }

    public Transactioncharges(Integer idtransactionCharges) {
        this.idtransactionCharges = idtransactionCharges;
    }

    public Integer getIdtransactionCharges() {
        return idtransactionCharges;
    }

    public void setIdtransactionCharges(Integer idtransactionCharges) {
        this.idtransactionCharges = idtransactionCharges;
    }

    public Integer getTransactionChargeID() {
        return transactionChargeID;
    }

    public void setTransactionChargeID(Integer transactionChargeID) {
        this.transactionChargeID = transactionChargeID;
    }

    public Long getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(Long fromAmount) {
        this.fromAmount = fromAmount;
    }

    public Long getToAmount() {
        return toAmount;
    }

    public void setToAmount(Long toAmount) {
        this.toAmount = toAmount;
    }

    public Long getCharge() {
        return charge;
    }

    public void setCharge(Long charge) {
        this.charge = charge;
    }

    public Integer getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(Integer transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransactionCharges != null ? idtransactionCharges.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactioncharges)) {
            return false;
        }
        Transactioncharges other = (Transactioncharges) object;
        if ((this.idtransactionCharges == null && other.idtransactionCharges != null) || (this.idtransactionCharges != null && !this.idtransactionCharges.equals(other.idtransactionCharges))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Transactioncharges[ idtransactionCharges=" + idtransactionCharges + " ]";
    }
    
}
