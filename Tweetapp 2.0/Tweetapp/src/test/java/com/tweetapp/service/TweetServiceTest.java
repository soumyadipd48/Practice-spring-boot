package com.tweetapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tweetapp.dto.Comment;
import com.tweetapp.dto.Like;
import com.tweetapp.exception.InvalidUsernameException;
import com.tweetapp.exception.TweetDoesNotExistException;
import com.tweetapp.model.Tweet;
import com.tweetapp.repository.TweetRepository;

class TweetServiceTest {

	@InjectMocks
	TweetService service;

	@Mock
	TweetRepository tweetRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getAllTweetsTest() {
		List<Tweet> tweetList = new ArrayList<>();

		Mockito.when(tweetRepository.findAll()).thenReturn(tweetList);

		assertNotNull(service.getAllTweets());
		assertEquals(tweetList, service.getAllTweets());
	}

	@Test
	void getUserTweetsTest() throws InvalidUsernameException {
		List<Tweet> tweets = new ArrayList<>();

		Mockito.when(tweetRepository.findByUsername(anyString())).thenReturn(tweets);

		assertNotNull(service.getUserTweets("liza112", "liza Hayden"));
		assertEquals(tweets, service.getUserTweets("liza112", "liza Hayden"));
	}

	@Test
	void postNewTweetTest() {
		Tweet tweet = new Tweet();

		Mockito.when(tweetRepository.insert(tweet)).thenReturn(tweet);

		assertEquals(tweet, service.postNewTweet("username", tweet));
	}

	@Test
	void getTweetTest() throws TweetDoesNotExistException {
		Optional<Tweet> tweet = Optional.ofNullable(new Tweet());
		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweet);

		assertNotNull(service.getTweet("tweetId", "username"));
	}

	@Test
	void updateTweetTest() throws TweetDoesNotExistException {
		Optional<Tweet> originalTweetOptional = Optional.ofNullable(new Tweet());
		Mockito.when(tweetRepository.findById(anyString())).thenReturn(originalTweetOptional);

		Tweet tweet = originalTweetOptional.get();
		Mockito.when(tweetRepository.save(tweet)).thenReturn(tweet);

		assertEquals(tweet, service.updateTweet("userId", "tweetId", "updatedTweetText"));
	}

	@Test
	void deleteTweetTest() throws TweetDoesNotExistException {
		Mockito.when(tweetRepository.existsById(anyString())).thenReturn(true);
		assertTrue(service.deleteTweet("tweet007239"));
	}

	@Test
	void likeTweetTest() throws TweetDoesNotExistException {
		Optional<Tweet> tweetOptional = Optional.ofNullable(new Tweet());

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweetOptional);

		Tweet actualTweet = tweetOptional.get();

		Mockito.when(tweetRepository.save(actualTweet)).thenReturn(actualTweet);

		assertEquals(actualTweet, service.likeTweet("sampleUsername", "tweet4427"));

	}

	@Test
	void dislikeTweetTest() throws TweetDoesNotExistException {
		Optional<Tweet> tweetOptional = Optional.ofNullable(new Tweet());

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweetOptional);

		Tweet actualTweet = tweetOptional.get();

		Mockito.when(tweetRepository.save(actualTweet)).thenReturn(actualTweet);

		assertEquals(actualTweet, service.dislikeTweet("userSample", "tweet6674"));
	}

	@Test
	void replyTweetTest() throws TweetDoesNotExistException {
		Optional<Tweet> tweetOptional = Optional.ofNullable(new Tweet());

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweetOptional);

		Tweet actualTweet = tweetOptional.get();

		Mockito.when(tweetRepository.save(actualTweet)).thenReturn(actualTweet);

		assertEquals(actualTweet, service.replyTweet("sampleUser", "tweet3387", "I like it"));
	}

	// Testing for all negative conditions

	@Test
	void getUserTweetsTest_when_username_is_blank() {
		List<Tweet> tweets = new ArrayList<>();

		Mockito.when(tweetRepository.findByUsername(anyString())).thenReturn(tweets);

		assertThrows(InvalidUsernameException.class, () -> {
			service.getUserTweets("", "liza Hayden");
		});
	}

	@Test
	void getTweetTest_when_tweet_not_found() {
		Optional<Tweet> tweet = Optional.ofNullable(null);

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweet);

		assertThrows(TweetDoesNotExistException.class, () -> {
			service.getTweet("tweetId", "username");
		});
	}

	@Test
	void updateTweetTest_when_tweet_not_found() {
		Optional<Tweet> originalTweetOptional = Optional.ofNullable(null);
		Mockito.when(tweetRepository.findById(anyString())).thenReturn(originalTweetOptional);

		assertThrows(TweetDoesNotExistException.class, () -> {
			service.updateTweet("userId", "tweetId", "updatedTweetText");
		});
	}

	@Test
	void deleteTweetTest_when_tweetId_is_blank() {
		assertThrows(TweetDoesNotExistException.class, () -> {
			service.deleteTweet("");
		});
	}

	@Test
	void deleteTweetTest_when_tweet_does_not_exist() {
		Mockito.when(tweetRepository.existsById(anyString())).thenReturn(false);
		assertThrows(TweetDoesNotExistException.class, () -> {
			service.deleteTweet("anyTweetId");
		});
	}

	@Test
	void likeTweetTest_when_tweet_not_found() {
		Optional<Tweet> tweetOptional = Optional.ofNullable(null);

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweetOptional);

		assertThrows(TweetDoesNotExistException.class, () -> {
			service.likeTweet("sampleUsername", "tweet4427");
		});
	}

	@Test
	void dislikeTweetTest_when_tweet_not_found() {
		Optional<Tweet> tweetOptional = Optional.ofNullable(null);

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweetOptional);

		assertThrows(TweetDoesNotExistException.class, () -> {
			service.dislikeTweet("userSample", "tweet6674");
		});
	}

	@Test
	void replyTweetTest_when_tweet_not_found() {
		Optional<Tweet> tweetOptional = Optional.ofNullable(null);

		Mockito.when(tweetRepository.findById(anyString())).thenReturn(tweetOptional);

		assertThrows(TweetDoesNotExistException.class, () -> {
			service.replyTweet("sampleUser", "tweet3387", "I like it");
		});
	}
}
