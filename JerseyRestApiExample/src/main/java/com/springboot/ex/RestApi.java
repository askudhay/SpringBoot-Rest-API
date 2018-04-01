package com.springboot.ex;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * REST Controller Class to handle GET and POST requests
 * 
 * @author Udhay
 *
 */
@Path("/welcome")
public class RestApi {
	
	/**
	 * GET method that returns created User
	 * 
	 * @return Response
	 */
	@GET
	@Path("/user")
	public Response greetUser(){		
		return Response.status(200).entity("Hello User").build();
	}
	
	/**
	 * GET method that returns User based on their name passed as Path
	 * variable
	 * 
	 * @return Response
	 */
	@GET
	@Path("/user/Udhay")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(){
		User user = new User();
		user.setId(197927);
		user.setUsername("Udhay.G");
		return user;
	}
	
	/**
	 * POST method that handle adding User
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Path("/user/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setUser(User user){
		System.out.println("This is what I received from Browser " + user);
		 return Response.status(201).entity("Saved successfully !").build();
	}
}
