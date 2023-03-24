package com.paypal.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.DTOs.LoginDTO;
import com.paypal.model.CurrentUserSession;
import com.paypal.model.Users;
import com.paypal.repository.UserRepository;
import com.paypal.repository.UserSessionRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSessionRepository uSessionRepository;
	
	

	@Override
	public String logIntoAccount(LoginDTO logindto) {
		
		Optional<Users> loginUser= userRepository.findByUserEmail(logindto.getEmailId()) ;
		
		if(loginUser.isPresent()) {
			if(loginUser.get().getPassword().equals(logindto.getPassword())) {
				
				CurrentUserSession uSession= new CurrentUserSession();
				
				uSession.setSessionId(loginUser.get().getUserId());
				
				uSession.setUuid(UUID.randomUUID().toString());
				
				uSessionRepository.save(uSession);
				
				return "Login Successful";
				
			}else {
				return "Invalid Password";
			}
		}else {
			return "User not Available";
		}
		
		
	}

	@Override
	public String logOutFromAccount(String key) {	
		
		CurrentUserSession session= uSessionRepository.findByUuid(key);
		
		if(session==null) {
			return "User not Logged in";
		}
		
		uSessionRepository.delete(session);
		
		LocalDateTime localDateTime= LocalDateTime.now();
		
		return "Logged Out Successfully  "+localDateTime;
	}
	
	

}
