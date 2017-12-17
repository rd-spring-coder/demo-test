package org.rd.rws.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.rd.rws.rest.controller.exception.UserNotFoundException;
import org.rd.rws.rest.model.User;
import org.rd.rws.rest.model.UserDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserRestController {

	private UserDaoService userDaoService;
	public UserRestController(UserDaoService userDaoService){
		this.userDaoService = userDaoService;
	}
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveOne(@PathVariable int id){	
		User user = userDaoService.findOne(id);
		if(user == null ){
			throw new UserNotFoundException("id - "+id +" not found");
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = userDaoService.deleteById(id);
		
		if(user == null){
			throw new UserNotFoundException("id - "+ id + " not found");
		}
	}
}
