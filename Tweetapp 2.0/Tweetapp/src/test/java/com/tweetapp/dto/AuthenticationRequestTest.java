package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthenticationRequestTest {

	AuthenticationRequest request = new AuthenticationRequest();
	
	//Testing of setter methods
	
	@Test
	public void setUsernameTest() {
		request.setUsername("user555");
		assertEquals("user555", request.getUsername());
	}
	
	@Test
	public void setPasswordTest() {
		request.setPassword("zzzxxx");
		assertEquals("zzzxxx", request.getPassword());
	}
	
	//Testing of getter methods
	
	@Test
	public void getUsernameTest() {
		request.setUsername("topGamers");
		assertEquals("topGamers", request.getUsername());
	}
	
	@Test
	public void getPasswordTest() {
		request.setPassword("pass009");
		assertEquals("pass009", request.getPassword());
	}

	//Testing Constructor
	
	@Test
	public void constructorTest() {
		AuthenticationRequest request = new AuthenticationRequest("user75", "zxcvbnm0");
		assertEquals("user75", request.getUsername());
		assertEquals("zxcvbnm0", request.getPassword());
	}
	
}
