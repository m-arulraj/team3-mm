package com.virtusa.money.manager.user.service.test.register;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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

import com.google.gson.Gson;
import com.virtusa.money.manager.user.service.domain.RegisterUser;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RegisterOperationTest {

	private static final String URI ="/api/register";
	@Autowired
	WebApplicationContext applicationContext;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp(){
		this.mockMvc=MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}
	
	@Test
	public void saveUser() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith");
		registration.setEmailId("ajith@gmail");
		registration.setGender("male");
		registration.setMobileNumber(121313131L);
		registration.setPassword("ajith");
		registration.setConfirmPassword("ajith");
		
		String returnedStatusUri = mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn().getResponse().getHeader("Location");
		
		mockMvc.perform(MockMvcRequestBuilders.get(returnedStatusUri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.name", is("ajith")));
	}
	
	@Test
	public void getInvalidUser() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
}
