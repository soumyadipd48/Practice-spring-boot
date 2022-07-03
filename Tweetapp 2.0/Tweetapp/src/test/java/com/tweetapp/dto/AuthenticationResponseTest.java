package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class AuthenticationResponseTest {

	private static final Logger LOG = LogManager.getLogger(AuthenticationResponseTest.class);
	
	AuthenticationResponse response = new AuthenticationResponse();
	
	@BeforeClass
	public static void initializeTest() {
		LOG.info("Testing : AuthenticationResponse");
	}
	
	//Testing of setter method
	
	@Test
	public void setResponseTest() {
		response.setResponse("Success");
		assertEquals("Success", response.getResponse());
	}
	
	//Testing of getter method
	
	@Test
	public void getResponseTest() {
		response.setResponse("Failure");
		assertEquals("Failure", response.getResponse());
	}
	
	//Testing of Constructor
	
	@Test
	public void constructorTest() {
		AuthenticationResponse response = new AuthenticationResponse("Denied");
		assertEquals("Denied", response.getResponse());
	}
	
	@AfterClass
	public static void terminateTest() {
		LOG.info("Testing is done : AuthenticationResponse");
	}

}
