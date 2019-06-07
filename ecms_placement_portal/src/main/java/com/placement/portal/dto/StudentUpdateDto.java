package com.placement.portal.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.placement.portal.model.AcademicInfo;
import com.placement.portal.model.Address;
import com.placement.portal.model.Student;

public class StudentUpdateDto {

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	private String middleName;

	@NotNull
	private String lastName;

	@NotNull
	@NotEmpty
	private String gender;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;

	@NotNull
	@NotEmpty
	private String branch;

	@NotNull
	@NotEmpty
	private String yearOfJoin;

	@NotNull
	@NotEmpty
	private String yearOfPass;

	private Address address;

	private AcademicInfo academicInfo;

	public StudentUpdateDto() {

	}

	public StudentUpdateDto(Student obj) {
		this.firstName = obj.getFirstName();
		this.middleName = obj.getMiddleName();
		this.lastName = obj.getLastName();
		this.gender = obj.getGender();
		this.dob = obj.getDob();
		this.branch = obj.getBranch();
		this.yearOfJoin = obj.getYearOfJoin();
		this.yearOfPass = obj.getYearOfPass();
		this.address = obj.getAddress();
		this.academicInfo = obj.getAcademicInfo();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYearOfJoin() {
		return yearOfJoin;
	}

	public void setYearOfJoin(String yearOfJoin) {
		this.yearOfJoin = yearOfJoin;
	}

	public String getYearOfPass() {
		return yearOfPass;
	}

	public void setYearOfPass(String yearOfPass) {
		this.yearOfPass = yearOfPass;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AcademicInfo getAcademicInfo() {
		return academicInfo;
	}

	public void setAcademicInfo(AcademicInfo academicInfo) {
		this.academicInfo = academicInfo;
	}

}
