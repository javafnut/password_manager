package com.ibexsys.pwd.model;

import java.sql.Timestamp;

public class Category {

	public static final int ROOT_ID = 100;
	public static final String ROOT_NAME = "ROOT";

	private long catId;
	private long userId;
	private long parentId;
	private long childId;
	private String name;
	private String description;
	private Timestamp createDTM;
	private Timestamp modifiedDTM;

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getChildId() {
		return childId;
	}

	public void setChildId(long childId) {
		this.childId = childId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
