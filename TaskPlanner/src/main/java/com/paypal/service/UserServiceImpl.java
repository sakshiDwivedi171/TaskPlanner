package com.paypal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.exceptions.UserException;
import com.paypal.model.Users;
import com.paypal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Users createUser(Users users) throws UserException {
		
		return userRepository.save(users);
	}

	@Override
	public Users getUserById(Long userId) throws UserException {
		
		return null;
	}

	@Override
	public Users deleteUser(Long userId) throws UserException {
		
		return null;
	}

}
