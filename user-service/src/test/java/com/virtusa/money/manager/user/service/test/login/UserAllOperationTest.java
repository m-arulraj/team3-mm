package com.virtusa.money.manager.user.service.test.login;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.money.manager.user.service.domain.Role;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.resource.UserResource;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserAllOperationTest {

	private static final String USER_API_URI = "/api/user";
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@InjectMocks
	private UserResource userCredentialResource;

	@Autowired
	private ObjectMapper mapper;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void storingUser() throws JsonProcessingException, Exception {
		Role role = new Role();
		role.setRole("ROLE_ADMIN");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		User user = new User();
		user.setUserName("gopi@gmail.com");
		user.setPassword("gopi");
		user.setRoles(roles);
		String saveStatus = this.mockMvc
				.perform(MockMvcRequestBuilders.post(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(user)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location");
		this.mockMvc.perform(MockMvcRequestBuilders.get(saveStatus).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.userName", is("gopi@gmail.com"))).andExpect(jsonPath("$.password",is("gopi")))
				.andExpect(jsonPath("$.roles[0].role",is("ROLE_ADMIN")));
	}

	@Test
	public void retriveUser() throws JsonProcessingException, Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(USER_API_URI + "/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.userName", is("gopi@gmail.com"))).andExpect(jsonPath("$.password",is("gopi")))
				.andExpect(jsonPath("$.roles[0].role",is("ROLE_ADMIN")));
	}

	@Test
	public void retriveInvalidUser() throws JsonProcessingException, Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(USER_API_URI + "/0").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	public void modifyUser() throws JsonProcessingException, Exception {
		
		Role role = new Role();
		role.setRole("ROLE_USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		User user = new User();
		user.setId(2L);
		user.setUserName("gopi@gmail.com");
		user.setPassword("gopi");
		user.setRoles(roles);
		this.mockMvc.perform(MockMvcRequestBuilders.put(USER_API_URI).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo((ResultHandler) this.mockMvc.perform(MockMvcRequestBuilders.get(USER_API_URI+"/2").contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.userName", is("gopi@gmail.com")))
						.andExpect(jsonPath("$.password",is("gopi"))).andExpect(jsonPath("$.roles[0].role",is("ROLE_USER"))));
	}

}
