package com.placement.portal.model;

import java.util.Set;

public class AuthToken {

	private String token;

	private String username;

	private String[] roles;

	public AuthToken() {

	}

	public AuthToken(String token, String username, String[] roles) {
		this.token = token;
		this.username = username;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String[] getRoles() {
		return roles;
	}
	
	 public void setRoles(String[] roles) {
		this.roles = roles;
	}

}
