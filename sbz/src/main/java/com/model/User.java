package com.model;

public class User {
	private String firstname;
	private String lastname;	
	private String licenceId;
	private String username;
	private String password;	
	private String type;
	public User(String firstname, String lastname, String licenceId, String username, String password, String type) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.licenceId = licenceId;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLicenceId() {
		return licenceId;
	}
	public void setLicenceId(String licenceId) {
		this.licenceId = licenceId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User(){}
}
