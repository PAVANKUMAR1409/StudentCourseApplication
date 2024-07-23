package com.pk.service;

import java.util.List;

import com.pk.entity.Course;

public interface ICourseMgmtService {

	public String insertCourse(Course course);

	public List<Course> fetchAllCourses();

	public Course fetchCourseById(String id);

	public String removeCourseById(String id);

}
