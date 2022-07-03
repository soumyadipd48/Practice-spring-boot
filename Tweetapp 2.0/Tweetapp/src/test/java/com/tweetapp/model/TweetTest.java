package com.tweetapp.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tweetapp.dto.Comment;

class TweetTest {

	private Tweet tweet = new Tweet();

	// Testing of setter methods

	@Test
	public void setTweetIdTest() {
		tweet.setTweetId("ASD3390");
		assertEquals("ASD3390", tweet.getTweetId());
	}

	@Test
	public void setUsernameTest() {
		tweet.setUsername("User114");
		assertEquals("User114", tweet.getUsername());
	}

	@Test
	public void setTweetTextTest() {
		tweet.setTweetText("Joined Cognizant.");
		assertEquals("Joined Cognizant.", tweet.getTweetText());
	}

	@Test
	public void setFirstNameTest() {
		tweet.setFirstName("Subham");
		assertEquals("Subham", tweet.getFirstName());
	}

	@Test
	public void setLastNameTest() {
		tweet.setLastName("Bairagya");
		assertEquals("Bairagya", tweet.getLastName());
	}

	@Test
	public void setTweetDateTest() {
		tweet.setTweetDate("06/28/2022");
		assertEquals("06/28/2022", tweet.getTweetDate());
	}

	@Test
	public void setLikesTest() {
		List<String> likes = new ArrayList<>();
		tweet.setLikes(likes);
		assertEquals(likes, tweet.getLikes());
	}

	@Test
	public void setCommentsTest() {
		List<Comment> comments = new ArrayList<>();
		tweet.setComments(comments);
		assertEquals(comments, tweet.getComments());
	}

	// Testing of getter methods

	@Test
	public void getTweetIdTest() {
		tweet.setTweetId("FGH3381");
		assertEquals("FGH3381", tweet.getTweetId());
	}

	@Test
	public void getUsernameTest() {
		tweet.setUsername("Admin991");
		assertEquals("Admin991", tweet.getUsername());
	}

	@Test
	public void getTweetTextTest() {
		tweet.setTweetText("Leaving twitter");
		assertEquals("Leaving twitter", tweet.getTweetText());
	}

	@Test
	public void getFirstNameTest() {
		tweet.setFirstName("Subham");
		assertEquals("Subham", tweet.getFirstName());
	}

	@Test
	public void getLastNameTest() {
		tweet.setLastName("Bairagya");
		assertEquals("Bairagya", tweet.getLastName());
	}

	@Test
	public void getTweetDateTest() {
		tweet.setTweetDate("03/12/2022");
		assertEquals("03/12/2022", tweet.getTweetDate());
	}

	@Test
	public void getLikesTest() {
		List<String> likes = new ArrayList<>();
		tweet.setLikes(likes);
		assertEquals(likes, tweet.getLikes());
	}

	@Test
	public void getCommentsTest() {
		List<Comment> comments = new ArrayList<>();
		tweet.setComments(comments);
		assertEquals(comments, tweet.getComments());
	}
	
	//Testing Constructor
	
	@Test
	public void constructorTest() {
		List<String> likes = new ArrayList<>();
		List<Comment> comments = new ArrayList<>();
		Tweet tweet = new Tweet(
				"MNS1132",
				"User6678",
				"I love programming",
				"Subham",
				"Bairagya",
				"04/25/2021",
				likes,
				comments);
		assertEquals("MNS1132", tweet.getTweetId());
		assertEquals("User6678", tweet.getUsername());
		assertEquals("I love programming", tweet.getTweetText());
		assertEquals("Subham", tweet.getFirstName());
		assertEquals("Bairagya", tweet.getLastName());
		assertEquals("04/25/2021", tweet.getTweetDate());
		assertEquals(likes, tweet.getLikes());
		assertEquals(comments, tweet.getComments());
	}
}
