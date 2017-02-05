package org.piyusha.website.blog.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.piyusha.website.blog.model.Blog;
import org.piyusha.website.blog.model.UserProfile;

public class UserProfileService {

	public static UserProfile postUser(UserProfile userprofile) throws SQLException {
		 Connection con = null;
		    PreparedStatement preparedStatement = null;
		try{
		 String driver = "com.mysql.jdbc.Driver";
		    String connection = "jdbc:mysql://localhost:3306/blogs";
		    String user = "root";
		    String password = "piyu";
		    Class.forName(driver);
		    con = DriverManager.getConnection(connection, user, password);
		    System.out.println("Connection  to database is successful.");
		    String insertQuery = "insert into user (id,fname,lname,username,password)" + " values ('"
					+ userprofile.getId() + "','" + userprofile.getFname() + "','" + userprofile.getLname() + "','"
					+ userprofile.getUsername() + "','" + userprofile.getPassword() + "')";
		   preparedStatement= con.prepareStatement(insertQuery);
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
		    
		return userprofile;
	}

	

	public String checkUser(String username,String password) {
	
		Connection con = null;
		String result = null;
	    UserProfile userprofile1 = new UserProfile();
	//	ArrayList<UserProfile> up = new ArrayList<>();
		try{
			 String driver = "com.mysql.jdbc.Driver";
			    String connection = "jdbc:mysql://localhost:3306/blogs";
			    String user1 = "root";
			    String password1 = "piyu";
			    String u=null;
			    String p=null;
			    
			    Class.forName(driver);
			    con = DriverManager.getConnection(connection, user1, password1);
			    
			    String selectQuery= "SELECT username, password FROM user where username='"+username+"' and password='"+password+"'";
			    Statement st= con.createStatement();
			    
			    ResultSet rs =st.executeQuery(selectQuery);
			    
//			    if(rs.next()){
//			    	UserProfile userprofile1 = new UserProfile();
//			    	userprofile1.setUsername(rs.getString("username"));
//			    	userprofile1.setPassword(rs.getString("password"));
//			    System.out.println(userprofile1.getUsername());
//			    System.out.println(userprofile1.getPassword());
//			    }
			    
			    if(rs.next()){
			    	 u= rs.getString("username");
			    	 p= rs.getString("password");
			    
			    }
			    
			    
	
			    userprofile1.setUsername(rs.getString("username"));
		    	userprofile1.setPassword(rs.getString("password"));
		    //	up.add(userprofile1);
			    
			    if(u  !=null && p!= null){
			   // if(){
			    	System.out.println("Login Success!");
			    	 
				    //return "Valid user";
			    	result = u;
			    }
			    else{
			    	System.out.println("Invalid user!");
			    	
				    //return "inValid user";
			    	result = "Invalid User";
			    }
			    
			    
			    
			    
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "login";
		return result;
			   
	}
	
	
}
