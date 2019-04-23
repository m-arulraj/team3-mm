package com.moneymanager.client.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.CategoryList;
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
		return "expense";

	}

	@GetMapping("/incomeResource")
	public String incomeResource(Model model) {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		List<CategoryList> list = categoryService.getCategoriesList(1L);

		System.out.println(list);
		model.addAttribute("categoriesList", list);

		model.addAttribute("type", "income");
		return "expense";

	}

	@GetMapping("/investmentResource")
	public String investmentResource(Model model) {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");
		List<CategoryList> list = categoryService.getCategoriesList(1L);
		model.addAttribute("categoriesList", list);
		model.addAttribute("type", "investment");
		return "expense";

	}

}
