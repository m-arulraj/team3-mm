package com.virtusa.money.manager.user.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryListRepository categoryListRepository;

	public List<CategoryList> getCategories(Long id) {

		Optional<Category> category = categoryRepository.findById(id);
		List<CategoryList> categoryList = null;
		if (category.isPresent()) {
			categoryList = categoryListRepository.findByCategory(category.get());
		}

		return categoryList;
	}

}
