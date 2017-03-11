package com.ibexsys.pwd.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Arrays;
import java.sql.Timestamp;

@XmlType(propOrder = { "siteName", "catID", "siteURL", "siteLogin", "password", "notes", "createDate", "modDate" })
public class Site {

	private long siteID;
	private String siteName;
	private long catID;
	private long appUserID;

	private String siteURL;
	private String siteLogin;
	private byte[] password;
	private String notes;

	private Timestamp createDTM;
	private Timestamp modifiedDTM;

	@XmlAttribute(name = "SiteID")
	public long getSiteID() {
		return siteID;
	}

	public void setSiteID(long siteID) {
		this.siteID = siteID;
	}

	@XmlElement(name = "name")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@XmlElement(name = "catID")
	public long getCatID() {
		return catID;
	}

	public void setCatID(long catID) {
		this.catID = catID;
	}

	public long getAppUserID() {
		return appUserID;
	}

	public void setAppUserID(long appUserID) {
		this.appUserID = appUserID;
	}

	@XmlElement(name = "URL")
	public String getSiteURL() {
		return siteURL;
	}

	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}

	@XmlElement(name = "login")
	public String getSiteLogin() {
		return siteLogin;
	}

	public void setSiteLogin(String siteLogin) {
		this.siteLogin = siteLogin;
	}

	@XmlElement(name = "password")
	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	@XmlElement(name = "notes")
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@XmlElement(name = "created")
	public Timestamp getCreateDTM() {
		return createDTM;
	}

	public void setCreateDTM(Timestamp created) {
		this.createDTM = created;
	}

	@XmlElement(name = "modified")
	public Timestamp getModifiedDTM() {
		return modifiedDTM;
	}

	public void setModifiedDTM(Timestamp modDTM) {
		this.modifiedDTM = modDTM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (appUserID ^ (appUserID >>> 32));
		result = prime * result + (int) (catID ^ (catID >>> 32));
		result = prime * result + ((createDTM == null) ? 0 : createDTM.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + (int) (siteID ^ (siteID >>> 32));
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
		if (appUserID != other.appUserID)
			return false;
		if (catID != other.catID)
			return false;
		if (createDTM == null) {
			if (other.createDTM != null)
				return false;
		} else if (!createDTM.equals(other.createDTM))
			return false;
		if (modifiedDTM == null) {
			if (other.modifiedDTM != null)
				return false;
		} else if (!modifiedDTM.equals(other.modifiedDTM))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (siteID != other.siteID)
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
		return "Site [siteID=" + siteID + ", siteName=" + siteName + ", catID=" + catID + ", appUserID=" + appUserID
				+ ", siteURL=" + siteURL + ", siteLogin=" + siteLogin + ", password=" + Arrays.toString(password)
				+ ", notes=" + notes + ", createDTM=" + createDTM + ", modifiedDTM=" + modifiedDTM + "]";
	}

}
