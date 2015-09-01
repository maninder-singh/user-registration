package com.imaginea.user_registration.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.imaginea.user_registration.dao.UserDao;
import com.imaginea.user_registration.dao.UserDaoImpl;
import com.imaginea.user_registration.pojo.User;

public class UserDaoTest {
	private static UserDao userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDao = new UserDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao = null;
	}

	@Test
	public final void testGetAllUsers() {

		try {
			List<User> userList = userDao.getAllUsers();
			assertTrue(userList != null && userList.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public final void testGetUser() {
		try {
			Object object = userDao.getUser(1);
			assertTrue(object != null && object instanceof User);
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
		existingUser.setState("Telangana");
		existingUser.setCountry("india");
		existingUser.setZip("500042");
		existingUser.setEmail("ask@ask.com");
		try {
			assertTrue(userDao.updateUser(existingUser));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Ignore
	@Test
	public final void testInsertUser() {
		User newUser = new User();
		newUser.setUserId(1);
		newUser.setFirstName("ashok");
		newUser.setMiddleName("kumar");
		newUser.setLastName("Chelimilla");
		newUser.setAddress("Dilsuknagar");
		newUser.setState("Telangana");
		newUser.setCountry("india");
		newUser.setZip("500042");
		newUser.setEmail("ask@ask.com");
		try {
			boolean result = userDao.insertUser(newUser);
			assertTrue(result);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public final void testDeleteUser() {
		try {
			boolean isUserDeleted = userDao.deleteUser(6);
			assertTrue(isUserDeleted);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
