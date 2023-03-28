package com.paypal.service;

import com.paypal.DTOs.LoginDTO;
import com.paypal.exceptions.UserException;
import com.paypal.model.Users;

public interface LoginService {

    public Users logIntoAccount(LoginDTO logindto) throws UserException;
	
	public String logOutFromAccount(String key);
}
