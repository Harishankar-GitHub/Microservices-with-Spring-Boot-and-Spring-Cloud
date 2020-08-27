package com.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
// The value of name in the above annotation has to be the application name that is given in the application.properties file of the service
// which we are calling.

// We need not hard code the URL in the above annotation. We need to distribute the load between multiple instances.
// So, commenting the above @FeignClient annotation as we are using Ribbon.
//@FeignClient(name="currency-exchange-service")
//@RibbonClient(name="currency-exchange-service")
// Commenting the above 2 lines because, we have to call currency-exchange-service through Zuul Api Gateway.
// That is implemented below.

@FeignClient(name="netflix-zuul-api-gateway-server")
// Explanation for above line : We are calling Netflix Zuul Api Gateway Server and then searching for the instances of
// currency-exchange-service.
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	// Commenting the above line as we are using Netflix Zuul Api Gateway Server to call currency-exchange-service.
	// The URL to call through Netflix Zuul Api Gateway Server is : 
	// http://localhost:8765/currency-exchange-service/currency-exchange/from/AUD/to/INR
	// Syntax : http://localhost:8765/{application_name}/{uri}
	// So appending application name in the below line.
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
//	If the above line not working, we can use : @PathVariable("from") String from, @PathVariable("to") String to
	
//	NOTE :		In this Interface, we are calling a URL which is present in Currency Exchange Service.
//					If we need to call any other URL/URLs from same service, we can give the method declaration for of the URL/URLs
//					in this same Interface.
}
