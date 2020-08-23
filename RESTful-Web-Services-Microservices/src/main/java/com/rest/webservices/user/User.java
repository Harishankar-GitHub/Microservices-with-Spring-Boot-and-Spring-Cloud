package com.rest.webservices.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User details")
// The Api annotations are used to give some description in API Docs.
// http://localhost:8080/v2/api-docs

@Entity
public class User
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=5, message="Name should have at least 5 characters !")
	// Using default Java Validation API
	// Added the dependency in pom.xml
	// Length of name must be atleast 5
	// The message given in the annotation will be displayed if the validation fails
	@ApiModelProperty(notes="Name should have at least 5 characters !")
	private String name;
	
	@Past
	// Validating the birthDate field.
	// @Past is used to check if the date is in the past
	// Because, birth date must be in the past
	@ApiModelProperty(notes="Birth Date must be in the past")
	private LocalDateTime birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts = new ArrayList<>();
	
	// To see other available validation annotations,
	// Go to Maven dependencies -> jakarta.validation-api jar -> Constraints
	
	public User()
	{
		super();
		// Default constructor
	}
	
	public User(Integer id, String name, LocalDateTime birthDate)
	{
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}
}
