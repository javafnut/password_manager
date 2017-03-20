package com.ibexsys.pwd.entities;

import java.util.concurrent.ConcurrentHashMap;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "UserAppProfile")
public class PasswordAppProfile {

	private static PasswordAppProfile instance = null;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProfileId")
	private Integer profileId;

	@Column(name = "UserId")
	private Integer userId;

	@Column(name = "CategoryRootId")
	private Integer rootId;

	@Column(name = "Login")
	private String loginName;

	@Column(name = "LastLoginDTM")
	private Timestamp lastLoginDTM;

	@Column(name = "CreatedDTM")
	private Timestamp createdDTM;

	@Column(name = "ModifiedDTM")
	private Timestamp modifiedDTM;

	// @Column(name = "ActiveYN", nullable = false, columnDefinition =
	// "TINYINT", length = 1)
	// private Boolean isActive;
	//
	// @Column(name = "AccountLockedYN", nullable = false, columnDefinition =
	// "TINYINT(1)")
	// private boolean isAccountLocked;

    // With @OneToMany annotation, you can specify cascade option
    //@OneToMany(cascade=ALL)
	//@OneToMany
	@Transient
	private List<Site> siteList = new ArrayList<Site>();

	
	@Transient
	private Map<String, Site> siteMap;

	@Transient
	private Map<String, Category> categoryMap;

	@Transient
	private String pwdFileName;

    @Transient
	private User user;

	@Transient
	public Map<String, Site> getSitesMap() {
		return siteMap;
	}

	protected PasswordAppProfile() {

	}

	// @TODO - Use Spring Singleton

	public static PasswordAppProfile getInstance() {

		if (PasswordAppProfile.instance == null) {
			instance = new PasswordAppProfile();
		}

		return instance;
	}

	public void setSiteMap(Map<String, Site> siteMap) {
		this.siteMap = siteMap;
	}

	public void addSite(Site site) throws Exception {

		// @TODO - Exception
		if (site == null || user == null)
			throw new Exception("Either Site or AppUser is Null");

		if (siteMap != null) {
			siteMap.put(String.valueOf(site.getSiteId()), site);
		    
		} else {
			siteMap = new ConcurrentHashMap<String, Site>();
			siteMap.put(String.valueOf(site.getSiteId()), site);
		}
		
	    this.getSiteList().add(site);
	}

	public void addCategory(Category category) throws Exception {

		// @TODO - Exception
		if (category == null || user == null)
			throw new Exception("Either Category or AppUser is Null");

		if (categoryMap != null) {
			categoryMap.put(String.valueOf(category.getCatID()), category);
		} else {
			categoryMap = new ConcurrentHashMap<String, Category>();
			categoryMap.put(String.valueOf(category.getCatID()), category);
		}
	}

	public Map<String, Category> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String, Category> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public String getPwdFileName() {
		return pwdFileName;
	}

	public void setPwdFileName(String pPwdFileName) {
		pwdFileName = pPwdFileName;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Integer getAppUserId() {
		return userId;
	}

	public void setAppUserId(Integer appUserId) {
		this.userId = appUserId;
	}

	public Integer getRootId() {
		return rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Timestamp getLastLoginDTM() {
		return lastLoginDTM;
	}

	public void setLastLoginDTM(Timestamp lastLoginDTM) {
		this.lastLoginDTM = lastLoginDTM;
	}

	public User getAppUser() {
		return user;
	}

	public void setAppUser(User appUser) {
		this.user = appUser;
	}

	public Timestamp getCreatedDTM() {
		return createdDTM;
	}

	public void setCreatedDTM(Timestamp createdDTM) {
		this.createdDTM = createdDTM;
	}

	public Timestamp getModifiedDTM() {
		return modifiedDTM;
	}

	public void setModifiedDTM(Timestamp modifiedDTM) {
		this.modifiedDTM = modifiedDTM;
	}
	
	
	public List<Site> getSiteList() {
		return siteList;
	}

	public void setSiteList(List<Site> siteList) {
		this.siteList = siteList;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((categoryMap == null) ? 0 : categoryMap.hashCode());
		result = prime * result + ((createdDTM == null) ? 0 : createdDTM.hashCode());
		result = prime * result + ((lastLoginDTM == null) ? 0 : lastLoginDTM.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		result = prime * result + ((pwdFileName == null) ? 0 : pwdFileName.hashCode());
		result = prime * result + ((rootId == null) ? 0 : rootId.hashCode());
		result = prime * result + ((siteList == null) ? 0 : siteList.hashCode());
		result = prime * result + ((siteMap == null) ? 0 : siteMap.hashCode());
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
		PasswordAppProfile other = (PasswordAppProfile) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (categoryMap == null) {
			if (other.categoryMap != null)
				return false;
		} else if (!categoryMap.equals(other.categoryMap))
			return false;
		if (createdDTM == null) {
			if (other.createdDTM != null)
				return false;
		} else if (!createdDTM.equals(other.createdDTM))
			return false;
		if (lastLoginDTM == null) {
			if (other.lastLoginDTM != null)
				return false;
		} else if (!lastLoginDTM.equals(other.lastLoginDTM))
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (modifiedDTM == null) {
			if (other.modifiedDTM != null)
				return false;
		} else if (!modifiedDTM.equals(other.modifiedDTM))
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (pwdFileName == null) {
			if (other.pwdFileName != null)
				return false;
		} else if (!pwdFileName.equals(other.pwdFileName))
			return false;
		if (rootId == null) {
			if (other.rootId != null)
				return false;
		} else if (!rootId.equals(other.rootId))
			return false;
		if (siteList == null) {
			if (other.siteList != null)
				return false;
		} else if (!siteList.equals(other.siteList))
			return false;
		if (siteMap == null) {
			if (other.siteMap != null)
				return false;
		} else if (!siteMap.equals(other.siteMap))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PwdAppProfile [profileId=" + profileId + ", appUserId=" + userId + ", rootId=" + rootId
				+ ", loginName=" + loginName + ", lastLoginDTM=" + lastLoginDTM + ", createdDTM=" + createdDTM
				+ ", modifiedDTM=" + modifiedDTM + ", siteList=" + siteList + ", siteMap=" + siteMap + ", categoryMap="
				+ categoryMap + ", pwdFileName=" + pwdFileName + ", appUser=" + user + "]";
	}

}
