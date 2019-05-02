package com.moneymanager.client.domain;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;



@Data
public class RegisterUser {

	
	Long id;
	
	@Pattern(regexp = "[^0-9]*", message = "MM0111-invalid")
	@NotEmpty(message = "MM0001-Name can’t be empty")
	String name;
	
	@Size(min = 3, max = 20, message = "MM0011-Email id can't be empty")
	@Email(message = "MM0022-Please enter a valid email")
	String emailId;

	@NotEmpty(message = "MM0017-Mobile Number can’t be empty")
	@Size(min = 10, max = 10, message = "MM0018-Mobile number should be 10 digit")
	@Pattern(regexp = "[^a-z]*", message = "MM0111-invalid")
	//@Max(value = 9999999999L, message = "MM0018-Mobile number should be 10 digit")
	String mobileNumber;

	@NotEmpty(message = "MM0022-Gender can’t be empty")
	String gender;


	String password;


	String confirmPassword;
	
	@NotEmpty(message = "MM0024- Date of Birth can’t be empty")
	String dateOfBirth;
	
	User user;
}
