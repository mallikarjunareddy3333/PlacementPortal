package com.placement.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESUMES")
public class Resume {

	@Id
	@GeneratedValue
	@Column(name = "RESUME_ID")
	private Long id;

	@Lob
	@Column(name = "RESUME_FILE", nullable = false, columnDefinition = "mediumblob")
	private byte[] resumeFile;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	public Resume() {
		// TODO Auto-generated constructor stub
	}

	public Resume(byte[] resumeFile, Student student) {
		this.resumeFile = resumeFile;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getResumeFile() {
		return resumeFile;
	}

	public void setResumeFile(byte[] resumeFile) {
		this.resumeFile = resumeFile;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
