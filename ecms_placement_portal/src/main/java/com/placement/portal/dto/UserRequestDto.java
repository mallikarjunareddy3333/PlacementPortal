package com.placement.portal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.placement.portal.validation.PasswordMatches;
import com.placement.portal.validation.ValidEmail;
import com.placement.portal.validation.ValidPassword;

@PasswordMatches
public class UserRequestDto {

	@NotNull
	@NotEmpty
	@NotBlank(message = "userName field is mandatory")
	private String username;

	@NotNull
	@NotEmpty
	@ValidPassword
	@NotBlank(message = "password field is mandatory")
	private String password;

	@NotNull
	@NotEmpty
	@NotBlank(message = "PasswordConfirm field is mandatory")
	private String passwordConfirm;

	@NotBlank(message = "email is mandatory")
	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;

	@NotNull
	@NotEmpty
	@NotBlank(message = "phone is mandatory")
	private String phone;

	@NotNull
	@NotEmpty
	@NotBlank(message = "role_name is mandatory")
	private String role_name;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
