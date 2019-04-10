package com.virtusa.money.manager.user.service.test.UserTransaction;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.domain.UserTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserTransactionTest {

	private static final String USER_TRANSACTION_API_URI = "/api/user-transaction";
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@Autowired
	private ObjectMapper mapper;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}
	
	@Test
	public void addingValidTransaction() throws JsonProcessingException, Exception {
		
		Category category = new Category();
		category.setId(1L);
		category.setCategory("Expense");
		
		CategoryList categoryList = new CategoryList();
		categoryList.setId(1L);
		categoryList.setName("Fuel");
		categoryList.setCategory(category);
		
		UserTransaction transaction = new UserTransaction();
		transaction.setDate("19/08/2001");
		transaction.setAmount(500L);
		transaction.setCategoryList(categoryList);
		this.mockMvc.perform(MockMvcRequestBuilders.post(USER_TRANSACTION_API_URI)
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(transaction)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
