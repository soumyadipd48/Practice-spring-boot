package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LikeTest {

	Like like = new Like();
	
	//Testing the setter methods
	
	@Test
	public void setTweetIdTest() {
		like.setTweetId("abcd1234");
		assertEquals("abcd1234", like.getTweetId());
	}
	
	@Test
	public void setUsernameTest() {
		like.setUsername("cognizant");
		assertEquals("cognizant", like.getUsername());
	}
	
	//Testing the getter methods
	
	@Test
	public void getTweetIdTest() {
		like.setTweetId("user1234");
		assertEquals("user1234", like.getTweetId());
	}

	@Test
	public void getUsernameTest() {
		like.setUsername("techademy");
		assertEquals("techademy", like.getUsername());
	}
	
	//Testing the Constructor
	@Test
	public void constructorTest() {
		Like _like = new Like("id007", "user123");
		assertEquals("id007", _like.getTweetId());
		assertEquals("user123", _like.getUsername());
	}
}
