package com.tweetapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import com.tweetapp.model.UserModel;
import com.tweetapp.repository.UserRepository;

class UserServiceTest {

	@InjectMocks
	UserService service;

	@Mock
	UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void loadUserByUsernameTest() {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");

		when(userRepository.findByUsername("liza112")).thenReturn(user);

		UserDetails userDetails = service.loadUserByUsername("liza112");

		assertNotNull(userDetails);
		assertEquals(user.getUsername(), userDetails.getUsername());
		assertEquals(user.getPassword(), userDetails.getPassword());
	}

}
