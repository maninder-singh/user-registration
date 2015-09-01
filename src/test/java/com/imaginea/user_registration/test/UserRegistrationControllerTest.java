package com.imaginea.user_registration.test;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserRegistrationControllerTest {
	private static Client client;
	private static WebResource service;
	private static Logger logger = Logger.getLogger(UserRegistrationControllerTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		client = Client.create(new DefaultClientConfig());
		service = client.resource(getBaseURI());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		client = null;
		service = null;
	}
	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).path("user-registration/rest/registration").build();
    }
	@Test
	public final void testGetAllUsers() {
	        ClientResponse resp = service.path("get-all-users")
	                .accept(MediaType.APPLICATION_JSON)
	                .get(ClientResponse.class);
	        logger.info("Got stuff: " + resp);
	        String text = resp.getEntity(String.class);
	        assertEquals(200, resp.getStatus());
	        logger.info("The out put entity details : "+text);
	}

	@Test
	public final void testGetUser() {
		ClientResponse resp = service.path("get-user/2")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        logger.info("Got stuff: " + resp);
        String text = resp.getEntity(String.class);
        assertEquals(200, resp.getStatus());
        logger.info("The out put entity details : "+text);
    }

	@Test
	public final void testInsertUser() {
		JSONObject jsonObject=getUserJsonObject(false);
		ClientResponse resp = service.path("add-user")
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class,jsonObject);
        logger.info("Got stuff: " + resp);
        assertEquals(200, resp.getStatus());
   }

	@Test
	public final void testUpdateUser() {
		JSONObject updateUserJson = getUserJsonObject(true);
		ClientResponse resp = service.path("update-user")
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class,updateUserJson);
        System.out.println("Got stuff: " + resp);
        assertEquals(200, resp.getStatus());
        String text = resp.getEntity(String.class);
        System.out.println(text);
		
	}
	@Ignore
	@Test
	public final void testDeleteUser() {
		ClientResponse resp = service.path("delete-user/10")
				.accept(MediaType.APPLICATION_JSON)
				.delete(ClientResponse.class);
		System.out.println("Got Stuff"+resp);
		assertEquals(200, resp.getStatus());
		
	}

	
	private static JSONObject getUserJsonObject(boolean isToUpdate){
		JSONObject jsonObject = new JSONObject();
		try {
			if(isToUpdate){
				jsonObject.put("userId", new Integer(1));
				jsonObject.put("firstName", "update userName");
				jsonObject.put("middleName", "update midleName");
				jsonObject.put("lastName","update lastName");
				jsonObject.put("email", "update@update.com");
			}else{
				jsonObject.put("firstName", "insert firstName");
				jsonObject.put("middleName", "insert midleName");
				jsonObject.put("lastName","insert lastName");
				jsonObject.put("email", "insert@inset.com");
			}	
			jsonObject.put("address", "Roas colony");
			jsonObject.put("city", "Hyderbad");
			jsonObject.put("state", "Telangana");
			jsonObject.put("zip", "500056");
			
		} catch (JSONException e) {
			logger.error("Exception Details : "+e.getMessage());
		}
		return jsonObject;
	}
}
