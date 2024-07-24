package com.pk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.pk.response.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class StudentHandlingException {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseModel<String>> handleStudentNotFoundException(StudentNotFoundException ex,
			WebRequest request) {
		log.error("StudentNotFoundException: ", ex);
		ResponseModel<String> responseModel = new ResponseModel<>();
		responseModel.setMessage(ex.getMessage());
		responseModel.setStatus(HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseModel<String>> handleGlobalException(Exception ex, WebRequest request) {
		log.error("Exception: ", ex);
		ResponseModel<String> responseModel = new ResponseModel<>();
		responseModel.setMessage("An unexpected error occurred");
		responseModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseModel<String>> handleNullPointerException(NullPointerException ex){
		
		log.error("NullPointerException: ", ex);
		ResponseModel<String> responseModel = new ResponseModel<>();
		responseModel.setMessage("Null Pointer Exception Occured");
		responseModel.setStatus(HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
		
	}
}
