package com.virtusa.money.manager.report;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.virtusa.money.manager.user.service.UserServiceApplication;
import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;
import com.virtusa.money.manager.user.service.repository.UserRepository;
import com.virtusa.money.manager.user.service.repository.UserTransactionRepository;

@SpringBootTest(classes=UserServiceApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ReportTest {

	private static final String REPORT_API_URI = "/api/user/report/";
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@Autowired
	CategoryRepository categoryService;

	@Autowired
	CategoryListRepository categoryListService;

	@Autowired
	UserRepository userService;

	@Autowired
	UserTransactionRepository transactionService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
		User user = new User();
		user.setUserName("ajith@gmail.com");
		user.setPassword("jasdugdubasd");
		User SavedUser1 = userService.save(user);
		
		User user2 = new User();
		user2.setUserName("gopi@gmail.com");
		user2.setPassword("jasdugdubasd");
		User SavedUser2 = userService.save(user2);

		Category category = new Category();
		category.setId(20L);
		category.setCategory("Expense");
		Category savedCategoryExpence = categoryService.save(category);

		Category category2 = new Category();
		category2.setId(30L);
		category2.setCategory("Income");
		Category savedCategoryIncome = categoryService.save(category);

		CategoryList categoryList1 = new CategoryList();
		categoryList1.setName("fuel");
		categoryList1.setCategory(savedCategoryExpence);

		CategoryList savedCategoryExpence1 = categoryListService.save(categoryList1);

		CategoryList categoryList11 = new CategoryList();
		categoryList11.setName("food");
		categoryList11.setCategory(savedCategoryIncome);

		CategoryList savedCategoryIncome1 = categoryListService.save(categoryList11);

		CategoryList categoryList2 = new CategoryList();
		categoryList2.setName("sports");
		categoryList2.setCategory(savedCategoryExpence);
		CategoryList savedCategoryExpence2 = categoryListService.save(categoryList2);

		UserTransaction transaction3 = new UserTransaction();
		transaction3.setAmount(200L);
		transaction3.setCategoryList(savedCategoryIncome1);
		transaction3.setDate("11/09/2000");
		transaction3.setUser(SavedUser1);

		transactionService.save(transaction3);

		UserTransaction transaction = new UserTransaction();
		transaction.setAmount(1000L);
		transaction.setCategoryList(savedCategoryExpence1);
		transaction.setDate("11/09/2000");
		transaction.setUser(SavedUser1);

		transactionService.save(transaction);

		UserTransaction transaction2 = new UserTransaction();
		transaction2.setAmount(500L);
		transaction2.setCategoryList(savedCategoryExpence2);
		transaction2.setDate("11/07/2000");
		transaction2.setUser(SavedUser1);

		transactionService.save(transaction2);
		
		
	}

	@Test
	public void getReport() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(REPORT_API_URI+"1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getReportInvalid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(REPORT_API_URI+"2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}


}
