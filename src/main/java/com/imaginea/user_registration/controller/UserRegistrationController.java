package com.imaginea.user_registration.controller;

import com.imaginea.user_registration.constant.Constant;
import com.imaginea.user_registration.constant.UIMessageConstant;
import com.imaginea.user_registration.pojo.User;
import com.imaginea.user_registration.service.UserRegistrationService;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1> UserRegistrationController.class </h1>
 * The UserRegistrationController class is the entry point for Jersey Framework and 
 * rest api will be processed here according to path specified.
 * 
 * @author maninders
 */

@Path("/registration")
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService = new UserRegistrationService();
    static final Logger log = Logger.getLogger(UserRegistrationController.class);

    
    /**
     * This rest api is to get list of all users 
     * @return userMap
     */
    @GET
    @Path("/get-all-users")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> getAllUsers(){
        List<User> userList = new ArrayList<User>();
        try{
            userList = userRegistrationService.getAllUsers();
            return getResultMap("",Constant.OK,userList);
        }catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException : " + e);
        } catch (SQLException e) {
            log.error("SQLException : " + e);
        }
        return getResultMap(UIMessageConstant.GET_ALL_USER_MSG,Constant.FAIL,"");
    }

    /**
     * This rest api is to get details about user
     * @param userId
     * @return userMap
     */
    @GET
    @Path("/get-user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> getUser(@PathParam("userId") int userId){
        User user;
        try {
            user = userRegistrationService.getUser(userId);
            return getResultMap("",Constant.OK,user);
        } catch (SQLException e) {
            log.error("SQLException : " + e);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException : " + e);
        }
        return getResultMap(UIMessageConstant.GET_ALL_USER_MSG,Constant.FAIL,"");
    }

    /**
     * This rest api is to insert user details to DB
     * @param user
     * @return userMap
     */
    @POST
    @Path("/add-user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,Object> insertUser(User user) {
        try {
            userRegistrationService.insertUser(user);
            return getResultMap("",Constant.OK,"");
        } catch (SQLException e) {
            log.error("SQLException : " + e);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException : " + e);
        }
        return getResultMap(UIMessageConstant.INSERT_USER_MSG + user.getFirstName() + user.getLastName()
                ,Constant.FAIL,"");
    }

    /**
     * This rest api is to update user details to DB
     * @param user
     * @return userMap
     */
    @POST
    @Path("/update-user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,Object> updateUser(User user){
        try {
            userRegistrationService.updateUser(user);
            return getResultMap("", Constant.OK,"");
        } catch (SQLException e) {
            log.error("SQLException : " + e);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException : " + e);
        }
        return getResultMap(UIMessageConstant.UPDATE_USER_MSG + user.getFirstName() + user.getLastName()
                ,Constant.FAIL,"");
    }

    /**
     * This rest api is to delete user from DB
     * @param userId
     * @return userMap
     */
    @DELETE
    @Path("/delete-user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("userId") int userId){
        try {
            userRegistrationService.deleteUser(userId);
        } catch (SQLException e) {
            log.error("SQLException : " + e);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException : " + e);
        }
    }

    public Map<String,Object> getResultMap(String message,String status,Object data){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put(Constant.DATA,data);
        resultMap.put(Constant.MESSAGE,message);
        resultMap.put(Constant.STATUS,status);
        return resultMap;
    }

    /**
     * This method to check service is working or not
     */
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;
        Map<String ,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("message", output);
        List<String> list = new ArrayList<String>();
        list.add(output);
        list.add(output + "append second time");
        resultMap.put("list", list);
        resultMap.put("service-data",userRegistrationService.getUserList());
        return resultMap;
    }
}
