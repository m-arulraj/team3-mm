package com.moneymanager.client.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

	private Long id;
	@Size(min=3,max=20,message="MM0021-UserName can't be empty")
	@Email(message="MM0022-Please enter a valid email")
	private String userName;
	@Size(min=6,max=15, message="MM0023-Password should be in between 6-15")
	private String password;
	
	
}
