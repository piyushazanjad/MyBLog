package org.piyusha.website.blog.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Blog {
	
	
	// Create an instance of SimpleDateFormat used for formatting 
	// the string representation of date (month/day/year)
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	// Get the date today using Calendar object.
	Date today = Calendar.getInstance().getTime();        
	// Using DateFormat format method we can create a string 
	// representation of a date with the defined format.
	private String created = df.format(today);

	// Print what date is today!
	//System.out.println("Report Date: " + reportDate);


	private long id;
	private String blog;
	//private Date created;
	private String author;
	
	public Blog(){
		
		
	}
	
	
	public Blog(long id, String blog ,String created, String author) {
		//super();
		
		
		
		
		this.id = id;
		this.blog = blog;
		this.setCreated(created);
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCreated() {
		return created;
	}


	public void setCreated(String created) {
		this.created = created;
	}
	
	
	
	
}
