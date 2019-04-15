package com.virtusa.money.manager.user.service.resource;

import java.time.DateTimeException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.service.SearchService;

@RestController
@RequestMapping(value="/api/report/transaction/")
public class SearchManagementResource {

	@Autowired
	SearchService searchService;
	
	@GetMapping(value="user/{id}")
	public ResponseEntity<?> getFullTransaction(@PathVariable("id")Long id){
		List<UserTransaction> transaction = searchService.getUserFullTransaction(id);
		if(transaction != null) {
			return ResponseEntity.ok().body(transaction);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping(value="user/{id}/type/{name}")
	public ResponseEntity<?> searchCategoryList(@PathVariable("name") String name,@PathVariable("id")Long id){
		List<UserTransaction> transaction = searchService.getUserTransactionByName(name,id);
		if(transaction != null) {
			return ResponseEntity.ok().body(transaction);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping(value="user/{id}/type/{name}/date")
	public ResponseEntity<?> searchCategoryListBydate(@PathVariable("name") String name,@PathVariable("id")Long id){
		List<UserTransaction> transaction = searchService.getTransactionByNameAndDate(name,id);
		if(transaction != null) {
			return ResponseEntity.ok().body(transaction);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping(value="user/{id}/type/{name}/category")
	public ResponseEntity<?> searchCategoryListByCategory(@PathVariable("name") String name,@PathVariable("id")Long id){
		List<UserTransaction> transaction = searchService.getTransactionByNameAndCategory(name,id);
		if(transaction != null) {
			return ResponseEntity.ok().body(transaction);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	@GetMapping(value="user/{id}/type/{name}/amount")
	public ResponseEntity<?> searchCategoryListByAmount(@PathVariable("name") String name,@PathVariable("id")Long id){
		List<UserTransaction> transaction = searchService.getTransactionByNameAndAmount(name,id);
		if(transaction != null) {
			return ResponseEntity.ok().body(transaction);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	@GetMapping(value="user/{id}/type/{name}/dates/{startDate}/{endDate}")
	public ResponseEntity<?> searchCategoryListBydateWithBoundries(@PathVariable("name") String name,@PathVariable("id")Long id,@PathVariable("startDate")String startDate,@PathVariable("endDate")String endDate){
		List<UserTransaction> transaction;
		try {
			transaction = searchService.getTransactionByNameAndDateWithBoundries(name, id, startDate, endDate);
			if(transaction != null) {
				return ResponseEntity.ok().body(transaction);
			}else {
				return ResponseEntity.noContent().build();
			}
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		
	}
	@GetMapping(value="user/{id}/type/{name}/amount/{amount}")
	public ResponseEntity<?> searchCategoryListByAmountWithRange(@PathVariable("name") String name,@PathVariable("id")Long id,@PathVariable("amount")Long amount){
		List<UserTransaction> transaction = searchService.getTransactionByNameAndAmountWithRange(name,id,amount);
		if(transaction != null) {
			return ResponseEntity.ok().body(transaction);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
}
