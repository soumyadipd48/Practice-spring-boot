package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TweetUpdateTest {

	private TweetUpdate update = new TweetUpdate();

	// Testing of setter methods

	@Test
	public void setTweetIdTest() {
		update.setTweetId("PPXY127");
		assertEquals("PPXY127", update.getTweetId());
	}

	@Test
	public void setTweetTextTest() {
		update.setTweetText("Good Night!");
		assertEquals("Good Night!", update.getTweetText());
	}

	// Testing of getter methods

	@Test
	public void getTweetIdTest() {
		update.setTweetId("MNOP333");
		assertEquals("MNOP333", update.getTweetId());
	}

	@Test
	public void getTweetTextTest() {
		update.setTweetText("Good Evening!");
		assertEquals("Good Evening!", update.getTweetText());
	}
	
	//Testing Constructor
	
	@Test
	public void constructorTest() {
		TweetUpdate update = new TweetUpdate("ZXC4452", "Hello Sir");
		assertEquals("ZXC4452", update.getTweetId());
		assertEquals("Hello Sir", update.getTweetText());
	}

}
