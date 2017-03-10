/*
 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibexsys.pwd.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * 
 *
 * @author jsc
 */


@XmlRootElement(name = "passwordFile")
public class PasswordFileHandler  {
    
      // XmLElementWrapper generates a wrapper element around XML representation
  @XmlElementWrapper(name = "siteList")
  @XmlElement(name = "site")

  private ArrayList<Site> siteList;
  private String pwdFileName;
  private AppUser appUser;


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

   public AppUser getAppUser() {
		return appUser;
	}

   public void setAppUser(AppUser pAppUser) {
		appUser = pAppUser;
	}

@Override
public String toString() {
	return "PasswordFileHandler [siteList=" + siteList + ", pwdFileName=" + pwdFileName + ", appUser=" + appUser + "]";
}



}
