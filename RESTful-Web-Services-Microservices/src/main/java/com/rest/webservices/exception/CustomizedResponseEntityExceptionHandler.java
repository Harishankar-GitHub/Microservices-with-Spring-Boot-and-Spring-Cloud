package com.rest.webservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{	// We are extending ResponseEntityExceptionHandler
	
	
	// http://localhost:8080/users/40
	@ExceptionHandler(Exception.class)
	// @ExceptionHandler(Exception.class) is used to define which type of exception to be handled.
	// We are using this to handle all exceptions. So putting Exception.class inside the annotation.
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// http://localhost:8080/users/40
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "Validation failed", ex.getBindingResult().toString());
		// ex.getBindingResult().toString() is used to give the error message which comes from the validations.
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
