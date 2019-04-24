package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;

@Service
public class CategoryListService {

	@Autowired
	CategoryListRepository categoryListRepository;
	
	public CategoryList getCategoryList(Long id) {
		Optional<CategoryList> optional=categoryListRepository.findById(id);
		return optional.isPresent() ? optional.get() : new CategoryList();
	}
}
