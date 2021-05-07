package com.cts.training.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	private Long id;
	@NotEmpty(message="The username field cannot be empty!")
	@Size(min=5 , max=30,message="The username should be minimum of 5 characters")
	private String username;
	@NotBlank(message="The password field cannot be empty")
	private String password;
	@NotEmpty(message="The address field cannot be empty")
	private String address;
	private Long phoneNo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
