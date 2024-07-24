package com.pk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pk.entity.Student;
import com.pk.response.ResponseModel;
import com.pk.service.IStudentMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student-api")
@Slf4j
public class StudentRestController {

	@Autowired
	private IStudentMgmtService stuService;

	@PostMapping("/save")
	public ResponseEntity<ResponseModel<Student>> saveStudent(@RequestBody Student student) {

		log.info("savestudent - Request received to save the student data");
		ResponseModel<Student> model = stuService.insertStudent(student);
		log.info("savestudent - Successfully  saved the student data");
		// return new ResponseEntity<>(HttpStatus.OK).ok(model);
		return new ResponseEntity<>(model, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponseModel<List<Student>>> fetchAllStudent() {
		log.info("fetchAllStudent - Request received to fetch all students");
		ResponseModel<List<Student>> model = stuService.getAllStudents();
		log.info("fetchAllStudent - Successfully fetched all students");

		return new ResponseEntity<>(model, HttpStatus.OK);

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<ResponseModel<Student>> searchStudentByid(@RequestParam String id) {
		log.info("searchStudentByid - Request received to search Student By Id");
		ResponseModel<Student> model = stuService.getStudentById(id);
		log.info("searchStudentByid - Successfully fetched the Student");
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<ResponseModel<Student>> modifyStudentDetails(@RequestBody Student student) {
		log.info("modifyStudentDetails - Request received to modify the Student data");
		ResponseModel<Student> updatedStudent = stuService.updateStudent(student);
		log.info("modifyStudentDetails - Successfully modified  the Student data");
		return new ResponseEntity<ResponseModel<Student>>(updatedStudent, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseModel<Student>> deleteStudentById(@RequestParam String id) {
		log.info("deleteStudentById - Request received to delete the Student");
		ResponseModel<Student> removedStudent = stuService.removeStudentById(id);
		log.info("deleteStudentById - Successfully  deleted the Student");
		return new ResponseEntity<>(removedStudent, HttpStatus.OK);
	}

}
