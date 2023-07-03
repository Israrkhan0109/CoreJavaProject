package in.cdac.domain;

import java.util.Objects;

public class User {
	
	//Fields
	private String name ;
	private String phoneNumber;
	private String emailId;
	private String password;
	
	//parameter-less constructor
	public User() {
		
	}
	
	//parametrized constructor
	public User(String name, String phoneNumber, String emailId,String password) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password= password;
		
	}
	
	

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//toString for formatted output
	@Override
	public String toString() {
		return String.format("%-20s%-15s%-20s",this.name,this.phoneNumber,this.emailId);
	}
	
	
	//hashcode method on phoneNumber
	@Override
	public int hashCode() {
		return Objects.hash(phoneNumber);
	}
	
	
	//equals method on phoneNumber
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(phoneNumber, other.phoneNumber);
	}
	

}
