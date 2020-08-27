package com.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.microservices.currencyconversionservice")
// Using Feign REST Client for Service Invocation
@EnableDiscoveryClient
// Adding @EnableDiscoveryClient annotation to register Currency Conversion Service with Eureka Naming Server.
// Also, we need to configure the URL for Eureka Naming Server in application.properties of this service.
public class CurrencyConversionApplication {
	
	// NOTE : This file name was CurrencyConversionServiceApplication.
	// It was renamed because, it was throwing error while pushing to the GitHub.

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
	
	// The below is for Sleuth
	// We have to define below, what are the requests we need to intercept.	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;		// We are defining here to trace all requests.
	}

}
