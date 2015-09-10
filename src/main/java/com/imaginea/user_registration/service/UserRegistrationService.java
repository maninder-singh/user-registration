package com.imaginea.user_registration.service;

import com.imaginea.user_registration.dao.UserDao;
import com.imaginea.user_registration.dao.UserDaoImpl;
import com.imaginea.user_registration.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1> UserRegistrationService.class </h1>
 * This class is service class to process request 
 * and forward to Implementation layer.
 * 
 * @author maninders
 */
public class UserRegistrationService {

    private static UserDao userDao = new UserDaoImpl();

    /**
     * This method is to get all users, which are persist in DB
     * @return User's List
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDao.getAllUsers();
    }

    /**
     * This method is to get User Object for given user id.
     * @param userId
     * @return User Object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User getUser(int userId) throws SQLException, ClassNotFoundException {
        return userDao.getUser(userId);
    }

    /**
     * This method is to insert user into DB.
     * @param user
     * @throws SQLException
     * @throws ClassNotFoundException
     * @return boolean 
     */
    public boolean insertUser(User user) throws SQLException, ClassNotFoundException {
        return userDao.insertUser(user);
        
    }

    /**
     * This method is to update user details in DB.
     * @param user
     * @throws SQLException
     * @throws ClassNotFoundException
     * @return boolean
     */
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
       return userDao.updateUser(user);
    }

    /**
     * This method is to delete user from DB for given user Id.
     * @param userId
     * @throws SQLException
     * @throws ClassNotFoundException
     * @return boolean
     */
    public boolean deleteUser(int userId) throws SQLException, ClassNotFoundException {
      return  userDao.deleteUser(userId);
    }

    /**
     * This method is to test application with dummy data.
     * @return User's List
     */
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setUserId(1);
        user.setFirstName("maninder");
        user.setMiddleName("");
        user.setLastName("singh");
        user.setAddress("delhi");
        user.setState("delhi");
        user.setCountry("india");
        user.setZip("500034");
        user.setEmail("tst@test.com");
        userList.add(user);
        return userList;
    }
}
