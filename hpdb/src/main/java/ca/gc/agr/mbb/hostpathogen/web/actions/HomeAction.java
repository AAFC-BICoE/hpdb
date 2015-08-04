package ca.gc.agr.mbb.hostpathogen.web.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;  

public class HomeAction implements Action {  
	private int id;  
	private String firstName;  
	private String lastName;  
	private String email;  
	private String phone;  

	public int getId() {  
		return id;  
	}  

	public void setId(int id) {  
		this.id = id;  
	}  

	public String getFirstName() {  
		return firstName;  
	}  

	public void setFirstName(String firstName) {  
		this.firstName = firstName;  
	}  

	public String getLastName() {  
		return lastName;  
	}  

	public void setLastName(String lastName) {  
		this.lastName = lastName;  
	}  

	public String getEmail() {  
		return email;  
	}  

	public void setEmail(String email) {  
		this.email = email;  
	}  

	public String getPhone() {  
		return phone;  
	}  

	public void setPhone(String phone) {  
		this.phone = phone;  
	}  

	public String execute() {  
		return "SUCCESS";  
	}  

	public String getDetail(){  
		return SUCCESS;  
	}   
}  