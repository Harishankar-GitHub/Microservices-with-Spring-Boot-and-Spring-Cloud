package com.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy
// We are enabling Zuul Proxy here because, this is the Zuul Server.
@EnableDiscoveryClient
//Adding @EnableDiscoveryClient annotation to register Netflix Zuul Api Gateway Server with Eureka Naming Server.
//Also, we need to configure the URL for Eureka Naming Server in application.properties of this service.
@SpringBootApplication
public class NetflixZuulApiGateway {
	
	// NOTE : This file name was NetflixZuulApiGatewayServerApplication.
	// It was renamed because, it was throwing error while pushing to the GitHub.

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGateway.class, args);
	}
	
	// The below is for Sleuth
	// We have to define below, what are the requests we need to intercept.	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;		// We are defining here to trace all requests.
	}
	

}
