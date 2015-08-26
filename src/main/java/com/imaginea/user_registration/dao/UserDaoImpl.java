package com.imaginea.user_registration.dao;

import com.imaginea.user_registration.pojo.User;
import com.imaginea.user_registration.util.JdbcWrapperUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maninders on 25/8/15.
 */
public class UserDaoImpl implements UserDao {

    static final Logger log = Logger.getLogger(UserDaoImpl.class);
    private static final String USER_ID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String LAST_NAME = "last_name";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String COUNTRY = "country";
    private static final String ZIP = "zip";
    private static final String EMAIL = "email";

    public UserDaoImpl(){}

    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<User>();
        User user;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcWrapperUtil.getConnection();
            statement = connection.createStatement();
            log.info("GET_ALL_USER_QUERY : " + Constant.GET_ALL_USER_QUERY);
            resultSet = statement.executeQuery(Constant.GET_ALL_USER_QUERY);

            while (resultSet.next()){
                user = new User();
                user.setUserId(resultSet.getInt(USER_ID));
                user.setFirstName(resultSet.getString(FIRST_NAME));
                user.setMiddleName(resultSet.getString(MIDDLE_NAME));
                user.setLastName(resultSet.getString(LAST_NAME));
                user.setAddress(resultSet.getString(ADDRESS));
                user.setCity(resultSet.getString(CITY));
                user.setState(resultSet.getString(STATE));
                user.setCountry(resultSet.getString(COUNTRY));
                user.setZip(resultSet.getString(ZIP));
                user.setEmail(resultSet.getString(EMAIL));
                userList.add(user);
            }
            return userList;
        }finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

//        List<User> userList = new ArrayList<User>();
//        User user = new User();
//        user.setUserId(1);
//        user.setFirstName("maninder");
//        user.setMiddleName("");
//        user.setLastName("singh");
//        user.setAddress("delhi");
//        user.setState("delhi");
//        user.setCountry("india");
//        user.setZip("500034");
//        user.setEmail("tst@test.com");
//        userList.add(user);
//        user = new User();
//        user.setUserId(1);
//        user.setFirstName("ashok");
//        user.setMiddleName("");
//        user.setLastName("c");
//        user.setAddress("hyderabad");
//        user.setState("delhi");
//        user.setCountry("india");
//        user.setZip("500034");
//        user.setEmail("tst@test.com");
//        userList.add(user);
//        return userList;
    }

    @Override
    public User getUser(int userId) throws SQLException, ClassNotFoundException {
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = JdbcWrapperUtil.getConnection();
            statement = connection.prepareStatement(Constant.GET_USER_QUERY);
            statement.setInt(1, userId);
            statement.setMaxRows(1);
            resultSet = statement.executeQuery();
            log.info("GET_USER_QUERY : " + statement.toString());
            while (resultSet.next()){
                user.setUserId(resultSet.getInt(USER_ID));
                user.setFirstName(resultSet.getString(FIRST_NAME));
                user.setMiddleName(resultSet.getString(MIDDLE_NAME));
                user.setLastName(resultSet.getString(LAST_NAME));
                user.setAddress(resultSet.getString(ADDRESS));
                user.setCity(resultSet.getString(CITY));
                user.setState(resultSet.getString(STATE));
                user.setCountry(resultSet.getString(COUNTRY));
                user.setZip(resultSet.getString(ZIP));
                user.setEmail(resultSet.getString(EMAIL));
            }
            return user;
        }finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int updatedRowCount = 0;
        try{
            connection = JdbcWrapperUtil.getConnection();
            statement = connection.prepareStatement(Constant.UPDATE_USER_QUERY);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getMiddleName());
            statement.setString(3,user.getLastName());
            statement.setString(4,user.getAddress());
            statement.setString(5, user.getCity());
            statement.setString(6,user.getState());
            statement.setString(7,user.getCountry());
            statement.setString(8,user.getZip());
            statement.setString(9,user.getEmail());
            statement.setInt(10, user.getUserId());
            log.info("UPDATE_USER_QUERY : " + statement.toString());
            updatedRowCount = statement.executeUpdate();
            log.info("Number of rows updated : " + updatedRowCount);
        }finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int insertRowCount = 0;
        try{
            connection = JdbcWrapperUtil.getConnection();
            statement = connection.prepareStatement(Constant.INSERT_USER_QUERY);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getMiddleName());
            statement.setString(3,user.getLastName());
            statement.setString(4,user.getAddress());
            statement.setString(5, user.getCity());
            statement.setString(6,user.getState());
            statement.setString(7,user.getCountry());
            statement.setString(8,user.getZip());
            statement.setString(9,user.getEmail());
            log.info("INSERT_USER_QUERY : " + statement.toString());
            insertRowCount = statement.executeUpdate();
            log.info("New row inserted : " + insertRowCount);
        }finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcWrapperUtil.getConnection();
            statement = connection.prepareStatement(Constant.DELETE_USER_QUERY);
            statement.setInt(1,userId);
            log.info("DELETE_USER_QUERY : " + statement.toString());
            statement.execute();
        }finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
