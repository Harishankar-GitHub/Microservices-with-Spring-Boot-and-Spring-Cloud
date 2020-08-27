package com.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServer {
	
	// NOTE : This file name was SpringCloudConfigServerApplication.
	// It was renamed because, it was throwing error while pushing to the GitHub.

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServer.class, args);
	}

}
