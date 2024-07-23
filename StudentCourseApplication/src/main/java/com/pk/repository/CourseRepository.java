package com.pk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pk.entity.Course;

public interface CourseRepository extends MongoRepository<Course, String>{

}
