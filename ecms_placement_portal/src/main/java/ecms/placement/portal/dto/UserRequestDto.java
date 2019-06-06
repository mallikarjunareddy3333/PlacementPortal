package ecms.placement.portal.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ecms.placement.portal.validation.PasswordMatches;
import ecms.placement.portal.validation.ValidEmail;
import ecms.placement.portal.validation.ValidPassword;

@PasswordMatches
public class UserRequestDto {

	@NotNull
	@NotEmpty
	private String username;

	@NotNull
	@NotEmpty
	@ValidPassword
	private String password;

	@NotNull
	@NotEmpty
	private String passwordConfirm;

	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;

	@NotNull
	@NotEmpty
	private String phone;

	@NotNull
	@NotEmpty
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
