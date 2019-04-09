package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class RegisterUser {

	@Id
	@GeneratedValue
	Long id;
	
	String name;
	
	String emailId;
	
	Long mobileNumber;
	
	String gender;
	
	@Transient
	String password;
	
	@Transient
	String confirmPassword;
}
