package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {

	@Id
	Long id;
	
	String category;
}
