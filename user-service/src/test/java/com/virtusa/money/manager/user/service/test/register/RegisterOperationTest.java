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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
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
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setGender("male");
		registration.setMobileNumber("3456789023");
		registration.setPassword("ajither");
		registration.setConfirmPassword("ajitherwe");
		
		String returnedStatusUri = mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn().getResponse().getHeader("Location");
		
		mockMvc.perform(MockMvcRequestBuilders.get(returnedStatusUri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.name", is("ajith kumar")));
	}
	
	@Test
	public void getInvalidUser() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(URI+"/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	public void userNameWithNumber() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith343");
		registration.setEmailId("ajith@gmail");
		registration.setGender("male");
		registration.setMobileNumber("121313131");
		registration.setPassword("ajith");
		registration.setConfirmPassword("ajith");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	@Test
	public void registerWithoutUserName() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setEmailId("ajith@gmail");
		registration.setGender("male");
		registration.setMobileNumber("121313131");
		registration.setPassword("ajith");
		registration.setConfirmPassword("ajith");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	
	@Test
	public void registerWithoutEmailid() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajithkumar");
		registration.setGender("male");
		registration.setMobileNumber("121313131");
		registration.setPassword("ajith");
		registration.setConfirmPassword("ajith");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	@Test
	public void registerWithInvalidEmailid() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith");
		registration.setGender("male");
		registration.setMobileNumber("3456789023");
		registration.setPassword("ajither");
		registration.setConfirmPassword("ajitherwe");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	
	@Test
	public void registerWithoutMobileNumber() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setGender("male");
		registration.setPassword("ajither");
		registration.setConfirmPassword("ajitherwe");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	

	@Test
	public void registerWithInvalidMobileNumber() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setMobileNumber("789023343s");
		registration.setGender("male");
		registration.setPassword("ajither");
		registration.setConfirmPassword("ajitherwe");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	
	@Test
	public void registerWithoutPassword() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setMobileNumber("6789023343");
		registration.setGender("male");
		registration.setPassword("ar");
		registration.setConfirmPassword("ajitherwe");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	@Test
	public void registerWithInvalidPassword() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setMobileNumber("6789023343");
		registration.setGender("male");
		registration.setConfirmPassword("ajitherwe");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	
	@Test
	public void registerWithoutConfirmPassword() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setMobileNumber("7890233435");
		registration.setGender("male");
		registration.setPassword("ajither");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	
	@Test
	public void registerWithInvalidConfirmPassword() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setMobileNumber("7890233435");
		registration.setGender("male");
		registration.setPassword("ajither");
		registration.setConfirmPassword("aj");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
	
	@Test
	public void registerWithoutGender() throws Exception {
		RegisterUser registration = new RegisterUser();
		registration.setName("ajith kumar");
		registration.setEmailId("ajith@gmail.com");
		registration.setMobileNumber("7890233435");
		registration.setPassword("ajither");
		registration.setConfirmPassword("ajither");
		
		 mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().is(422));
		
	}
}
