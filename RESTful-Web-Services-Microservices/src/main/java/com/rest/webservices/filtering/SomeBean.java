package com.rest.webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// The @JsonIgnore and @JsonIgnoreProperties annotations are known as STATIC FILTERING.
// If a field is marked with any of the above annotations, that field is not sent in response.
// For example, if we want to exclude field1 in a scenario and field2 in another scenario,
// we need to implement DYNAMIC FILTERING.
// It is implemented in FilteringController class.
// So, commenting the @JsonIgnore and @JsonIgnoreProperties annotations in this class.

//@JsonIgnoreProperties(value= {"field2", "field3"})
// Instead of giving @JsonIgnore annotation in each fields, we can use the above syntax

@JsonFilter("SomeFilter")
public class SomeBean
{
	private String field1;
	private String field2;
	
//	@JsonIgnore
	// Above annotation is used to ignore a field in response
	// Basically, the field which is marked @JsonIgnore will not be serialized.
	// That is the reason for not getting this field in response.
	private String field3;
	
	public SomeBean(String field1, String field2, String field3)
	{
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}	
}
