package com.cts.training.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bean.User;
import com.cts.training.exception.UserNotFoundException;
import com.cts.training.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
	Optional<User> user=userRepository.findById(id);
	if(!user.isPresent()) 
		throw new UserNotFoundException("The user with Id - :"+id+"does not exists");
	   return user;
	
	}
	
	
	@GetMapping("/users/address/{address}")
	public List<User> getUserById(@PathVariable String address) {
	return userRepository.findByAddress(address);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) 
			throw new UserNotFoundException("The user with Id - :"+id+"does not exists");
		userRepository.deleteById(id);
		
	}
	
	@PostMapping("/users")
	public User insertUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@Valid @RequestBody User user,@PathVariable Long id) {
		Optional<User> updatedUser=userRepository.findById(id);
		if(!updatedUser.isPresent()) 
			throw new UserNotFoundException("The user with Id - :"+id+"does not exists");
		userRepository.save(user);
		return new ResponseEntity<>("Data Updated Successfully",HttpStatus.OK);
	}

}
