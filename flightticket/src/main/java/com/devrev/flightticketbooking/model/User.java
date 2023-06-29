package com.devrev.flightticketbooking.model;

public class User {
	
	int u_id;

	String u_name;
	String u_gender;
	String u_address;
	String u_email_id;
	String u_contact;
	String u_username;
	String u_password;
	
	public User(){}
	
			public User( String u_name, String u_gender, String u_address, String u_email_id, String u_contact,
			String u_username, String u_password) {
				super();
				this.u_name = u_name;
				this.u_gender = u_gender;
				this.u_address = u_address;
				this.u_email_id = u_email_id;
				this.u_contact = u_contact;
				this.u_username = u_username;
				this.u_password = u_password;
			}
			public User(String username, String password) {
				this.u_username = username;
				this.u_password = password;			
			}
			public int getU_id() {
				return u_id;
			}
			public void setU_id(int u_id) {
				this.u_id = u_id;
			}
			public String getU_name() {
				return u_name;
			}
			public void setU_name(String u_name) {
				this.u_name = u_name;
			}
			public String getU_gender() {
				return u_gender;
			}
			public void setU_gender(String u_gender) {
				this.u_gender = u_gender;
			}
			public String getU_address() {
				return u_address;
			}
			public void setU_address(String u_address) {
				this.u_address = u_address;
			}
			public String getU_email_id() {
				return u_email_id;
			}
			public void setU_email_id(String u_email_id) {
				this.u_email_id = u_email_id;
			}
			public String getU_contact() {
				return u_contact;
			}
			public void setU_contact(String u_contact) {
				this.u_contact = u_contact;
			}
			public String getU_username() {
				return u_username;
			}
			public void setU_username(String u_username) {
				this.u_username = u_username;
			}
			public String getU_password() {
				return u_password;
			}
			public void setU_password(String u_password) {
				this.u_password = u_password;
			}
		

}
