package com.ibexsys.pwd.model;

import java.sql.Timestamp;

public class Category {

	public static final int ROOT_ID = 100;
	public static final String ROOT_NAME = "ROOT";

	private long catID;
	private long userID;
	private long parentID;
	private long childID;
	private String name;
	private String description;
	private Timestamp createDTM;
	private Timestamp modifiedDTM;

	public long getCatID() {
		return catID;
	}

	public void setCatID(long catID) {
		this.catID = catID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	public long getChildID() {
		return childID;
	}

	public void setChildID(long childID) {
		this.childID = childID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
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

}
