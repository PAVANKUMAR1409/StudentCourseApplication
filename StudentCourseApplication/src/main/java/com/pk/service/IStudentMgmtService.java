package com.pk.service;

import java.util.List;

import com.pk.entity.Student;
import com.pk.response.ResponseModel;

public interface IStudentMgmtService {

	public ResponseModel<Student> insertStudent(Student student);

	public ResponseModel<List<Student>> getAllStudents();

	public ResponseModel<Student> getStudentById(String id);

	

	public ResponseModel<Student> removeStudentById(String id);

	public ResponseModel<Student> mapStudentWithCourses(String sid, List<String> cids);

	public ResponseModel<Student> updateStudent(String studentId, String mailId, Long phoneNo);
}
