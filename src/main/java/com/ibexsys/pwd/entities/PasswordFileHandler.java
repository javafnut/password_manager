package com.ibexsys.pwd.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "PwdUserModel")
public class PasswordFileHandler {

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "UserSiteList")
	@XmlElement(name = "Site")

	private ArrayList<Site> siteList;
	private String pwdFileName;
	private User appUser;

	public ArrayList<Site> getSitesList() {
		return siteList;
	}

	public void setSiteList(ArrayList<Site> pSiteList) {
		siteList = pSiteList;
	}

	public String getPwdFileName() {
		return pwdFileName;
	}

	public void setPwdFileName(String pPwdFileName) {
		pwdFileName = pPwdFileName;
	}

	public User getAppUser() {
		return appUser;
	}

	public void setAppUser(User pAppUser) {
		appUser = pAppUser;
	}

	@Override
	public String toString() {
		return "PasswordFileHandler [siteList=" + siteList + ", pwdFileName=" + pwdFileName + ", appUser=" + appUser
				+ "]";
	}

}
