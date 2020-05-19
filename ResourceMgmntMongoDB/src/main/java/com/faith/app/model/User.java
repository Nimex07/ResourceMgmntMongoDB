package com.faith.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private Long id;
	private String userName, password;

	@DBRef
	private RoleDetails roleDetails;

	private Character isActive = 'Y';

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDetails getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(RoleDetails roleDetails) {
		this.roleDetails = roleDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", roleDetails=" + roleDetails
				+ ", isActive=" + isActive + "]";
	}

	
}
