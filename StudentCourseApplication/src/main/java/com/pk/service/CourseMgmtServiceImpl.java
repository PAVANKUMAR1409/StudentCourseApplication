package com.pk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pk.entity.Course;
import com.pk.exception.StudentNotFoundException;
import com.pk.repository.CourseRepository;
import com.pk.response.ResponseModel;

@Service
public class CourseMgmtServiceImpl implements ICourseMgmtService {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public ResponseModel<Course> insertCourse(Course course) {
		ResponseModel<Course> model = new ResponseModel<>();
		try {
			Course save = courseRepo.save(course);
			model.setData(save);
			model.setMessage("Course Data is saved with id :: "+save.getCourseId());
			model.setStatus(HttpStatus.OK.toString());
			
			return model;
		}catch(Exception e) {
			model.setData(null);
			model.setMessage("Exception Occured in insertCourse()");
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return model;
		}
		
	}

	@Override
	public ResponseModel<List<Course>> fetchAllCourses() {
		ResponseModel<List<Course>> model = new ResponseModel<>();
		try {
			List<Course> all = courseRepo.findAll();
			
			model.setData(all);
			model.setMessage("All Courses Found");
			model.setStatus(HttpStatus.OK.toString());
			return model;
		}catch (Exception e) {
			model.setData(null);
			model.setMessage("Exception occured in fetchAllCourses()");
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return model;
		}
	}

	@Override
	public ResponseModel<Course> fetchCourseById(String id) {
		ResponseModel<Course> model = new ResponseModel<>();
		try {
			Course course=courseRepo.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Course Not Found with Id :: "+id));
			
			model.setData(course);
			model.setMessage("Course Found with id :: "+course.getCourseId());
			model.setStatus(HttpStatus.OK.toString());
			return model;
		}catch (StudentNotFoundException e) {
			model.setData(null);
			model.setMessage(e.getMessage());
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return model;

		}
		
	}

	@Override
	public ResponseModel<Course> removeCourseById(String id) {
		ResponseModel<Course> model = new ResponseModel<>();
		try {
			Course course=courseRepo.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Course Not Found with Id :: "+id));
			courseRepo.deleteById(id);
			model.setData(course);
			model.setMessage("Course Found and Deleted");
			model.setStatus(HttpStatus.OK.toString());
			return model;
		}catch (StudentNotFoundException e) {
			model.setData(null);
			model.setMessage(e.getMessage());
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return model;

		}
	}
	
	
	

}
