package com.ibexsys.pwd.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;


import javax.persistence.Column;

import java.util.Arrays;
import java.sql.Timestamp;



@Entity
@Table(name = "Site")
public class Site implements Serializable {

	private static final long serialVersionUID = 6874935206297050168L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SiteId")
	private Integer siteId;
	
	@Column(name = "Name")
	private String siteName;
	
	@Column(name = "CatId")
	private Integer catId;
	
	@Column(name = "AppUserId")
	private Integer appUserId;

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

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int  siteId) {
		this.siteId = siteId;
	}

	
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public Integer getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(Integer appUserId) {
		this.appUserId = appUserId;
	}

	public String getSiteURL() {
		return siteURL;
	}

	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
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

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Timestamp getCreateDTM() {
		return createDTM;
	}

	public void setCreateDTM(Timestamp created) {
		this.createDTM = created;
	}

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
