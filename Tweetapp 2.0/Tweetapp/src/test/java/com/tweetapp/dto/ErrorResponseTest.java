package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ErrorResponseTest {

	private ErrorResponse response = new ErrorResponse();
	
	//Testing the setter method
	
	@Test
	public void setResponseTest() {
		response.setResponse("Error 404");
		assertEquals("Error 404", response.getResponse());
	}

	//Testing of getter method
	
	@Test
	public void getResponseTest() {
		response.setResponse("Access not allowed");
		assertEquals("Access not allowed", response.getResponse());
	}
	
	//Testing constructor
	
	@Test
	public void constructorTest() {
		ErrorResponse response = new ErrorResponse();
		response.setResponse("Authorization error");
		assertEquals("Authorization error", response.getResponse());
	}
}
