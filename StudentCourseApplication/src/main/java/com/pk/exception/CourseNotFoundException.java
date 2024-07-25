package com.pk.exception;

@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException{
	
	public CourseNotFoundException(String msg) {
		super(msg);
	}

}
