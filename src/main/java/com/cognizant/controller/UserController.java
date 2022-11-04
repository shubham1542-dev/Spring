package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.User;
import com.cognizant.response.CommonResponse;
import com.cognizant.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createUser(user));
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(this.service.getUserById(id));
	}
	
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.status(HttpStatus.OK).body(this.service.getAllUser());
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
		return ResponseEntity.status(HttpStatus.OK).body(this.service.updateUserById(id, user));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<CommonResponse> deleteUserById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteUser(id));
	} 
}
