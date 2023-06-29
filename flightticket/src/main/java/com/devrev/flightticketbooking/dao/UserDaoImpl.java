package com.devrev.flightticketbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.devrev.flightticketbooking.model.User;

@Service
public class UserDaoImpl implements UserDao {

	@Override
	public boolean validate_User(String username, String password) {

		Connection con = ConnectionHandler.getConnection();
		String query = "select u_username,u_password from user_details where u_username=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (username.equals(rs.getString("u_username"))) {
					if (password.equals(rs.getString("u_password"))) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addUser(String name, String gender, String address, String email_id, String contact, String username,
			String password) {

		Connection con = ConnectionHandler.getConnection();
		String Query = "insert into user_details(u_name,u_gender,u_address,u_email_id,u_contact,u_username,u_password) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setString(3, address);
			stmt.setString(4, email_id);
			stmt.setString(5, contact);
			stmt.setString(6, username);
			stmt.setString(7, password);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean validateAdmin(String username, String password) {

		Connection con = ConnectionHandler.getConnection();
		String Query = "select username,password from admin_credentials where username=?";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (username.equals(rs.getString("username"))) {
					if (password.equals(rs.getString("password"))) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserDetails(String u_username, String u_password) {
		String name, email, contact, gender, address;
		Connection con = ConnectionHandler.getConnection();
		User user = null;
		final String query = "select * from user_details where u_username=? and u_password=?";
		try {

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, u_username);
			stmt.setString(2, u_password);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("u_name");
				email = rs.getString("u_email_id");
				contact = rs.getString("u_contact");
				gender = rs.getString("u_gender");
				address = rs.getString("u_address");
				user = new User(name, gender, address, email, contact, u_username, u_password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void update_UserDetails(String name, String p_contact, String address, String gender, String email_id,
			String password, String username) {
		Connection con = ConnectionHandler.getConnection();
		final String query = "update user_details set u_name= ?,u_email_id= ?,u_contact = ?, u_gender=?,u_address=? where u_username=? and u_password=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, email_id);
			stmt.setString(3, p_contact);
			stmt.setString(4, gender);
			stmt.setString(5, address);
			stmt.setString(6, username);
			stmt.setString(7, password);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
