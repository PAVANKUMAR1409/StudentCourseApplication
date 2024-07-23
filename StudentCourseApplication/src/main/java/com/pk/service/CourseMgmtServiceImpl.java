package com.pk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.entity.Course;
import com.pk.repository.CourseRepository;

@Service
public class CourseMgmtServiceImpl implements ICourseMgmtService {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String insertCourse(Course course) {
		Course save = courseRepo.save(course);
		return "Course is saved with id value :: "+save.getCourseId();
	}

	@Override
	public List<Course> fetchAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public Course fetchCourseById(String id) {
		Optional<Course> byId = courseRepo.findById(id);
		if(byId.isPresent())
			return byId.get();
		else
			return null;
	}

	@Override
	public String removeCourseById(String id) {
		Optional<Course> byId = courseRepo.findById(id);
		if(byId.isPresent())
		{
			courseRepo.deleteById(id);
			return "Course Deleted By Id :: "+id;
		}
		return "";
	}
	
	
	

}
