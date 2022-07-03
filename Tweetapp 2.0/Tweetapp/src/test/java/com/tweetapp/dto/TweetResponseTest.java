package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TweetResponseTest {

	private TweetResponse response = new TweetResponse();

	// Testing of setter methods

	@Test
	public void setTweetIdTest() {
		response.setTweetId("M00456");
		assertEquals("M00456", response.getTweetId());
	}

	@Test
	public void setUsernameTest() {
		response.setUsername("admin09");
		assertEquals("admin09", response.getUsername());
	}

	@Test
	public void setTweetTextTest() {
		response.setTweetText("Good Morning guys!");
		assertEquals("Good Morning guys!", response.getTweetText());
	}

	@Test
	public void setFirstNameTest() {
		response.setFirstName("Subham");
		assertEquals("Subham", response.getFirstName());
	}

	@Test
	public void setLastNameTest() {
		response.setLastName("Bairagya");
		assertEquals("Bairagya", response.getLastName());
	}

	@Test
	public void setTweetDateTest() {
		response.setTweetDate("06/26/2022");
		assertEquals("06/26/2022", response.getTweetDate());
	}

	@Test
	public void setLikesCountTest() {
		response.setLikesCount(99);
		assertEquals((Object) 99, (Object) response.getLikesCount());
	}

	@Test
	public void setCommentsCountTest() {
		response.setCommentsCount(45);
		assertEquals((Object) 45, (Object) response.getCommentsCount());
	}

	@Test
	public void setLikeStatusTest() {
		response.setLikeStatus(false);
		assertFalse(response.getLikeStatus());
	}

	@Test
	public void setCommentsTest() {
		List<Comment> commentList = new ArrayList<Comment>();
		response.setComments(commentList);
		assertEquals(commentList, response.getComments());
	}

	// Testing of getter methods

	@Test
	public void getTweetIdTest() {
		response.setTweetId("S22337");
		assertEquals("S22337", response.getTweetId());
	}

	@Test
	public void getUsernameTest() {
		response.setUsername("admin087");
		assertEquals("admin087", response.getUsername());
	}

	@Test
	public void getTweetTextTest() {
		response.setTweetText("Watching Spiderman!");
		assertEquals("Watching Spiderman!", response.getTweetText());
	}

	@Test
	public void getFirstNameTest() {
		response.setFirstName("Subham");
		assertEquals("Subham", response.getFirstName());
	}

	@Test
	public void getLastNameTest() {
		response.setLastName("Bairagya");
		assertEquals("Bairagya", response.getLastName());
	}

	@Test
	public void getTweetDateTest() {
		response.setTweetDate("06/23/2021");
		assertEquals("06/23/2021", response.getTweetDate());
	}

	@Test
	public void getLikesCountTest() {
		response.setLikesCount(67);
		assertEquals((Object) 67, (Object) response.getLikesCount());
	}

	@Test
	public void getCommentsCountTest() {
		response.setCommentsCount(22);
		assertEquals((Object) 22, (Object) response.getCommentsCount());
	}

	@Test
	public void getLikeStatusTest() {
		response.setLikeStatus(true);
		assertTrue(response.getLikeStatus());
	}

	@Test
	public void getCommentsTest() {
		List<Comment> commentList = new ArrayList<Comment>();
		response.setComments(commentList);
		assertEquals(commentList, response.getComments());
	}

	// Testing Constructor

	@Test
	public void constructorTest() {
		List<Comment> comments = new ArrayList<>();
		TweetResponse response = new TweetResponse(
				"abc1234",
				"user556",
				"Oh my god!",
				"Subham",
				"Bairagya",
				"05/12/2022",
				50,
				20,
				true,
				comments);
		assertEquals("abc1234", response.getTweetId());
		assertEquals("user556", response.getUsername());
		assertEquals("Oh my god!", response.getTweetText());
		assertEquals("Subham", response.getFirstName());
		assertEquals("Bairagya", response.getLastName());
		assertEquals("05/12/2022", response.getTweetDate());
		assertEquals((Object) 50, (Object) response.getLikesCount());
		assertEquals((Object) 20, (Object) response.getCommentsCount());
		assertTrue(response.getLikeStatus());
		assertEquals(comments, response.getComments());
	}
}
