package com.ibexsys.pwd.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "PwdUserModel")
public class PasswordUserModel {

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "UserSiteList")
	@XmlElement(name = "Site")

	private List<Site> siteList;
	private Map<String,Site> siteMap;
	private Map<String, Category> categoryMap;
	private String pwdFileName;
	private AppUser appUser;

//	public List<Site> getSitesList() {
//		return siteList;
//	}
//
//	public void setSiteList(List<Site> siteList2) {
//		this.siteList = siteList2;
//	}
//
//	public void addSite(Site site) throws Exception {
//
//		// @TODO - Exception
//		if (site == null || appUser == null)
//			throw new Exception("Either Site or AppUser is Null");
//
//		if (siteList != null) {
//			siteList.add(site);
//		} else {
//			siteList = new ArrayList<Site>();
//			siteList.add(site);
//		}
//	}
//	
	public Map<String,Site> getSitesMap() {
		return siteMap;
	}

	public void setSiteMap(Map<String,Site> siteMap) {
		this.siteMap = siteMap;
	}

	public void addSite(Site site) throws Exception {

		// @TODO - Exception
		if (site == null || appUser == null)
			throw new Exception("Either Site or AppUser is Null");

		if (siteMap != null) {
			siteMap.put(String.valueOf(site.getSiteId()),site);
		} else {
			siteMap = new ConcurrentHashMap<String,Site>();
			siteMap.put(String.valueOf(site.getSiteId()),site);
		}
	}
	
	public void addCategory(Category category) throws Exception {

		// @TODO - Exception
		if (category == null || appUser == null)
			throw new Exception("Either Category or AppUser is Null");


		
		if (categoryMap != null) {
			categoryMap.put(String.valueOf(category.getCatID()) , category);
		} else {
			categoryMap = new ConcurrentHashMap<String,Category>();
			categoryMap.put(String.valueOf(category.getCatID()),category);
		}
	}

	public Map<String,Category> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String,Category> categoryMap) {
		this.categoryMap = categoryMap;
	}


	public String getPwdFileName() {
		return pwdFileName;
	}

	public void setPwdFileName(String pPwdFileName) {
		pwdFileName = pPwdFileName;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser pAppUser) {
		appUser = pAppUser;
	}

	@Override
	public String toString() {
		return "PasswordFileHandler [siteList=" + siteList + ", pwdFileName=" + pwdFileName + ", appUser=" + appUser
				+ "]";
	}

}
