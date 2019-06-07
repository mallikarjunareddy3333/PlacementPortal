package com.placement.portal.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sid;

	@Column(unique = true, nullable = false)
	private String rollNo;

	@Column(nullable = false)
	private String firstName;

	private String middleName;
	private String lastName;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private String branch;

	@Column(nullable = false)
	private String yearOfJoin;

	@Column(nullable = false)
	private String yearOfPass;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="academicInfoId")
	private AcademicInfo academicInfo;

	public Student() {

	}

	public Student(String rollNo, String firstName, String middleName, String lastName, String gender, LocalDate dob,
			String email, String phone, String branch, String yearOfJoin, String yearOfPass, Address address,
			AcademicInfo academicInfo) {
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.branch = branch;
		this.yearOfJoin = yearOfJoin;
		this.yearOfPass = yearOfPass;
		this.address = address;
		this.academicInfo = academicInfo;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
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
