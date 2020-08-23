package com.rest.webservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource
{	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// http://localhost:8080/jpa/users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers()
	{
		return userRepository.findAll();
	}
	
	// http://localhost:8080/jpa/users/1
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id)
	{
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent())
		{
			throw new UserNotFoundException("id - " + id);
		}
		
		// Instead of returning the user, we are returning user along with the links to other users.
		// This is called as HATEOAS
		
		EntityModel<User> resource = EntityModel.of(user.get());
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));		
		
		return resource;		
	}
	
	// http://localhost:8080/jpa/users/1
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
	}
	
	// http://localhost:8080/jpa/users
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@RequestBody @Valid User user)
	{
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	// http://localhost:8080/jpa/users/10001/posts
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id)
	{
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent())
		{
			throw new UserNotFoundException("id - " + id);
		}
		
		return userOptional.get().getPosts();
	}
	
	// http://localhost:8080/jpa/users/10001/posts
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post)
	{
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent())
		{
			throw new UserNotFoundException("id - " + id);
		}
		
		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
