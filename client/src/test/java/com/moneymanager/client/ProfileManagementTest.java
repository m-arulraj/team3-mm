package com.moneymanager.client;

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
public class ProfileManagementTest {

	private static final String URI = "/api/register/updateProfile?emailId=vamsi@gmail.com";
	@Autowired
	WebApplicationContext wac;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testingUpdateUserProfile() throws Exception {
		RegisterUser registerUser = new RegisterUser();
		registerUser.setName("VamsiKrishnaKomati");
		registerUser.setMobileNumber("9956552288");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testingUpdateUserProfileWithNameContainingNumbers() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("Vamsi343");// NameContainingNumbers
		registerUser.setMobileNumber("9956552288");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithOutName() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("");// WithOutName
		registerUser.setMobileNumber("9956552288");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithMobileNumberContainingLetters() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setEmailId("vamsi@gmail.com");
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("9956552288L");// MobileNumberContainingLetters
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithMoreThanTenDigitsMobileNumber() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setEmailId("vamsi@gmail.com");
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("9956552288858");// GreaterThanSizeOfMobileNumber
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithLessThanSizeOfMobileNumber() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setEmailId("vamsi@gmail.com");
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("99565");// LessThanSizeOfMobileNumber
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithOutMobileNumber() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("VamsiKrishnaKomati");
		registerUser.setMobileNumber("");// WithOutMobileNumber
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithOutGender() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("VamsiKrishnaKomati");
		registerUser.setMobileNumber("9658452365");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("");// WithOutGender

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithOutPassword() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("VamsiKrishnaKomati");
		registerUser.setMobileNumber("9658452365");
		registerUser.setPassword("");// WithOutPassword
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithMoreThanSizeOfPassword() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setEmailId("vamsi@gmail.com");
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("9956552288858");
		registerUser.setPassword("vamsikrishna@123");// MoreThanSizeOfPassword
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithLessThanSizeOfPassword() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setEmailId("vamsi@gmail.com");
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("99565");
		registerUser.setPassword("vamsi");// LessThanSizeOfPassword
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithOutConfirmPassword() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("VamsiKrishnaKomati");
		registerUser.setMobileNumber("9658452365");
		registerUser.setPassword("");// without password
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithMoreThanSizeOfConfirmPassword() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("9956552288858");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsikrishna@123");// Greater than size of password
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithLessThanSizeOfConfirmPassword() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("Vamsi343");
		registerUser.setMobileNumber("99565");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi");// Less than size of password
		registerUser.setDateOfBirth("12-12-1992");
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

	@Test
	public void testingUpdateUserProfileWithOutDateOfBirth() throws Exception {

		RegisterUser registerUser = new RegisterUser();
		registerUser.setId(1L);
		registerUser.setName("VamsiKrishnaKomati");
		registerUser.setMobileNumber("9658452365");
		registerUser.setPassword("vamsi@123");
		registerUser.setConfirmPassword("vamsi@123");
		registerUser.setDateOfBirth("");// without date of birth
		registerUser.setGender("Male");

		mockMvc.perform(MockMvcRequestBuilders.put(URI).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(registerUser))).andExpect(MockMvcResultMatchers.status().is(422));
	}

}
