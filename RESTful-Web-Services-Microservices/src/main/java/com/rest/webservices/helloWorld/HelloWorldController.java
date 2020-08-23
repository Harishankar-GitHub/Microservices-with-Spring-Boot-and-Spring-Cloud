package com.rest.webservices.helloWorld;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
	
	@Autowired
	private MessageSource messageSource;
	
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	// http://localhost:8080/hello-world
	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello World !";
	}
	
	//http://localhost:8080/hello-world-bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World from bean !");
	}
	
	// http://localhost:8080/hello-world/path-variable/Harish
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello %s !", name));
	}
	
	// http://localhost:8080/hello-world-internationalized
//	 @GetMapping("/hello-world-internationalized") // Commenting this line because, we have used same end point in below method.
//	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale)
//	{	// @RequestHeader is used to take the values that comes in the header.
//		// (name="Accept-Language") - The name of the value in header is Accept-Language.
//		// required = false - It is not mandatory to keep headers.
//		// If header is not present, we will take the default Locale.
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}
	
	// The above method accepts a Locale. But in every method, we cannot accept a Locale.
	// Spring provides an alternative. That is implemented below.
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized_easy_usage()
	{
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
