package com.placement.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private Long addressId;
	
	@NotNull
	@NotEmpty
	private String doorNo;
	
	@NotNull
	@NotEmpty
	private String streetName;
	
	@NotNull
	@NotEmpty
	private String city;
	
	@NotNull
	@NotEmpty
	private String state;
	
	@NotNull
	@NotEmpty
	private String country;
	
	@NotNull
	@NotEmpty
	private String pincode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String doorNo, String streetName, String city, String state, String country, String pincode) {
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
