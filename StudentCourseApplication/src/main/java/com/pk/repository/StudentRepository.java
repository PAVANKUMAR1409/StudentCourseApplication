package com.pk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pk.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {


}
