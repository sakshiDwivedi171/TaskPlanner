package com.paypal.DTOs;

import com.paypal.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

	
	
	@NotEmpty (message = "Email Id Can't be Empty.")
	@Email
	private String emailId;
	
	@NotEmpty (message = "Password Can't be Empty.")
	private String password;
	
}
