/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PROBOOK
 */
@Embeddable
public class UsersPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idusers")
    private int idusers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userID")
    private int userID;

    public UsersPK() {
    }

    public UsersPK(int idusers, int userID) {
        this.idusers = idusers;
        this.userID = userID;
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idusers;
        hash += (int) userID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPK)) {
            return false;
        }
        UsersPK other = (UsersPK) object;
        if (this.idusers != other.idusers) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.UsersPK[ idusers=" + idusers + ", userID=" + userID + " ]";
    }
    
}
