package com.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
// We can map the properties defined in application.properties file to this class's variables using the above annotation.
// The properties which has the prefix "limits-service" will be mapped here.
// For example : limits-service.minimum=99 will be mapped here.
// For the above property we have to create a variable with the name "minimum".
public class Configuration
{
	private int minimum;
	private int maximum;
	
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
}
