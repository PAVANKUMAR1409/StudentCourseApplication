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
@Document(collection = "Student")
public class Student {
	
	@Id
	private String studentId;

	@NonNull
	private String fname;
	@NonNull
	private String lname;
	@NonNull
	private String mailId;
	@NonNull
	private Long phoneNo;
	
	@NonNull
	private List<String> courseIds;
	

}
