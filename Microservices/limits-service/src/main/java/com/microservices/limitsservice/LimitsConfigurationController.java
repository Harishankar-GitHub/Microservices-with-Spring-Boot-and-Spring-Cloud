package com.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController
{
	@Autowired
	private Configuration configuration;
	
	// http://localhost:8080/limits
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations()
	{
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
	
	// Demonstrating Fault Tolerance with Hystrix below
	
	// http://localhost:8080/fault-tolerance-example
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration()
	{
		throw new RuntimeException("Demonstrating Fault Tolerance with Hystrix");
	}
	
	// We are making the above method to fail/throw exception.
	// When above method fails, the below method is executed.
	// This is Fault Tolerance.
	
	public LimitConfiguration fallbackRetrieveConfiguration()	// Method name must be the one that is given in @HystrixCommand annotation.
	{
		return new LimitConfiguration(9999, 9);
	}
	
	
}
