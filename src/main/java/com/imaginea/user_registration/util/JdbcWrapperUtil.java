package com.imaginea.user_registration.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by maninders on 25/8/15.
 */
public class JdbcWrapperUtil {

    static Logger log = Logger.getLogger(JdbcWrapperUtil.class);

    private static final String JDBC_DRIVER = "jdbc-driver";
    private static final String DB_URL = "db-url";
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";

    private static Properties propertyUtil = PropertyUtil.getProperties();
    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        String url = propertyUtil.getProperty(DB_URL).toString();
        String userName = propertyUtil.getProperty(USER_NAME).toString();
        String password = propertyUtil.getProperty(PASSWORD).toString();
        String jdbcDriver = propertyUtil.getProperty(JDBC_DRIVER).toString();

        if(ClassLoader.getSystemClassLoader().getResourceAsStream(jdbcDriver) == null){
            Class.forName(propertyUtil.getProperty(JDBC_DRIVER).toString());
        }
        connection = DriverManager.getConnection(url,userName,password);
        return connection;
    }
}
