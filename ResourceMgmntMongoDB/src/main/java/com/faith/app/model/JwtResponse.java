package com.faith.app.model;

public class JwtResponse {

	private final String jwttoken;
	private String userName;
	private Long roleId;

	public JwtResponse(String jwttoken, String userName, Long roleId) {

		this.jwttoken = jwttoken;
		this.userName = userName;
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
