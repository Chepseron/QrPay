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
@Table(name = "qrcodedetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qrcodedetails.findAll", query = "SELECT q FROM Qrcodedetails q"),
    @NamedQuery(name = "Qrcodedetails.findByIdQrCodeDetails", query = "SELECT q FROM Qrcodedetails q WHERE q.idQrCodeDetails = :idQrCodeDetails"),
    @NamedQuery(name = "Qrcodedetails.findByQrCodeType", query = "SELECT q FROM Qrcodedetails q WHERE q.qrCodeType = :qrCodeType"),
    @NamedQuery(name = "Qrcodedetails.findByQrCodeVersion", query = "SELECT q FROM Qrcodedetails q WHERE q.qrCodeVersion = :qrCodeVersion"),
    @NamedQuery(name = "Qrcodedetails.findByCountryCode", query = "SELECT q FROM Qrcodedetails q WHERE q.countryCode = :countryCode"),
    @NamedQuery(name = "Qrcodedetails.findByPostalCode", query = "SELECT q FROM Qrcodedetails q WHERE q.postalCode = :postalCode"),
    @NamedQuery(name = "Qrcodedetails.findByAccountInfo", query = "SELECT q FROM Qrcodedetails q WHERE q.accountInfo = :accountInfo"),
    @NamedQuery(name = "Qrcodedetails.findByMerchantCategoryCode", query = "SELECT q FROM Qrcodedetails q WHERE q.merchantCategoryCode = :merchantCategoryCode"),
    @NamedQuery(name = "Qrcodedetails.findByCreationDate", query = "SELECT q FROM Qrcodedetails q WHERE q.creationDate = :creationDate"),
    @NamedQuery(name = "Qrcodedetails.findByModifiedDate", query = "SELECT q FROM Qrcodedetails q WHERE q.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Qrcodedetails.findByTransactionCurrency", query = "SELECT q FROM Qrcodedetails q WHERE q.transactionCurrency = :transactionCurrency"),
    @NamedQuery(name = "Qrcodedetails.findByTransactionAmount", query = "SELECT q FROM Qrcodedetails q WHERE q.transactionAmount = :transactionAmount"),
    @NamedQuery(name = "Qrcodedetails.findByConvinienceIndicator", query = "SELECT q FROM Qrcodedetails q WHERE q.convinienceIndicator = :convinienceIndicator"),
    @NamedQuery(name = "Qrcodedetails.findByConvinienceFeeFixed", query = "SELECT q FROM Qrcodedetails q WHERE q.convinienceFeeFixed = :convinienceFeeFixed"),
    @NamedQuery(name = "Qrcodedetails.findByConvinienceFeePercentage", query = "SELECT q FROM Qrcodedetails q WHERE q.convinienceFeePercentage = :convinienceFeePercentage"),
    @NamedQuery(name = "Qrcodedetails.findByQrCodeImage", query = "SELECT q FROM Qrcodedetails q WHERE q.qrCodeImage = :qrCodeImage"),
    @NamedQuery(name = "Qrcodedetails.findByCheckSumValue", query = "SELECT q FROM Qrcodedetails q WHERE q.checkSumValue = :checkSumValue"),
    @NamedQuery(name = "Qrcodedetails.findByOtherInfo", query = "SELECT q FROM Qrcodedetails q WHERE q.otherInfo = :otherInfo")})
public class Qrcodedetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQrCodeDetails")
    private Integer idQrCodeDetails;
    @Size(max = 45)
    @Column(name = "qrCodeType")
    private String qrCodeType;
    @Column(name = "qrCodeVersion")
    private Integer qrCodeVersion;
    @Size(max = 45)
    @Column(name = "countryCode")
    private String countryCode;
    @Size(max = 45)
    @Column(name = "postalCode")
    private String postalCode;
    @Size(max = 45)
    @Column(name = "accountInfo")
    private String accountInfo;
    @Size(max = 45)
    @Column(name = "merchantCategoryCode")
    private String merchantCategoryCode;
    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Size(max = 45)
    @Column(name = "transactionCurrency")
    private String transactionCurrency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "transactionAmount")
    private Float transactionAmount;
    @Column(name = "convinienceIndicator")
    private Integer convinienceIndicator;
    @Column(name = "convinienceFeeFixed")
    private Long convinienceFeeFixed;
    @Column(name = "convinienceFeePercentage")
    private Long convinienceFeePercentage;
    @Size(max = 200)
    @Column(name = "qrCodeImage")
    private String qrCodeImage;
    @Size(max = 45)
    @Column(name = "checkSumValue")
    private String checkSumValue;
    @Size(max = 300)
    @Column(name = "otherInfo")
    private String otherInfo;
    @JoinColumn(name = "merchantsID", referencedColumnName = "idusers")
    @ManyToOne
    private Users merchantsID;

    public Qrcodedetails() {
    }

    public Qrcodedetails(Integer idQrCodeDetails) {
        this.idQrCodeDetails = idQrCodeDetails;
    }

    public Integer getIdQrCodeDetails() {
        return idQrCodeDetails;
    }

    public void setIdQrCodeDetails(Integer idQrCodeDetails) {
        this.idQrCodeDetails = idQrCodeDetails;
    }

    public String getQrCodeType() {
        return qrCodeType;
    }

    public void setQrCodeType(String qrCodeType) {
        this.qrCodeType = qrCodeType;
    }

    public Integer getQrCodeVersion() {
        return qrCodeVersion;
    }

    public void setQrCodeVersion(Integer qrCodeVersion) {
        this.qrCodeVersion = qrCodeVersion;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public Float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getConvinienceIndicator() {
        return convinienceIndicator;
    }

    public void setConvinienceIndicator(Integer convinienceIndicator) {
        this.convinienceIndicator = convinienceIndicator;
    }

    public Long getConvinienceFeeFixed() {
        return convinienceFeeFixed;
    }

    public void setConvinienceFeeFixed(Long convinienceFeeFixed) {
        this.convinienceFeeFixed = convinienceFeeFixed;
    }

    public Long getConvinienceFeePercentage() {
        return convinienceFeePercentage;
    }

    public void setConvinienceFeePercentage(Long convinienceFeePercentage) {
        this.convinienceFeePercentage = convinienceFeePercentage;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }

    public String getCheckSumValue() {
        return checkSumValue;
    }

    public void setCheckSumValue(String checkSumValue) {
        this.checkSumValue = checkSumValue;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Users getMerchantsID() {
        return merchantsID;
    }

    public void setMerchantsID(Users merchantsID) {
        this.merchantsID = merchantsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQrCodeDetails != null ? idQrCodeDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qrcodedetails)) {
            return false;
        }
        Qrcodedetails other = (Qrcodedetails) object;
        if ((this.idQrCodeDetails == null && other.idQrCodeDetails != null) || (this.idQrCodeDetails != null && !this.idQrCodeDetails.equals(other.idQrCodeDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Qrcodedetails[ idQrCodeDetails=" + idQrCodeDetails + " ]";
    }
    
}
