package com.cognizant.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.response.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(userNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(userNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	} 

}
