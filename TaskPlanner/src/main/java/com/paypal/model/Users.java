package com.paypal.model;

import com.paypal.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
	
	private String userName;      //Name: (String) the user's name
	private String userEmail;     //Email: (String) the user's email address
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private  UserRole userRole;   //Role: (Enum) the user's role in the system (e.g. developer, tester, project manager, etc.)
}
