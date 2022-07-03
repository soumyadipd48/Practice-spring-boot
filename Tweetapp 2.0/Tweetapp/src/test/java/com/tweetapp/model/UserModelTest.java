package com.tweetapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserModelTest {

	private UserModel user = new UserModel();

	// Testing of setter methods

	@Test
	public void setUsernameTest() {
		user.setUsername("User6692");
		assertEquals("User6692", user.getUsername());
	}

	@Test
	public void setFirstNameTest() {
		user.setFirstName("Subham");
		assertEquals("Subham", user.getFirstName());
	}

	@Test
	public void setLastNameTest() {
		user.setLastName("Bairagya");
		assertEquals("Bairagya", user.getLastName());
	}

	@Test
	public void setEmailTest() {
		user.setEmail("subhambairagya@gmail.com");
		assertEquals("subhambairagya@gmail.com", user.getEmail());
	}

	@Test
	public void setContactNumTest() {
		user.setContactNum("7013299756");
		assertEquals("7013299756", user.getContactNum());
	}

	@Test
	public void setPasswordTest() {
		user.setPassword("zzxcyn0");
		assertEquals("zzxcyn0", user.getPassword());
	}

	// Testing of getter methods

	@Test
	public void getUsernameTest() {
		user.setUsername("User3347");
		assertEquals("User3347", user.getUsername());
	}

	@Test
	public void getFirstNameTest() {
		user.setFirstName("Subham");
		assertEquals("Subham", user.getFirstName());
	}

	@Test
	public void getLastNameTest() {
		user.setLastName("Bairagya");
		assertEquals("Bairagya", user.getLastName());
	}

	@Test
	public void getEmailTest() {
		user.setEmail("subhambairagya@gmail.com");
		assertEquals("subhambairagya@gmail.com", user.getEmail());
	}

	@Test
	public void getContactNumTest() {
		user.setContactNum("7013299756");
		assertEquals("7013299756", user.getContactNum());
	}

	@Test
	public void getPasswordTest() {
		user.setPassword("zzxcyn0");
		assertEquals("zzxcyn0", user.getPassword());
	}

	//Testing Constructor
	
	@Test
	public void constructorTest() {
		UserModel user = new UserModel("User0079", "Subham", "Bairagya", "subhambairagya@gmail.com",
				"7013299756", "zzxcyn0");
		assertEquals("User0079", user.getUsername());
		assertEquals("Subham", user.getFirstName());
		assertEquals("Bairagya", user.getLastName());
		assertEquals("subhambairagya@gmail.com", user.getEmail());
		assertEquals("7013299756", user.getContactNum());
		assertEquals("zzxcyn0", user.getPassword());
	}
	
}
