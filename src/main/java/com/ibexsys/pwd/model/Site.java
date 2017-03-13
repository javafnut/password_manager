package com.ibexsys.pwd.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;


import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Arrays;
import java.sql.Timestamp;



@Entity
@Table(name = "Site")
@XmlType(propOrder = {"SiteId", "siteName", "catId", "siteURL", "siteLogin", "password", "notes", "createdDTM", "modifiedDTM" })
public class Site implements Serializable {

	private static final long serialVersionUID = 6874935206297050168L;

	@Column(name = "SiteId")
	private int siteId;
	
	@Column(name = "Name")
	private String siteName;
	
	@Column(name = "CatId")
	private int catId;
	
	@Column(name = "AppUserId")
	private int appUserId;

	@Column(name = "SiteURL")
	private String siteURL;
	
	@Column(name = "Login")
	private String login;
	
	@Column(name = "Password")
	private byte[] password;
	
	@Column(name = "Notes")
	private String notes;

	@Column(name = "CreatedDTM")
	private Timestamp createDTM;
	
	@Column(name = "ModifiedDTM")
	private Timestamp modifiedDTM;

	@XmlAttribute(name = "SiteId")
	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int  siteId) {
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
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
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
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
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
				+ ", siteURL=" + siteURL + ", siteLogin=" + login + ", password=" + Arrays.toString(password)
				+ ", notes=" + notes + ", createDTM=" + createDTM + ", modifiedDTM=" + modifiedDTM + "]";
	}

}
