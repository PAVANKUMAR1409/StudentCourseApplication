package com.pk.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Course")
public class Course {

	@Id
	private String courseId;

	@NonNull
	private String courseName;
	@NonNull
	
	private String courseFaculty;
	@NonNull
	private Integer courseDuration;
	
	@NonNull
	private Double courseFee;
	
	
	@NonNull
	private List<String> studentIds;

}
