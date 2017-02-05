package org.piyusha.website.blog.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import org.piyusha.website.blog.model.Blog;

//import com.mysql.cj.api.mysqla.result.Resultset;

//import com.mysql.cj.jdbc.PreparedStatement;

public class BlogService {

	
//	public List<Blog> getAllBlogs(){
//		Blog b1 = new Blog(1L, "Hello World","Piyusha" );
//		Blog b2 = new Blog(2L, "Hello jersey","Niyati" );
//		Blog b3 = new Blog(3L, "Hello jax rs","Dipika" );
//		List<Blog> list = new ArrayList<>();
//		list.add(b1);
//		list.add(b2);
//		list.add(b3);
//		return list;
	//}
	
	
	public Blog postBlogs(Blog blog) throws Exception {
		 Connection con = null;
		    PreparedStatement preparedStatement = null;
		try{
		 String driver = "com.mysql.jdbc.Driver";
		    String connection = "jdbc:mysql://localhost:3306/blogs";
		    String user = "root";
		    String password = "piyu";
		    Class.forName(driver);
		    con = DriverManager.getConnection(connection, user, password);
		    System.out.println("Connection  to database is successful..!!!!!!!!!!");
		    String insertQuery = "insert into blog (id,blog,created,author)" + " values (\""
					+ blog.getId() + "\",\"" + blog.getBlog() + "\",\"" + blog.getCreated() + "\",\""
					+ blog.getAuthor() + "\")";
		   preparedStatement= con.prepareStatement(insertQuery);
		   System.out.println(insertQuery);
		  preparedStatement.executeUpdate();
		
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			preparedStatement.close();
			con.close();
		}
		    
		return blog;
	}

	public ArrayList<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		ArrayList<Blog> blog_list = new ArrayList<>();
		Connection con = null;
	  //  PreparedStatement preparedStatement = null;
	try{
	 String driver = "com.mysql.jdbc.Driver";
	    String connection = "jdbc:mysql://localhost:3306/blogs";
	    String user = "root";
	    String password = "piyu";
	    Class.forName(driver);
	    con = DriverManager.getConnection(connection, user, password);
	    
	    String selectQuery= "select * from blog";
	    
	    Statement st= con.createStatement();
	    
	    ResultSet rs =st.executeQuery(selectQuery);
	     
	    while (rs.next()){
	    Blog blog1 = new Blog();
	   blog1.setAuthor(rs.getString("author")); 
	   blog1.setBlog(rs.getString("blog"));
	   blog1.setCreated(rs.getString("created"));
	   System.out.println(blog1.getAuthor());
	   System.out.println(blog1.getBlog());   
	   blog_list.add(blog1);
	   
	    }
	    
	}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
	   
	
	    
			return blog_list;
	          
	}

	
	
	
}
