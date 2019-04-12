package com.virtusa.money.manager.user.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CategoryList {

	@Id
	@GeneratedValue
	Long id;
	@Column(unique=true)
	String name;
	@ManyToOne
	Category category;
}
