package ecms.placement.portal.service;

import java.util.List;
import java.util.Optional;

import ecms.placement.portal.model.Student;

public interface StudentService {

	void save(Student student);
	
	Optional<Student> findStudentById(Long id);

	Student findStudentByRollNo(String rollNo);

	List<Student> findAll();

	void deleteByRollNo(String rollNo);

	void update(Student student);

}
