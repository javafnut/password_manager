/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibexsys.pwd.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author jsc
 */


@XmlRootElement(name = "site")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "siteName", "catId","appUserId","siteURL", "siteLogin",
                       "password", "notes", "createDate", "modDate"})
public class Site { 
    
    private long siteId;
    private String siteName;
    private long catId;
    private long appUserId;

    private String siteURL;
    private String siteLogin;
    private byte[] password;
    private String notes;
    //private String pwdText;


    
    // Change To Date
    private Date createDate;
    private Date modDate;
    

    @XmlAttribute
    public long getSiteId() {
        return siteId;
    }

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}


	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	/**
	 * @return the catId
	 */
	public long getCatId() {
		return catId;
	}


	/**
	 * @param catId the catId to set
	 */
	public void setCatId(long catId) {
		this.catId = catId;
	}


	/**
	 * @return the appUserId
	 */
	public long getAppUserId() {
		return appUserId;
	}


	/**
	 * @param appUserId the appUserId to set
	 */
	public void setAppUserId(long appUserId) {
		this.appUserId = appUserId;
	}


	/**
	 * @return the siteURL
	 */
	public String getSiteURL() {
		return siteURL;
	}


	/**
	 * @param siteURL the siteURL to set
	 */
	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}


	/**
	 * @return the siteLogin
	 */
	public String getSiteLogin() {
		return siteLogin;
	}


	/**
	 * @param siteLogin the siteLogin to set
	 */
	public void setSiteLogin(String siteLogin) {
		this.siteLogin = siteLogin;
	}


	/**
	 * @return the password
	 */
	public byte[] getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}


	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}


	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}


	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}


	/**
	 * @param date the createDate to set
	 */
	public void setCreateDate(Date date) {
		this.createDate = date;
	}


	/**
	 * @return the modDate
	 */
	public Date getModDate() {
		return modDate;
	}


	/**
	 * @param modDate the modDate to set
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (appUserId ^ (appUserId >>> 32));
		result = prime * result + (int) (catId ^ (catId >>> 32));
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((modDate == null) ? 0 : modDate.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + (int) (siteId ^ (siteId >>> 32));
		result = prime * result + ((siteLogin == null) ? 0 : siteLogin.hashCode());
		result = prime * result + ((siteName == null) ? 0 : siteName.hashCode());
		result = prime * result + ((siteURL == null) ? 0 : siteURL.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Site other = (Site) obj;
		if (appUserId != other.appUserId)
			return false;
		if (catId != other.catId)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (modDate == null) {
			if (other.modDate != null)
				return false;
		} else if (!modDate.equals(other.modDate))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (siteId != other.siteId)
			return false;
		if (siteLogin == null) {
			if (other.siteLogin != null)
				return false;
		} else if (!siteLogin.equals(other.siteLogin))
			return false;
		if (siteName == null) {
			if (other.siteName != null)
				return false;
		} else if (!siteName.equals(other.siteName))
			return false;
		if (siteURL == null) {
			if (other.siteURL != null)
				return false;
		} else if (!siteURL.equals(other.siteURL))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", siteName=" + siteName + ", catId=" + catId + ", appUserId=" + appUserId
				+ ", siteURL=" + siteURL + ", siteLogin=" + siteLogin + ", password=" + Arrays.toString(password)
				+ ", notes=" + notes + ", createDate=" + createDate + ", modDate=" + modDate + "]";
	}






}
