package com.rest.webservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post
{
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	// When we try to get a user or posts of a user, the posts of that user will be fetched.
	// In Post class, we have User also.
	// So, it will again print User and User will again print Post and so on.
	// It leads to infinite loop.
	// If we use @JsonIgnore here, this issue is fixed.
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// In toString() method, we did not select User because, User will try print Post and Post will again try to print User and so on.
	// It will lead to infinite loop scenario or out of memory scenario etc.
	@Override
	public String toString() {
		return String.format("Post [id=%s, description=%s]", id, description);
	}
	
}
