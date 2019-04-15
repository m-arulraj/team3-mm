package com.virtusa.money.manager.user.service.test.searchmanagement;

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

import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;
import com.virtusa.money.manager.user.service.repository.UserRepository;
import com.virtusa.money.manager.user.service.repository.UserTransactionRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class SearchOperationTest {

	private static final String URI ="/api/report/transaction/user/"; 
	
	@Autowired
	WebApplicationContext applicationContext;
	
	@Autowired
	CategoryRepository categoryService;
	
	@Autowired
	CategoryListRepository categoryListService;
	
	@Autowired
	UserRepository userService;
	
	@Autowired
	UserTransactionRepository transactionService;
	
	
	MockMvc mockMvc;
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
		User user = new User();
		user.setUserName("ajith@gmail.com");
		user.setPassword("jasdugdubasd");
		userService.save(user);
		
		Category category = new Category();
		category.setCategory("Expense");
		Category savedCategoryExpence = categoryService.save(category);
		
		Category category2 = new Category();
		category2.setCategory("Income");
		Category savedCategoryIncome = categoryService.save(category);
		
		CategoryList categoryList1 = new CategoryList();
		categoryList1.setName("fuel");
		categoryList1.setCategory(savedCategoryExpence);

		CategoryList savedCategoryExpence1=categoryListService.save(categoryList1);
		
		CategoryList categoryList11 = new CategoryList();
		categoryList11.setName("fuel");
		categoryList11.setCategory(savedCategoryIncome);

		CategoryList savedCategoryIncome1=categoryListService.save(categoryList11);
		
		
		CategoryList categoryList2 = new CategoryList();
		categoryList2.setName("food");
		categoryList2.setCategory(savedCategoryExpence);
		CategoryList savedCategoryExpence2=categoryListService.save(categoryList2);
		
		UserTransaction transaction3= new UserTransaction();
		transaction3.setAmount(200L);
		transaction3.setCategoryList(savedCategoryIncome1);
		transaction3.setDate("22-09-2010");
		transaction3.setUser(user);
		
		transactionService.save(transaction3);
		
		UserTransaction transaction= new UserTransaction();
		transaction.setAmount(1000L);
		transaction.setCategoryList(savedCategoryExpence1);
		transaction.setDate("22-09-2012");
		transaction.setUser(user);

		transactionService.save(transaction);
		
		UserTransaction transaction2= new UserTransaction();
		transaction2.setAmount(1001313L);
		transaction2.setCategoryList(savedCategoryExpence2);
		transaction2.setDate("22-09-2012");
		transaction2.setUser(user);
		
		transactionService.save(transaction2);
		
		
	}
	@Test
	public void getFullTransaction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void getFullTransactionInvalidUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"0")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	@Test
	public void searchCategoryListByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void searchCategoryListByInvalidName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/wrong")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	@Test
	public void searchCategoryListByNameAndDate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/date")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void searchCategoryListByNameAndDateInvalid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"0/type/fuel/date")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	@Test
	public void searchCategoryListByNameAndCategory() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/category")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void searchCategoryListByNameAndCategoryInvalid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"0/type/fuel/category")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	@Test
	public void searchCategoryListByNameAndAmount() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/amount")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void searchCategoryListByNameAndAmountInvalid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"0/type/fuel/amount")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	@Test
	public void searchCategoryListByNameAndDateWithBoundries() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/dates/22-09-2011/22-09-2013")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void searchCategoryListByNameAndDateWithBoundriesNoInfo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/dates/22-09-2017/22-09-2019")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	@Test
	public void searchCategoryListByNameAndDateWithBoundriesInvalidDate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/dates/2013/22-09-2013")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void searchCategoryListByNameAndAmountWithRange() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/amount/200")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void searchCategoryListByNameAndAmountWithRangeInvalid() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"1/type/fuel/amount/2")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
}
