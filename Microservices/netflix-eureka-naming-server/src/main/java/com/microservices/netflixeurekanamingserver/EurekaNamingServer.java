package com.microservices.netflixeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingServer {
	
	// NOTE : This file name was NetflixEurekaNamingServerApplication.
	// It was renamed because, it was throwing error while pushing to the GitHub.

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingServer.class, args);
	}
	
	// The below is for Sleuth
	// We have to define below, what are the requests we need to intercept.	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;		// We are defining here to trace all requests.
	}

}
