package com.rest.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	
	// URL for SWAGGER UI
	// 1. http://localhost:8080/swagger-ui/ or
	// 	http://localhost:8080/swagger-ui/index.html
	// 2. http://localhost:8080/v2/api-docs
	
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Harishankar Bhat R",
			"https://github.com/Harishankar-GitHub",
			"rhsb1997@gmail.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
    "Awesome Api Title",
    "Awesome Api Description",
    "1.0",
    "urn:tos",
    DEFAULT_CONTACT,
    "Apache 2.0",
    "http://www.apache.org/licenses/LICENSE-2.0",
    new ArrayList<>());
	
	// The above 2 constant variables are taken from ApiInfo class.
	// Ctrl+Click on ApiInfo class to copy the above 2 variables.

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
			new HashSet<>(Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
	
}
