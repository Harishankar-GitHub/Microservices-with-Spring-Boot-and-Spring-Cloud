package com.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter
{
	// We have to extend ZuulFilter class and add unimplemented methods
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter()
	{
		return true;
		// We are defining here whether this filter has to be executed.
		// true - Yes
		// false - No
	}

	@Override
	public Object run() throws ZuulException
	{
		// To get the current request :
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} Request URI -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType()
	{		
		return "pre";
		// When should the filtering happen ? 
		// "pre" - Before the request is executed
		// "post" - After the request is executed
		// "error" - When the request throws error/exception
	}

	@Override
	public int filterOrder()
	{
		return 1;
		// We are defining the order of this filter (Zuul Logging Filter) as 1.
		// We can define the order of the filters if we have many such filters.
	}
	
}
