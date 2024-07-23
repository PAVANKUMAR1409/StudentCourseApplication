package com.pk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pk.entity.Course;
import com.pk.service.ICourseMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/course-api")
@Slf4j
public class CourseRestController {
	
	@Autowired
	private ICourseMgmtService courseService;

	@PostMapping("/save")
	public ResponseEntity<String> saveCourse(@RequestBody Course course){
		log.info("CourseRestController.saveCourse() :: Started");
		String msg=courseService.insertCourse(course);
		log.info("CourseRestController.saveCourse() :: Ended");
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Course>> getAllCourses(){
		log.info("CourseRestController.getAllCourses() :: Started");
		List<Course> listCourses=courseService.fetchAllCourses();
		log.info("CourseRestController.getAllCourses() :: Ended");
		return new ResponseEntity<List<Course>>(listCourses,HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Course> getCourseById(@RequestParam String id){
		log.info("CourseRestController.getCoursesById() :: Started");
		Course course=courseService.fetchCourseById(id);
		log.info("CourseRestController.getCoursesById() :: Ended");
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourseById(@RequestParam String id){
		log.info("CourseRestController.deleteCourseById() :: Started");
		String msg= courseService.removeCourseById(id);
		log.info("CourseRestController.deleteById() :: Ended");
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	
	
	
}
