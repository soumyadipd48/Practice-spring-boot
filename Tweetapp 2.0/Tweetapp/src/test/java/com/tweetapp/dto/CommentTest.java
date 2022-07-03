package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommentTest {

	Comment comment = new Comment();
	
	//Testing the setter methods
	
	@Test
	public void setUsernameTest() {
		comment.setUsername("abcd1234");
		assertEquals("abcd1234",comment.getUsername());
	}
	
	@Test
	public void setCommentTest() {
		comment.setComment("This is a comment");
		assertEquals("This is a comment", comment.getComment());
	}
	
	//Testing the getter methods
	
	@Test
	public void getusernameTest() {
		comment.setUsername("user1234");
		assertEquals("user1234",comment.getUsername());
	}
	
	@Test
	public void getCommentTest() {
		comment.setComment("First comment");
		assertEquals("First comment", comment.getComment());
	}
	
	//Testing Constructor
	
	@Test
	public void constructorTest() {
		Comment comment = new Comment("admin1", "Hi team");
		assertEquals("admin1",comment.getUsername());
		assertEquals("Hi team", comment.getComment());
	}

}
