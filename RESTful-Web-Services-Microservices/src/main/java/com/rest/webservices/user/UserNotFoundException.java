package com.rest.webservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{

	public UserNotFoundException(String message)
	{
		// This constructor is generated using Source -> Generate Constructor from Superclass option
		super(message);
		
	}
	
}