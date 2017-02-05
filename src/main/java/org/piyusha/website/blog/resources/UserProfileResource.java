package org.piyusha.website.blog.resources;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.piyusha.website.blog.model.Blog;
//import org.piyusha.website.blog.model.Blog;
import org.piyusha.website.blog.model.UserProfile;
import org.piyusha.website.blog.service.UserProfileService;



@Path("/userprofile")	
public class UserProfileResource {
	
	UserProfileService userprofileservice = new UserProfileService();
	
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserProfile postUser(UserProfile userprofile) throws Exception{
		//System.out.println("Function called userprofile");
		
			return UserProfileService.postUser(userprofile);
	}
	
	@GET
	@Path("/signin/{username_login}/{password_login}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser(@PathParam("username_login") String username, @PathParam("password_login") String password){
		return userprofileservice.checkUser(username,password);
	}
	
	
	
	
}
