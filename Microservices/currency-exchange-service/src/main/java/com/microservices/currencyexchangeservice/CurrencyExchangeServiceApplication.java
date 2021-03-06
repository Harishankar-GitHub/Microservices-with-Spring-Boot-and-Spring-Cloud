package com.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
//Adding @EnableDiscoveryClient annotation to register Currency Exchange Service with Eureka Naming Server.
//Also, we need to configure the URL for Eureka Naming Server in application.properties of this service.
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	// The below is for Sleuth
	// We have to define below, what are the requests we need to intercept.	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;		// We are defining here to trace all requests.
	}

}
