package com.virtusa.money.manager.user.service.test.login;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.money.manager.user.service.domain.User;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserAllOperationTest {

	private static final String USER_API_URI = "/api/user";
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
	public void storingUser() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("gopi@gmail.com");
		user.setPassword("gopikishor");
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
		this.mockMvc.perform(MockMvcRequestBuilders.get(USER_API_URI+"/gopi@gmail.com").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.userName", is("gopi@gmail.com")))
				.andExpect(jsonPath("$.password", is("gopikishor")));
	}

	@Test
	public void storingUserWithInvalidUserName() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("");
		user.setPassword("gopikishor");
		this.mockMvc.perform(MockMvcRequestBuilders.post(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().is(422));

	}

	@Test
	public void storingUserWithInvalidPassword() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("gopi@gmail.com");
		user.setPassword("gopir");
		this.mockMvc.perform(MockMvcRequestBuilders.post(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().is(422));

	}
	
	@Test
	public void retriveUserByName() throws JsonProcessingException, Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(USER_API_URI+"/gopi@gmail.com").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.userName", is("gopi@gmail.com")))
				.andExpect(jsonPath("$.password", is("gopikishor")));
	}

	@Test
	public void retriveInvalidUser() throws JsonProcessingException, Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(USER_API_URI+"/pawan@gmail.com").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void modifyUser() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("gopi@gmail.com");
		user.setPassword("gopikishor");
		this.mockMvc
				.perform(MockMvcRequestBuilders.put(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.userName", is("gopi@gmail.com")))
				.andExpect(jsonPath("$.password", is("gopikishor")));
	}

	@Test
	public void modifyInvalidUser() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("pawan@gmail.com");
		user.setPassword("gopikishor");
		this.mockMvc.perform(MockMvcRequestBuilders.put(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	public void modifyUserWithInvalidUserName() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("");
		user.setPassword("gopikishor");
		this.mockMvc.perform(MockMvcRequestBuilders.put(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void modifyUserWithInvalidPassword() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserName("gopi@gmail.com");
		user.setPassword("gopi");
		this.mockMvc.perform(MockMvcRequestBuilders.put(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().is(422));
	}

}
