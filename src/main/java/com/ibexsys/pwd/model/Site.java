package com.ibexsys.pwd.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Arrays;
import java.sql.Timestamp;

@XmlType(propOrder = { "siteName", "catId", "siteURL", "siteLogin", "password", "notes", "createDate", "modDate" })
public class Site {

	private long siteId;
	private String siteName;
	private long catId;
	private long appUserId;

	private String siteURL;
	private String siteLogin;
	private byte[] password;
	private String notes;

	private Timestamp createDTM;
	private Timestamp modifiedDTM;

	@XmlAttribute(name = "SiteID")
	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	@XmlElement(name = "name")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@XmlElement(name = "catID")
	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public long getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(long appUserId) {
		this.appUserId = appUserId;
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
		result = prime * result + (int) (appUserId ^ (appUserId >>> 32));
		result = prime * result + (int) (catId ^ (catId >>> 32));
		result = prime * result + ((createDTM == null) ? 0 : createDTM.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
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
				+ ", notes=" + notes + ", createDTM=" + createDTM + ", modifiedDTM=" + modifiedDTM + "]";
	}

}
