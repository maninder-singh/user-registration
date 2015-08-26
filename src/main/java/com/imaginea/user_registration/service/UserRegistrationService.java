package com.imaginea.user_registration.service;

import com.imaginea.user_registration.dao.UserDao;
import com.imaginea.user_registration.dao.UserDaoImpl;
import com.imaginea.user_registration.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maninders on 25/8/15.
 */
public class UserRegistrationService {

    private UserDao userDao = new UserDaoImpl();

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        return userDao.getAllUsers();
    }

    public User getUser(int userId) throws SQLException, ClassNotFoundException {
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        return userDao.getUser(userId);
    }

    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        userDao.insertUser(user);
    }

    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        userDao.updateUser(user);
    }

    public void deleteUser(int userId) throws SQLException, ClassNotFoundException {
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        userDao.deleteUser(userId);
    }

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
