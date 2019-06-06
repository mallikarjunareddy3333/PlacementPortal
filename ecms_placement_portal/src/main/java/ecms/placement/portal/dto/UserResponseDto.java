package ecms.placement.portal.dto;

import java.time.LocalDate;
import java.util.Set;

import ecms.placement.portal.model.Role;
import ecms.placement.portal.model.User;

public class UserResponseDto {

	private Long id;

	private String username;

	private String email;

	private String phone;

	private LocalDate registered_date;

	private Set<Role> roles;

	public UserResponseDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.registered_date = user.getRegister_date();
		this.roles = user.getRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public LocalDate getRegistered_date() {
		return registered_date;
	}

	public void setRegistered_date(LocalDate registered_date) {
		this.registered_date = registered_date;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
