package com.imaginea.user_registration.controller;

import com.imaginea.user_registration.pojo.User;
import com.imaginea.user_registration.service.UserRegistrationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maninders on 25/8/15.
 */

@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService = new UserRegistrationService();

    @GET
    @Path("/get-all-users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<User>();
        try{
            userList = userRegistrationService.getAllUsers();
        }catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
        return userList;
    }

    @GET
    @Path("/get-user/{userId}")
    public User getUser(@PathParam("userId") int userId){
        User user = new User();
        try {
            user = userRegistrationService.getUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    @POST
    @Path("/add-user")
    public void insertUser(@PathParam("user") User user) {
        try {
            userRegistrationService.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @PUT
    @Path("/update-user")
    public void updateUser(@PathParam("user") User user){
        try {
            userRegistrationService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/delete-user")
    public void deleteUser(@PathParam("user") User user){
        try {
            userRegistrationService.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
