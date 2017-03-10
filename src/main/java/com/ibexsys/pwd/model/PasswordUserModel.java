package com.ibexsys.pwd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "PwdUserModel")
public class PasswordUserModel {

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "UserSiteList")
	@XmlElement(name = "Site")

	private List<Site> siteList;
	private List<Category> categoryList;
	private String pwdFileName;
	private AppUser appUser;

	public List<Site> getSitesList() {
		return siteList;
	}

	public void setSiteList(List<Site> siteList2) {
		this.siteList = siteList2;
	}

	public void addSite(Site site) throws Exception {

		// @TODO - Exception
		if (site == null || appUser == null)
			throw new Exception("Either Site or AppUser is Null");

		if (siteList != null) {
			siteList.add(site);
		} else {
			siteList = new ArrayList<Site>();
			siteList.add(site);
		}
	}

	public void addCategory(Category category) throws Exception {

		// @TODO - Exception
		if (category == null || appUser == null)
			throw new Exception("Either Category or AppUser is Null");

		if (categoryList != null) {
			categoryList.add(category);
		} else {
			categoryList = new ArrayList<Category>();
			categoryList.add(category);
		}
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
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
