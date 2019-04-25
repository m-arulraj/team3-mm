package com.moneymanager.client.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.CategoryList;
import com.moneymanager.client.domain.UserTransaction;
import com.moneymanager.client.service.CategoryService;

@Controller
public class CategoryResource {

	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);

	@Autowired
	CategoryService categoryService;

	@GetMapping("/expenseResource")
	public String expenseResource(Model model) {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		List<CategoryList> list = categoryService.getCategoriesList(1L);
		model.addAttribute("categoriesList", list);
		model.addAttribute("type", "expense");
		model.addAttribute("transaction",new UserTransaction());
		return "expense";

	}

	@GetMapping("/incomeResource")
	public String incomeResource(Model model) {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		List<CategoryList> list = categoryService.getCategoriesList(2L);

		System.out.println(list);
		model.addAttribute("categoriesList", list);

		model.addAttribute("transaction",new UserTransaction());
		model.addAttribute("type", "income");
		return "income";

	}

	@GetMapping("/investmentResource")
	public String investmentResource(Model model) {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");
		List<CategoryList> list = categoryService.getCategoriesList(3L);
		model.addAttribute("categoriesList", list);
		model.addAttribute("type", "investment");
		model.addAttribute("transaction",new UserTransaction());
		return "investment";
	}
	
	@GetMapping("/expense/category-list")
	public String saveExpenseCategory(@RequestParam("typeName")String name ,Model model) {

		CategoryList categoryList = new CategoryList();
		categoryList.setName(name);
		categoryService.saveCategory(1L, categoryList);
		return "redirect:/expenseResource";

	}
	@GetMapping("/income/category-list")
	public String saveIncomeCategory(@RequestParam("typeName")String name ,Model model) {

		CategoryList categoryList = new CategoryList();
		categoryList.setName(name);
		categoryService.saveCategory(2L, categoryList);
		return "redirect:/incomeResource";

	}
	@GetMapping("/investment/category-list")
	public String saveInvestmentCategory(@RequestParam("typeName")String name ,Model model) {

		CategoryList categoryList = new CategoryList();
		categoryList.setName(name);
		categoryService.saveCategory(3L, categoryList);
		return "redirect:/investmentResource";

	}
	
	

}
