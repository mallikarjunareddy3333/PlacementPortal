package ecms.placement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecms.placement.portal.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByRollNo(String rollNo);

	Student findByEmail(String email);

	void deleteByRollNo(String rollNo);

}
