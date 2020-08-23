package com.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource
{
	@Autowired
	private UserDAOService userDAOService;
	
	// http://localhost:8080/users
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return userDAOService.findAll();
	}
	
	// http://localhost:8080/users/1
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id)
	{
		User user = userDAOService.findOne(id);
		
		if (user == null)
		{
			throw new UserNotFoundException("id - " + id);
		}
		
		// Instead of returning the user, we are returning user along with the links to other users.
		// This is called as HATEOAS
		
		EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));		
		
		return resource;		
	}
	
	// http://localhost:8080/users/1
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id)
		{
			User user = userDAOService.deleteById(id);
			
			if (user == null)
			{
				throw new UserNotFoundException("id - " + id);
			}
		}
	
	// http://localhost:8080/users
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody @Valid User user)
	{
		User savedUser = userDAOService.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
