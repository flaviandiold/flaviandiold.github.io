package com.devrev.flightticketbooking.model;

public class Admin {

	String username;
	String password;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

}