package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=3,max=20,message="MM0021-UserName can't be empty")
	@Email(message="MM0022-Please enter a valid email")
	private String userName;
	@Size(min=6,max=15, message="MM0023- Password should be in between 6-15")
	private String password;
}
