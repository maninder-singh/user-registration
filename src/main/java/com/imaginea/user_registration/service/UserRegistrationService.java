package com.imaginea.user_registration.service;

import com.imaginea.user_registration.dao.UserDao;
import com.imaginea.user_registration.dao.UserDaoImpl;
import com.imaginea.user_registration.pojo.User;

import java.sql.SQLException;
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

    public void deleteUser(User user) throws SQLException, ClassNotFoundException {
        if(userDao == null){
            userDao = new UserDaoImpl();
        }
        userDao.deleteUser(user);
    }
}
