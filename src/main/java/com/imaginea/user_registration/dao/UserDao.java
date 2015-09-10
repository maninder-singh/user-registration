package com.imaginea.user_registration.dao;

import com.imaginea.user_registration.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * <h1> UserDao.class</h1>
 * This interface is list of abstract methods 
 * which are implemented in subclasses to perform operations triggered from UI.
 * 
 * @author maninders
 */
public interface UserDao {
	
    /**
     * This method will return list of users persist in DB
     * @return userList
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException;
    
    /**
     * This method will return user details for given userId
     * @param userId
     * @return userObject
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User getUser(int userId) throws SQLException, ClassNotFoundException;
    
    /**
     * This method will insert user details into DB
     * @param user
     * @return insertionFlag
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean insertUser(User user) throws SQLException, ClassNotFoundException;
    
    /**
     * This method will update user details into DB
     * @param user
     * @return updationFlag
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException;
    
    
    /**
     * This method will delete user from DB for given userId
     * @param userId
     * @return deletionFlag
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean deleteUser(int userId) throws SQLException, ClassNotFoundException;
}
