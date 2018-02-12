package com.ibexsys.pwd.entities;

import java.util.concurrent.ConcurrentHashMap;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "UserAppProfile")
public class UserAppProfile {

	private static UserAppProfile instance = null;
	public static final byte TRUE = 1;
	public static final byte FALSE = 0;

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

// NOTE: Problems with mapping mysql, need to further research, getters/setters removed	
//	@Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1)")
//	@Column(name = "Active", nullable = false)
//	@Type(type = "org.hibernate.type.NumericBooleanType")
//  @Column(name = "Active", nullable = false, columnDefinition = "BOOLEAN")
//	private boolean isActive;
//	@Column(name = "AccountLocked", nullable = false, columnDefinition = "TINYINT(1)")
//	private Byte isAccountLocked;

    // With @OneToMany annotation, you can specify cascade option
     @OneToMany(cascade=ALL)
//    @ManyToOne(cascade=ALL)
    @JoinColumn(name="UserId")
//	@Transient
	private List<Site> siteList = new ArrayList<Site>();

	
	@Transient
	private Map<String, Site> siteMap;

	@Transient
	private Map<String, Category> categoryMap;

	@Transient
	private String pwdFileName;

    @Transient
//	@OneToOne(cascade=ALL)
//	@JoinColumn(name="UserId")
	private User user;

	//@Transient
	public Map<String, Site> getSitesMap() {
		return siteMap;
	}


	// @TODO - Use Spring Singleton
	public static UserAppProfile getInstance() {

		if (UserAppProfile.instance == null) {
			instance = new UserAppProfile();
		}

		return instance;
	}

	public void setSiteMap(Map<String, Site> siteMap) {
		this.siteMap = siteMap;
	}

	public void addSite(Site site) throws Exception {

		// @TODO - Exception
		//if (site == null || user == null)
		if (site == null || this.getSiteList() == null)
			throw new Exception("Either Site or SiteList is Null");
		

//		if (siteMap != null) {
//			siteMap.put(String.valueOf(site.getSiteId()), site);
//		    
//		} else {
//			siteMap = new ConcurrentHashMap<String, Site>();
//			siteMap.put(String.valueOf(site.getSiteId()), site);
//		}
		
	    this.getSiteList().add(site);
	}

	public void addCategory(Category category) throws Exception {

		// @TODO - Exception
		if (category == null || user == null)
			throw new Exception("Either Category or AppUser is Null");

		if (categoryMap != null) {
			categoryMap.put(String.valueOf(category.getCatId()), category);
		} else {
			categoryMap = new ConcurrentHashMap<String, Category>();
			categoryMap.put(String.valueOf(category.getCatId()), category);
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Site> getSiteMap() {
		return siteMap;
	}

}
