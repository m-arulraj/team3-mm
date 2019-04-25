package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;

@Service
public class CategoryListService {

	@Autowired
	CategoryListRepository categoryListRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public CategoryList getCategoryList(Long id) {
		Optional<CategoryList> optional=categoryListRepository.findById(id);
		return optional.isPresent() ? optional.get() : new CategoryList();
	}
	
	public CategoryList saveCategoryList(Long id ,CategoryList categoryList) {
		Optional<Category> category = categoryRepository.findById(id);
		categoryList.setCategory(category.get());
		return categoryListRepository.save(categoryList);
	}
}
