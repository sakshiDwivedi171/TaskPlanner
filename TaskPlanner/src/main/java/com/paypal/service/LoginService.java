package com.paypal.service;

import com.paypal.DTOs.LoginDTO;

public interface LoginService {

    public String logIntoAccount(LoginDTO logindto);
	
	public String logOutFromAccount(String key);
}
