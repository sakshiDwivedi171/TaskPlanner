package com.paypal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.DTOs.LoginDTO;
import com.paypal.exceptions.UserException;
import com.paypal.model.Users;
import com.paypal.service.LoginService;



@RestController
@CrossOrigin(origins= "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Users> loginAccount(@RequestBody LoginDTO logindto) throws UserException{
		return new ResponseEntity<>(loginService.logIntoAccount(logindto), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/logOut/{key}")
	public ResponseEntity<String> logOutAccount(@PathVariable String key){
		return new ResponseEntity<>(loginService.logOutFromAccount(key), HttpStatus.OK);
	}
	

	
	
	
	
	
	
	
	
	
}
