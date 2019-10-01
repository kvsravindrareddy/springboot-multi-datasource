package com.ravindra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(InvalidRequestBodyException.class)
	public final ResponseEntity<ErrorDetails> invalidRequestHandler()
	{
		ErrorDetails error = new ErrorDetails("Invalid JSON Request","1001");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}