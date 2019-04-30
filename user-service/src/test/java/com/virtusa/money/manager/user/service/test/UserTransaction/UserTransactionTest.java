package com.virtusa.money.manager.user.service.test.UserTransaction;

import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.money.manager.user.service.UserServiceApplication;
import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;
import com.virtusa.money.manager.user.service.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserServiceApplication.class,webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTransactionTest {

	private static final String USER_TRANSACTION_API_URI = "/api/user-transaction";
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryListRepository categoryListRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private ObjectMapper mapper;

	private Category category;
	private CategoryList categoryList;
	private User user;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
		
		Category category1 = new Category();
		category1.setId(1L);
		category1.setCategory("Expense");
		category = categoryRepository.save(category1);

		CategoryList categoryList1 = new CategoryList();
		categoryList1.setId(1L);
		categoryList1.setName("Fuel");
		categoryList1.setCategory(category);
		categoryList = categoryListRepository.save(categoryList1);

		User user1 = new User();
		user1.setId(2L);
		user1.setUserName("gopi@gmail.com");
		user1.setPassword("gopikishor");
		user = userRepository.save(user1);
	}

	@Test
	public void A_addingTransactionWithExistingCategoryList() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setDate("19/08/2001");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.date", is("19/08/2001")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.amount", is(500)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.name",is("Fuel")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.category.category",is("Expense")));
	}
	
	@Test
	public void B_addingTransactionWithNewCategoryList() throws JsonProcessingException, Exception {

		CategoryList categoryList1 = new CategoryList();
		categoryList1.setName("Food");
		categoryList1.setCategory(category);
		UserTransaction transaction = new UserTransaction();
		transaction.setDate("19/08/2001");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList1);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.date", is("19/08/2001")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.amount", is(500)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.name",is("Food")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.category.category",is("Expense")));
	}
	
	@Test
	public void C_addingTransactionWithoutCategoryList() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setDate("19/08/2001");
		transaction.setAmount(500L);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void D_addingTransactionWithoutAmount() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setDate("19/08/2001");
		transaction.setAmount(0L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void E_addingTransactionWithInvalidDate() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setDate("19/08/200");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void F_updateTransactionWithExistingCategoryList() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setId(3L);
		transaction.setDate("19/10/2001");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI+"/transaction").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.date", is("19/10/2001")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.amount", is(500)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.name",is("Fuel")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.category.category",is("Expense")));
	}
	
	@Test
	public void G_updateTransactionWithNewCategoryList() throws JsonProcessingException, Exception {

		CategoryList categoryList1 = new CategoryList();
		categoryList1.setName("Sports");
		categoryList1.setCategory(category);
		UserTransaction transaction = new UserTransaction();
		transaction.setId(3L);
		transaction.setDate("19/12/2001");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList1);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.date", is("19/12/2001")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.amount", is(500)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.name",is("Sports")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.categoryList.category.category",is("Expense")));
	}
	
	@Test
	public void H_updateTransactionWithoutCategoryList() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setId(3L);
		transaction.setDate("19/08/2001");
		transaction.setAmount(500L);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void I_updateTransactionWithoutAmount() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setId(3L);
		transaction.setDate("19/08/2001");
		transaction.setAmount(0L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void J_updateTransactionWithInvalidDate() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setId(3L);
		transaction.setDate("19/08/200");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void K_updateInvalidTransaction() throws JsonProcessingException, Exception {

		UserTransaction transaction = new UserTransaction();
		transaction.setId(1L);
		transaction.setDate("19/08/2001");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList);
		transaction.setUser(user);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put(USER_TRANSACTION_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	public void L_deletTransaction() throws JsonProcessingException, Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.delete(USER_TRANSACTION_API_URI+"/3").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void M_deletInvalidTransaction() throws JsonProcessingException, Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.delete(USER_TRANSACTION_API_URI+"/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	public void N_gettingCategoryList() throws JsonProcessingException, Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.get(USER_TRANSACTION_API_URI+"/getCategories/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
}
