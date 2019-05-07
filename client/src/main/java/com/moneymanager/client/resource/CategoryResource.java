package com.moneymanager.client.resource;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String expenseResource(Model model,Principal principal) {

		principal.getName();
		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		List<CategoryList> list = categoryService.getCategoriesList(1L);
		model.addAttribute("categoriesList", list);
		
		model.addAttribute("type", "expense");
		UserTransaction transaction=new UserTransaction();
		transaction.setDate(LocalDate.now().toString());
		model.addAttribute("transaction",transaction);
		return "expense";

	}

	@GetMapping("/incomeResource")
	public String incomeResource(Model model,Principal principal) {

		principal.getName();
		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		List<CategoryList> list = categoryService.getCategoriesList(2L);
		model.addAttribute("categoriesList", list);
		UserTransaction transaction=new UserTransaction();
		transaction.setDate(LocalDate.now().toString());
		model.addAttribute("transaction",transaction);
		model.addAttribute("type", "income");
		return "income";
	}

	@GetMapping("/investmentResource")
	public String investmentResource(Model model,Principal principal) {

		principal.getName();
		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");
		List<CategoryList> list = categoryService.getCategoriesList(3L);
		model.addAttribute("categoriesList", list);
		model.addAttribute("type", "investment");
		UserTransaction transaction=new UserTransaction();
		transaction.setDate(LocalDate.now().toString());
		model.addAttribute("transaction",transaction);
		return "investment";
	}
	@GetMapping("/expense/category-list")
	public String saveExpenseCategory(@RequestParam("typeName")String name ,Model model,RedirectAttributes attributes) {

		CategoryList categoryList = new CategoryList();
		categoryList.setName(name);
		categoryService.saveCategory(1L, categoryList);
		attributes.addFlashAttribute("success", "Object has been removed successfully.");
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
	@ExceptionHandler(NullPointerException.class)
	public String handleError(Exception e) {

		System.out.println(e.getMessage());
		return "error-page";
	}
	

}
