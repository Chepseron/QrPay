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
@Table(name = "transactiontypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactiontypes.findAll", query = "SELECT t FROM Transactiontypes t"),
    @NamedQuery(name = "Transactiontypes.findByIdtransactionTypes", query = "SELECT t FROM Transactiontypes t WHERE t.idtransactionTypes = :idtransactionTypes"),
    @NamedQuery(name = "Transactiontypes.findByTransactionTypeDescription", query = "SELECT t FROM Transactiontypes t WHERE t.transactionTypeDescription = :transactionTypeDescription"),
    @NamedQuery(name = "Transactiontypes.findByTransactionTypeName", query = "SELECT t FROM Transactiontypes t WHERE t.transactionTypeName = :transactionTypeName")})
public class Transactiontypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransactionTypes")
    private Integer idtransactionTypes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "transactionTypeDescription")
    private String transactionTypeDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transactionTypeName")
    private String transactionTypeName;

    public Transactiontypes() {
    }

    public Transactiontypes(Integer idtransactionTypes) {
        this.idtransactionTypes = idtransactionTypes;
    }

    public Transactiontypes(Integer idtransactionTypes, String transactionTypeDescription, String transactionTypeName) {
        this.idtransactionTypes = idtransactionTypes;
        this.transactionTypeDescription = transactionTypeDescription;
        this.transactionTypeName = transactionTypeName;
    }

    public Integer getIdtransactionTypes() {
        return idtransactionTypes;
    }

    public void setIdtransactionTypes(Integer idtransactionTypes) {
        this.idtransactionTypes = idtransactionTypes;
    }

    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransactionTypes != null ? idtransactionTypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactiontypes)) {
            return false;
        }
        Transactiontypes other = (Transactiontypes) object;
        if ((this.idtransactionTypes == null && other.idtransactionTypes != null) || (this.idtransactionTypes != null && !this.idtransactionTypes.equals(other.idtransactionTypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Transactiontypes[ idtransactionTypes=" + idtransactionTypes + " ]";
    }
    
}
