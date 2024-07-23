package com.pk.service;

import java.util.List;

import com.pk.entity.Course;
import com.pk.response.ResponseModel;

public interface ICourseMgmtService {

	public ResponseModel<Course> insertCourse(Course course);

	public ResponseModel<List<Course>> fetchAllCourses();

	public ResponseModel<Course> fetchCourseById(String id);

	public ResponseModel<Course> removeCourseById(String id);

}
