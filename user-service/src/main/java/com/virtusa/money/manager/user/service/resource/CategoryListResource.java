package com.virtusa.money.manager.user.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.exception.EntityNotFoundException;
import com.virtusa.money.manager.user.service.service.CategoryListService;

@RestController
@RequestMapping("/category-list")
public class CategoryListResource {

	@Autowired
	CategoryListService categoryListService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getFullTransaction(@PathVariable("id") Long id) throws EntityNotFoundException {
		CategoryList categoryList= categoryListService.getCategoryList(id);
		if (categoryList.getId() != null) {
			return ResponseEntity.ok().body(categoryList);
		} else {
			throw new EntityNotFoundException("List data not found", "MM0013");
		}

	}
}
