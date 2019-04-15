package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class UserTransaction {

	@Id
	@GeneratedValue
	Long id;
	@NotNull(message="MM0023-Please select a category")
	@OneToOne
	CategoryList categoryList;
	@OneToOne
	User user;
	@Pattern(regexp = "([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}",message="MM0024-Date must be in specified format(dd/MM/yyyy)")
	String date;
	@Min(value=1,message="MM0025-Amount must be greater then 0")
	Long amount;
}
