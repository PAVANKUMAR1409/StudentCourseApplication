package com.pk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pk.entity.Student;
import com.pk.exception.StudentNotFoundException;
import com.pk.repository.StudentRepository;
import com.pk.response.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public ResponseModel<Student> insertStudent(Student student) {
		ResponseModel<Student> model = new ResponseModel<Student>();

		if (student == null) {
			model.setStatus(HttpStatus.BAD_REQUEST.toString());
			model.setMessage("Student object is null");
			return model;
		}
		Student save = studentRepo.save(student);
		model.setData(save);
		model.setMessage("Student Data saved with id " + save.getStudentId());
		model.setStatus(HttpStatus.CREATED.toString());

		return model;
	}
	/*@Override
	public ResponseModel<Student> insertStudent(Student student) {
		ResponseModel<Student> model = new ResponseModel<Student>();
		try {
			Student save = studentRepo.save(student);
			model.setData(save);
			model.setMessage("Student Data saved with id " + save.getStudentId());
			model.setStatus(HttpStatus.CREATED.toString());
			return model;
		} catch (Exception e) {
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			model.setMessage("Exception occurred in InsertStudent()");
			model.setData(null);
			return model;
		}
	
	}*/

	@Override
	public ResponseModel<List<Student>> getAllStudents() {
		ResponseModel<List<Student>> model = new ResponseModel<List<Student>>();

		List<Student> allStudents = studentRepo.findAll();

		if (allStudents != null) {
			model.setData(allStudents);
			model.setMessage("All the Students present in Student Collection");
			model.setStatus(HttpStatus.OK.toString());
		} else {
			model.setStatus(HttpStatus.NO_CONTENT.toString());
			model.setMessage("No Students found in Student Collection");
			model.setData(null);
		}

		return model;
	}
	/*@Override
	public ResponseModel<List<Student>> getAllStudents() {
		ResponseModel<List<Student>> model = new ResponseModel<List<Student>>();
		try {
			List<Student> allStudents = studentRepo.findAll();
	
			model.setData(allStudents);
			model.setMessage("All the Students present in Student Collection");
			model.setStatus(HttpStatus.OK.toString());
		} catch (Exception e) {
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			model.setMessage("Exception Occured in GetAllStudents()");
			model.setData(null);
	
		}
		return model;
	}*/

	@Override
	public ResponseModel<Student> getStudentById(String id) {
		ResponseModel<Student> model = new ResponseModel<Student>();

		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found with Id :: " + id));

		model.setData(student);
		model.setMessage("Student Found with id :: " + student.getStudentId());
		model.setStatus(HttpStatus.OK.toString());

		return model;
	}

	/*@Override
	public ResponseModel<Student> getStudentById(String id) {
		ResponseModel<Student> model = new ResponseModel<Student>();
		try {
			Student student = studentRepo.findById(id)
					.orElseThrow(() -> new StudentNotFoundException("Student Not Found with Id :: " + id));
	
			model.setData(student);
			model.setMessage("Student Found  with id :: " + student.getStudentId());
			model.setStatus(HttpStatus.OK.toString());
		} catch (StudentNotFoundException e) {
			model.setData(null);
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			model.setMessage(e.getMessage());
		}
	
		return model;
	}*/

	@Override
	public ResponseModel<Student> updateStudent(Student student) {

		ResponseModel<Student> model = new ResponseModel<Student>();

		Optional<Student> studentById = studentRepo.findById(student.getStudentId());
		if (studentById.isPresent()) {
			studentRepo.save(student);
		} else {
			throw new StudentNotFoundException("Student Not Found with id :: " + student.getStudentId());
		}
		model.setData(studentById.get());
		model.setMessage("Student Data Modified for Id :: " + student.getStudentId());
		model.setStatus(HttpStatus.OK.toString());

		return model;
	}

	/*@Override
	public ResponseModel<Student> updateStudent(Student student) {
	
		ResponseModel<Student> model = new ResponseModel<Student>();
		try {
			Student getStudent = studentRepo.findById(student.getStudentId()).orElseThrow(
					() -> new StudentNotFoundException("Student Not Found with Id :: " + student.getStudentId()));
	
			model.setData(getStudent);
			model.setMessage("Student Data Modified for Id :: " + getStudent.getStudentId());
			model.setStatus(HttpStatus.OK.toString());
	
		} catch (StudentNotFoundException e) {
			model.setData(student);
			model.setMessage("Student Object not modified");
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return model;
	
	}*/

	@Override
	public ResponseModel<Student> removeStudentById(String id) {
		ResponseModel<Student> model = new ResponseModel<Student>();

		Student removed = studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found with Id :: " + id));
		studentRepo.deleteById(removed.getStudentId());
		model.setData(removed);
		model.setMessage("Student Deleted with Id :: " + id);
		model.setStatus(HttpStatus.OK.toString());

		return model;
	}

	/*@Override
	public ResponseModel<Student> removeStudentById(String id) {
		ResponseModel<Student> model = new ResponseModel<Student>();
		try {
			Student removed = studentRepo.findById(id)
								.orElseThrow(()-> new StudentNotFoundException("Student Not Found with Id :: "+id));
			studentRepo.deleteById(removed.getStudentId());
			model.setData(removed);
			model.setMessage("Student Deleted with Id :: "+id);
			model.setStatus(HttpStatus.OK.toString());
		}catch (StudentNotFoundException e) {
			model.setData(null);
			model.setMessage(e.getMessage());
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return model;
	}*/

}
