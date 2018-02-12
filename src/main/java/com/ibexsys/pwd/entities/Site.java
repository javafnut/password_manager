package com.ibexsys.pwd.entities;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;

import java.util.Arrays;
import java.sql.Timestamp;

@Entity
@Table(name = "Site")
public class Site implements Serializable {

	private static final long serialVersionUID = 6874935206297050168L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SiteId")
	private Integer siteId;
	
	@Column(name = "Name")
	private String siteName;
	
	@Column(name = "CatId")
	private Integer catId;
	
	@Column(name = "UserId")
	private Integer userId;

	@Column(name = "SiteURL")
	private String siteURL;
	
	@Column(name = "Login")
	private String login;
	
	@Column(name = "SitePwd")
	private byte[] password;
	
	@Column(name = "Notes")
	private String notes;

	@Column(name = "CreatedDTM")
	private Timestamp createdDTM;
	
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
		return userId;
	}

	public void setAppUserId(Integer appUserId) {
		this.userId = appUserId;
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

	public Timestamp getCreatedDTM() {
		return createdDTM;
	}

	public void setCreatedDTM(Timestamp created) {
		this.createdDTM = created;
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
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((createdDTM == null) ? 0 : createdDTM.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + ((siteId == null) ? 0 : siteId.hashCode());
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (createdDTM == null) {
			if (other.createdDTM != null)
				return false;
		} else if (!createdDTM.equals(other.createdDTM))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
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
		if (siteId == null) {
			if (other.siteId != null)
				return false;
		} else if (!siteId.equals(other.siteId))
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
		return "Site [siteId=" + siteId + ", siteName=" + siteName + ", catId=" + catId + ", appUserId=" + userId
				+ ", siteURL=" + siteURL + ", siteLogin=" + login + ", password=" + Arrays.toString(password)
				+ ", notes=" + notes + ", createdDTM=" + createdDTM + ", modifiedDTM=" + modifiedDTM + "]";
	}


}
