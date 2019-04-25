package com.moneymanager.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneymanager.client.domain.CategoryList;
import com.moneymanager.client.util.EndPointUri;

@Service
public class CategoryService {
	@Autowired
	RestTemplate restTemplate;

	public List<CategoryList> getCategoriesList(Long id) {
		String uri = EndPointUri.CATEGORIESLIST + "/list/" + id;

		
		ResponseEntity<List<CategoryList>> result = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CategoryList>>() {
				});

		List<CategoryList> categoriesList = result.getBody();
		return categoriesList;
	}
	
	public void saveCategory(Long id ,CategoryList categoryList) {
		String uri = EndPointUri.CATEGORY+ id;
		restTemplate.postForEntity(uri, categoryList, String.class);
	}

}
