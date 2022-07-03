package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReplyTest {

	Reply reply = new Reply();
	
	//Testing of setter method
	
	@Test
	public void setCommentTest() {
		reply.setComment("Welcome back!");
		assertEquals("Welcome back!", reply.getComment());
	}
	
	//Testing of getter method
	
	@Test
	public void getCommentTest() {
		reply.setComment("Good Morning!");
		assertEquals("Good Morning!", reply.getComment());
	}
	
	//Testing of constructor
	
	@Test
	public void constructorTest() {
		Reply reply = new Reply("Lets Rock!");
		assertEquals("Lets Rock!", reply.getComment());
	}

}
