package com.example.MvcWebApplication;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<Iterable<users>> getAllUsers() {
		 Iterable<users> allUsers = userRepository.findAll();
		 return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}	
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable Long userId) {
		Optional<users> u = userRepository.findById(userId);
		return new ResponseEntity<> (u, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody users users) {	
	 users = userRepository.save(users);

	 // Set the location header for the newly created resource
	 HttpHeaders responseHeaders = new HttpHeaders();
	 URI newUserUri = ServletUriComponentsBuilder
	 .fromCurrentRequest()
	 .path("/{id}")
	 .buildAndExpand(users.getId())
	 .toUri();
	 responseHeaders.setLocation(newUserUri);

	 return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}		
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
	 userRepository.deleteById(userId);
	 return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody users user, @PathVariable Long userId) {
		// Save the entity
		Optional<users>  ToUpdate = userRepository.findById(userId);
		users userToUpdate = ToUpdate.get();
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setUseraddress(user.getUseraddress());
		userToUpdate.setUseremail(user.getUseremail());
		userToUpdate.setUsername(user.getUsername());
		users c = userRepository.save(userToUpdate);		

		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	// Fallback method in caso di indirizzi errati
	@RequestMapping("*")
	public String fallbackMethod() {
		return "fallback";
	}	
	
}
