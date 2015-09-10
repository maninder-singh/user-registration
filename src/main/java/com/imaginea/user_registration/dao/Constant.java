package com.imaginea.user_registration.dao;

/**
 * <h1> DBQueryConstants.class</h1>
 * This class represents set of DB queries 
 * which are used to interact with database to perform 
 * CRUD operations.
 * 
 * @author maninders
 */
public class Constant {

    public static final String GET_ALL_USER_QUERY = "select user_id,first_name,middle_name,last_name," +
                    "address,city,state,country,zip,email from user_detail";
//    public static final String GET_USER_QUERY = "select user_id,first_name,middle_name,last_name," +
//                    "address,city,state,country,zip,email from user_detail where user_id = :userId";
//    public static final String UPDATE_USER_QUERY = "update user_detail set " +
//                                        "first_name = :firstName," + "middle_name = :middleName," +
//                                        "last_name = :lastName," + "address= :address," + "city = :city," +
//                                        "state = :state," + "country = :country," + "zip = :zip," + "email = :email " +
//                                        "where " + "user_id = :userId";
//    public static final String DELETE_USER_QUERY = "delete from user_detail where user_id = :userId";

    public static final String GET_USER_QUERY = "select user_id,first_name,middle_name,last_name," +
            "address,city,state,country,zip,email from user_detail where user_id = ? ";
    public static final String INSERT_USER_QUERY = "insert into user_detail (" +
            "first_name,middle_name,last_name,address,city,state,country,zip,email) " +
            "values(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_USER_QUERY = "update user_detail set " +
            "first_name = ?," + "middle_name = ?," + "last_name = ?," + "address= ?," + "city = ?," +
            "state = ?," + "country = ?," + "zip = ?," + "email = ? " +
            "where " + "user_id = ?";
    public static final String DELETE_USER_QUERY = "delete from user_detail where user_id = ?";
}
