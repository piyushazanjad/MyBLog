package org.piyusha.website.blog.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.piyusha.website.blog.model.Blog;
import org.piyusha.website.blog.service.BlogService;

@Path("/blogs")
public class BlogResource {
	
	BlogService blogService = new BlogService();
	
	@GET
	@Path("/getblogs")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Blog> getBlogs(){
		return blogService.getAllBlogs();
	}
	
	@POST
	@Path("/postblogs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Blog postBlogs(Blog blog) throws Exception{
		//System.out.println("Function called postblogs");
		
			return blogService.postBlogs(blog);
		
		
	}
}