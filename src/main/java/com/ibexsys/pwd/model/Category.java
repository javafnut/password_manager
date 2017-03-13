package com.ibexsys.pwd.model;

import java.sql.Timestamp;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="Category")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9036879502053475149L;
	public static final int ROOT_ID = 100;
	public static final String ROOT_NAME = "ROOT";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="catID")
	private int catID;
    
	@Column()
	private int userID;
	private int parentID;
	private int childID;
	private String name;
	private String description;
	private Timestamp createdDTM;
	private Timestamp modifiedDTM;

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
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

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getChildID() {
		return childID;
	}

	public void setChildID(int childID) {
		this.childID = childID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

}
