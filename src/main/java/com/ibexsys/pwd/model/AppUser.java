package com.ibexsys.pwd.model;

import java.sql.Timestamp;
import java.util.Arrays;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;


@Entity
@Table(name = "AppUser")
public class AppUser implements Serializable{

	private static final long serialVersionUID = -6528351877018119894L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "UserId")
	private Integer userId;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "UserSalt")
	private byte[] salt;
	
	@Column(name = "Password")
	private byte[] password;
	
	@Column(name = "CreatedDTM")
	private Timestamp createdDTM;
	
	@Column(name = "ModifiedDTM")
	private Timestamp modifiedDTM;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
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
		result = prime * result + ((createdDTM == null) ? 0 : createdDTM.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((modifiedDTM == null) ? 0 : modifiedDTM.hashCode());
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + Arrays.hashCode(salt);
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		AppUser other = (AppUser) obj;
		if (createdDTM == null) {
			if (other.createdDTM != null)
				return false;
		} else if (!createdDTM.equals(other.createdDTM))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (modifiedDTM == null) {
			if (other.modifiedDTM != null)
				return false;
		} else if (!modifiedDTM.equals(other.modifiedDTM))
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (!Arrays.equals(salt, other.salt))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppUser [userID=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salt=" + Arrays.toString(salt) + ", password=" + Arrays.toString(password) + ", createDTM="
				+ createdDTM + ", modifiedDTM=" + modifiedDTM + "]";
	}

}
