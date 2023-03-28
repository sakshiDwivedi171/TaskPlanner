package com.paypal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.exceptions.TaskException;
import com.paypal.exceptions.UserException;
import com.paypal.model.Task;
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
		Optional<Users> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
        	throw null;
        }
        Users user = userOptional.get();
        return user;
		
	}

	@Override
	public String deleteUser(Long userId) throws UserException {
		
		return null;
	}

}
