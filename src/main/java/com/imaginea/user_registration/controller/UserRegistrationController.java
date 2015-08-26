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
 * Created by maninders on 25/8/15.
 */

@Path("/registration")
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService = new UserRegistrationService();
    static final Logger log = Logger.getLogger(UserRegistrationController.class);

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

    @POST
    @Path("/delete-user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,Object> deleteUser(int userId){
        try {
            userRegistrationService.deleteUser(userId);
            return getResultMap("",Constant.OK,"");
        } catch (SQLException e) {
            log.error("SQLException : " + e);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException : " + e);
        }
        return getResultMap(UIMessageConstant.DELETE_USER_MSG,Constant.FAIL,"");
    }

    public Map<String,Object> getResultMap(String message,String status,Object data){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put(Constant.DATA,data);
        resultMap.put(Constant.MESSAGE,message);
        resultMap.put(Constant.STATUS,status);
        return resultMap;
    }

    /**
     * Test method to check service is working or not
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
