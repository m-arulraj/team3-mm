package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class UserTransaction {

	@Id
	@GeneratedValue
	Long id;
	String date;
	Long amount;
	@OneToOne
	CategoryList categoryList;
	@OneToOne
	User user;
}
