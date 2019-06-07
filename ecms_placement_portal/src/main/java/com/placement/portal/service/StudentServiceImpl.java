package com.placement.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.portal.model.Student;
import com.placement.portal.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void save(Student student) {
		studentRepo.save(student);
	}

	@Override
	public Student findStudentByRollNo(String rollNo) {
		return studentRepo.findByRollNo(rollNo);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public void update(Student student) {
		studentRepo.save(student);
	}

	@Override
	public void deleteByRollNo(String rollNo) {
		studentRepo.deleteByRollNo(rollNo);
	}

	@Override
	public Optional<Student> findStudentById(Long id) {
		return studentRepo.findById(id);
	}

}
