package com.paypal.service;

import com.paypal.exceptions.UserException;
import com.paypal.model.Users;

public interface UserService {
	
	public Users createUser(Users users) throws UserException;
	
	public Users getUserById(Long userId) throws UserException;
	
	public Users deleteUser(Long userId) throws UserException;
	
	

}
