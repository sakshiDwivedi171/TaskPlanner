package com.paypal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.paypal.model.Users;
import com.paypal.service.UserService;

@RestController
@CrossOrigin(origins= "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping("/userRegister")
	public ResponseEntity<Users> createUser(@RequestBody Users users){
		return new ResponseEntity<Users>(userService.createUser(users), HttpStatus.CREATED);
	}
	
	
	

}
