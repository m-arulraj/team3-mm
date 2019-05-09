package com.moneymanager.client.domain;

import lombok.Data;

@Data
public class UserTransaction {

	Long id;
	CategoryList categoryList;
	
	String note;
	User user;

	String date;
	Long amount;
	String userEmail;
	Long categoryListId;
	
	}
