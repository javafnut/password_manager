package com.ibexsys.pwd.entities;

import java.sql.Timestamp;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Category")
public class Category implements Serializable {

	private static final long serialVersionUID = -9036879502053475149L;
	public static final String ROOT_NAME = "ROOT";
	public static final Integer NO_ID = 10;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CatId")
	private Integer catId;
	
	@Column(name = "ParentId")
	private Integer parentId;
	
	@Column(name = "ChildId")
	private Integer childId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;

	@Column(name = "CreatedDTM")
	// @Temporal(TemporalType.TIMESTAMP)
	private Timestamp createdDTM;
	
	@Column(name = "ModifiedDTM")
	// @Temporal(TemporalType.TIMESTAMP)
	private Timestamp modifiedDTM;

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catID) {
		this.catId = catID;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
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
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((childId == null) ? 0 : childId.hashCode());
		result = prime * result + ((createdDTM == null) ? 0 : createdDTM.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
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
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (childId == null) {
			if (other.childId != null)
				return false;
		} else if (!childId.equals(other.childId))
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
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [catID=" + catId + ", parentId=" + parentId + ", childId=" + childId + ", name=" + name
				+ ", description=" + description + ", createdDTM=" + createdDTM + ", modifiedDTM=" + modifiedDTM + "]";
	}


	
}

