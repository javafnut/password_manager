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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="catID")
	private Integer catID;
    
	@Column()
	private Integer userID;
	private Integer parentID;
	private Integer childID;
	private String name;
	private String description;
	private Timestamp createdDTM;
	private Timestamp modifiedDTM;

	public Integer getCatID() {
		return catID;
	}

	public void setCatID(Integer catID) {
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

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Integer getChildID() {
		return childID;
	}

	public void setChildID(Integer childID) {
		this.childID = childID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catID;
		result = prime * result + ((childID == null) ? 0 : childID.hashCode());
		result = prime * result + ((createdDTM == null) ? 0 : createdDTM.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentID == null) ? 0 : parentID.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		Category other = (Category) obj;
		if (catID != other.catID)
			return false;
		if (childID == null) {
			if (other.childID != null)
				return false;
		} else if (!childID.equals(other.childID))
			return false;
		if (createdDTM == null) {
			if (other.createdDTM != null)
				return false;
		} else if (!createdDTM.equals(other.createdDTM))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (modifiedDTM == null) {
			if (other.modifiedDTM != null)
				return false;
		} else if (!modifiedDTM.equals(other.modifiedDTM))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentID == null) {
			if (other.parentID != null)
				return false;
		} else if (!parentID.equals(other.parentID))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [catID=" + catID + ", userID=" + userID + ", parentID=" + parentID + ", childID=" + childID
				+ ", name=" + name + ", description=" + description + ", createdDTM=" + createdDTM + ", modifiedDTM="
				+ modifiedDTM + "]";
	}

}
