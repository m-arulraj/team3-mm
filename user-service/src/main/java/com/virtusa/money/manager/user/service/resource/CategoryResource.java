package com.virtusa.money.manager.user.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.exception.EntityNotFoundException;
import com.virtusa.money.manager.user.service.service.CategoryService;

@RestController
@RequestMapping("/api/user-category")
public class CategoryResource {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> getCategoriesList(@PathVariable Long id) throws EntityNotFoundException {
		if (categoryService.getCategories(id) != null) {
			
			return ResponseEntity.status(200).body(categoryService.getCategories(id));
		} else {

			throw new EntityNotFoundException("Categories data not found", "MM0013");
		}
	}
}
