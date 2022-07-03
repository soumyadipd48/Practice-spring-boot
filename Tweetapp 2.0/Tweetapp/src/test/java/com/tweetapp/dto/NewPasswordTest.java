package com.tweetapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NewPasswordTest {

	private NewPassword newPassword = new NewPassword();
	
	//Testing of setter methods
	
	@Test
	public void setNewPasswordTest() {
		newPassword.setNewPassword("zxcvbnm0");
		assertEquals("zxcvbnm0", newPassword.getNewPassword());
	}
	
	@Test
	public void setContactTest() {
		newPassword.setContact("admin29");
		assertEquals("admin29", newPassword.getContact());
	}
	
	//Testing of getter methods
	
	@Test
	public void getNewPasswordTest() {
		newPassword.setNewPassword("AzzOOxxx77");
		assertEquals("AzzOOxxx77", newPassword.getNewPassword());
	}
		
	@Test
	public void getContactTest() {
		newPassword.setContact("user37");
		assertEquals("user37", newPassword.getContact());
	}

	//Testing Constructor
	
	@Test
	public void constructorTest() {
		NewPassword newPassword = new NewPassword("asdfghjkl", "Jack");
		assertEquals("asdfghjkl", newPassword.getNewPassword());
		assertEquals("Jack", newPassword.getContact());
	}
}
