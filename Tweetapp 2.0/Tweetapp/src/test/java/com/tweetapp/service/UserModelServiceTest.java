package com.tweetapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.anyString;

import com.tweetapp.exception.UsernameAlreadyExists;
import com.tweetapp.model.UserModel;
import com.tweetapp.repository.UserRepository;

class UserModelServiceTest {

	@InjectMocks
	UserModelService service;

	@Mock
	UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void findByUsernameTest() {

		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");

		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(user);

		UserModel actualUser = service.findByUsername("liza112");
		assertNotNull(actualUser);
		assertEquals(user.getFirstName(), actualUser.getFirstName());
		assertEquals(user.getLastName(), actualUser.getLastName());
		assertEquals(user.getEmail(), actualUser.getEmail());
		assertEquals("null", actualUser.getContactNum());
		assertEquals("null", actualUser.getPassword());
		assertEquals(user.getUsername(), actualUser.getUsername());
	}

	@Test
	void createUserTest() throws UsernameAlreadyExists {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");
		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(null);
		Mockito.when(userRepository.save(user)).thenReturn(user);

		UserModel savedUser = service.createUser(user);
		assertNotNull(savedUser);
		assertEquals(user.toString(), savedUser.toString());
	}

	@Test
	void getAllUsersTest() {
		List<UserModel> userModels = new ArrayList<>();

		Mockito.when(userRepository.findAll()).thenReturn(userModels);

		assertNotNull(service.getAllUsers());
	}

	@Test
	void changePasswordTest() throws Exception {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");

		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(user);

		user.setPassword("mnop7890");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		UserModel userAfterChangingPassword = service.changePassword("liza112", "mnop7890", "9123456780");
		assertNotNull(userAfterChangingPassword);
		assertEquals("mnop7890", userAfterChangingPassword.getPassword());
	}

	@Test
	void getUsersByUsernameTest() {
		List<UserModel> userList = new ArrayList<>();
		Mockito.when(userRepository.searchByUsername(anyString())).thenReturn(userList);
		assertEquals(userList, service.getUsersByUsername("liza112"));
	}

	// Testing the negative or Exception conditions

	@Test
	void createUserTest_Username_already_exists() {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");
		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(user);
		Mockito.when(userRepository.save(user)).thenReturn(user);

		assertThrows(UsernameAlreadyExists.class, () -> {
			service.createUser(user);
		});
	}

	@Test
	void changePasswordTest_when_contactNo_is_not_matched() {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");

		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(user);

		user.setPassword("mnop7890");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertThrows(Exception.class, () -> {
			service.changePassword("liza112", "mnop7890", "0000000000");
		});
	}
	
	@Test
	void changePasswordTest_when_username_is_not_matched() {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");

		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(user);

		user.setPassword("mnop7890");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertThrows(Exception.class, () -> {
			service.changePassword("Marc331", "mnop7890", "9123456780");
		});
	}
	
	@Test
	void changePasswordTest_when_usernameAndContact_both_not_matched() {
		UserModel user = new UserModel("liza112", "Liza", "Gupta", "lg112@gmail.com", "9123456780", "abcd1234");

		Mockito.when(userRepository.findByUsername("liza112")).thenReturn(user);

		user.setPassword("mnop7890");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertThrows(Exception.class, () -> {
			service.changePassword("Marc331", "mnop7890", "0000000000");
		});
	}
}
