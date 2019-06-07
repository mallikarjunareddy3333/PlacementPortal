package com.placement.portal.rest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.portal.dto.ApiResponse;
import com.placement.portal.dto.StudentReqDto;
import com.placement.portal.dto.StudentUpdateDto;
import com.placement.portal.model.Student;
import com.placement.portal.service.StudentService;

@RestController
@RequestMapping("/profile")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ApiResponse<Object> insertProfile(HttpServletRequest request, @Valid @RequestBody StudentReqDto stud)
			throws Exception {

		String username = (String) request.getHeader("loggedInUsername");

		Student obj = new Student(stud.getRollNo(), stud.getFirstName(), stud.getMiddleName(), stud.getLastName(),
				stud.getGender(), stud.getDob(), stud.getEmail(), stud.getPhone(), stud.getBranch(),
				stud.getYearOfJoin(), stud.getYearOfPass(), stud.getAddress(), stud.getAcademicInfo());

		if (!username.equals(stud.getRollNo())) {
			throw new Exception("Not a valid user to do action..");
		} else {
			studentService.save(obj);
		}

		return new ApiResponse<>(HttpStatus.CREATED.value(), "User registered successfully", obj);
	}

	@GetMapping("/{id}")
	public ApiResponse<Student> getProfileById(@PathVariable Long id) {
		Optional<Student> op = studentService.findStudentById(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "select student profile successful", op.get());
	}

	@PutMapping("/{id}")
	public ApiResponse<Student> updateProfile(HttpServletRequest request, @PathVariable Long id,
			@Valid @RequestBody StudentUpdateDto stud) {

		Optional<Student> op = studentService.findStudentById(id);
		Student obj = null;

		String username = (String) request.getHeader("loggedInUsername");
		try {
			if (op.isPresent()) {
				obj = op.get();
				if (!username.equals(obj.getRollNo())) {
					throw new Exception("Not a valid user to do action..");
				}
				obj.setFirstName(stud.getFirstName());
				obj.setMiddleName(stud.getMiddleName());
				obj.setLastName(stud.getLastName());
				obj.setGender(stud.getGender());
				obj.setDob(stud.getDob());
				obj.setBranch(stud.getBranch());
				obj.setYearOfJoin(stud.getYearOfJoin());
				obj.setYearOfPass(stud.getYearOfPass());

				obj.setAddress(stud.getAddress());
				obj.setAcademicInfo(stud.getAcademicInfo());

				studentService.save(obj);
			} else {
				throw new Exception("Not a valid user to do action..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully", obj);
	}
}
