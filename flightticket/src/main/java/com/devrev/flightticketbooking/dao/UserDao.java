package com.devrev.flightticketbooking.dao;

import com.devrev.flightticketbooking.model.User;

public interface UserDao {

	public boolean validate_User(String username, String password);

	public void addUser(String name, String gender, String address, String email_id, String contact, String username,
			String password);

	public User getUserDetails(String u_username, String u_password);

	public void update_UserDetails(String name, String p_contact, String address, String gender, String email_id,
			String password, String username);

	public boolean validateAdmin(String username, String password);

}
