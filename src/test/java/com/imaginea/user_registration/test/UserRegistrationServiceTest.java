package com.imaginea.user_registration.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.imaginea.user_registration.pojo.User;
import com.imaginea.user_registration.service.UserRegistrationService;

public class UserRegistrationServiceTest {
	private static UserRegistrationService userRegService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userRegService = new UserRegistrationService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userRegService = null;
	}

	@Test
	public final void testGetAllUsers() {
		try {
			List<User> userList = userRegService.getAllUsers();
			assertTrue(userList != null && userList.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	@Test
	public final void testGetUser() {
		try {
			Object object = userRegService.getUser(1);
			assertTrue(object != null && object instanceof User);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	@Test
	public final void testInsertUser() {
		User newUser = new User();
		newUser.setUserId(1);
		newUser.setFirstName("ashok");
		newUser.setMiddleName("kumar");
		newUser.setLastName("Chelimilla");
		newUser.setAddress("Dilsuknagar");
		newUser.setCity("Hyderabad");
		newUser.setState("Telangana");
		newUser.setCountry("india");
		newUser.setZip("500042");
		newUser.setEmail("ask@ask.com");
		try {
			assertTrue(userRegService.insertUser(newUser));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public final void testUpdateUser() {
		User existingUser = new User();
		existingUser.setUserId(4);
		existingUser.setFirstName("ashokUpadte");
		existingUser.setMiddleName("kumar");
		existingUser.setLastName("Chelimilla");
		existingUser.setAddress("Dilsuknagar");
		existingUser.setCity("Hyderabad Update");
		existingUser.setState("Telangana");
		existingUser.setCountry("india");
		existingUser.setZip("500042");
		existingUser.setEmail("ask@ask.com");
		try {
			assertTrue(userRegService.updateUser(existingUser));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public final void testDeleteUser() {
		try {
			boolean isUserDeleted = userRegService.deleteUser(6);
			assertTrue(isUserDeleted);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
