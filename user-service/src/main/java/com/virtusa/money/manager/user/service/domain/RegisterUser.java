package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class RegisterUser {

	@Id
	@GeneratedValue
	Long id;
	@Pattern(regexp = "[^0-9]*", message = "MM0111-invalid")

	@NotEmpty(message = "MM0001-Name can’t be empty")
	String name;
	
	@Size(min = 3, max = 20, message = "MM0011-Email id can't be empty")
	@Email(message = "MM0022-Please enter a valid email")
	String emailId;

	@NotNull(message = "MM0017-Mobile Number can’t be empty")
	//@Max(value = 9999999999L, message = "MM0018-Mobile number should be 10 digit")
	Long mobileNumber;

	String gender;

	@NotEmpty(message = "MM0015- Password can’t be empty")
	@Size(min = 6, max = 12, message = "MM0018-Password should be 6-12 characters")
	@Transient
	String password;

	@NotEmpty(message = "MM0016-Confirm Password can’t be empty")
	@Size(min = 6, max = 12, message = "MM0018-Password should be 6-12 characters")
	@Transient
	String confirmPassword;
}
