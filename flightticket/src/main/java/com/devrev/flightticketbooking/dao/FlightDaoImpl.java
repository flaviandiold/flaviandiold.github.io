package com.devrev.flightticketbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.devrev.flightticketbooking.model.Flights;

@Service
public class FlightDaoImpl implements FlightDao {

	@Override
	public void addFlight(String flightno, String from, String to, String dept_date, String arr_date, String dept_time,
			String arr_time, int e_seats_left, int b_seats_left, float e_seat_price, float b_seat_price,
			String flight_company, String status) {

		Connection con = ConnectionHandler.getConnection();
		String query = "insert into flight_details(flightno,from_city,to_city,departure_date,arrival_date,"
				+ "departure_time,arrival_time,e_seats_left,b_seats_left,e_price,b_price,flight_company,status)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, flightno);
			stmt.setString(2, from);
			stmt.setString(3, to);
			stmt.setString(4, dept_date);
			stmt.setString(5, arr_date);
			stmt.setString(6, dept_time);
			stmt.setString(7, arr_time);
			stmt.setInt(8, e_seats_left);
			stmt.setInt(9, b_seats_left);
			stmt.setFloat(10, e_seat_price);
			stmt.setFloat(11, b_seat_price);
			stmt.setString(12, flight_company);
			stmt.setString(13, status);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Flights> getFlight_details() {
		ArrayList<Flights> Flights_list = new ArrayList<Flights>();
		final String query = "select * from flight_details";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String flightno = rs.getString("flightno");
				String from = rs.getString("from_city");
				String to = rs.getString("to_city");
				String dept_date = rs.getString("departure_date");
				String arr_date = rs.getString("arrival_date");
				String dept_time = rs.getString("departure_time");
				String arr_time = rs.getString("arrival_time");
				int e_seats_left = rs.getInt("e_seats_left");
				int b_seats_left = rs.getInt("b_seats_left");
				float e_seat_price = rs.getFloat("e_price");
				float b_seat_price = rs.getFloat("b_price");
				String flight_company = rs.getString("flight_company");
				String status = rs.getString("status");
				Flights flight = new Flights(flightno, from, to, dept_date, arr_date, dept_time, arr_time, e_seats_left,
						b_seats_left, e_seat_price, b_seat_price, flight_company, status);
				Flights_list.add(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Flights_list;
	}

	@Override
	public Flights getFlight(String flightno) {
		Connection con = ConnectionHandler.getConnection();
		Flights flight = null;
		final String query = "select * from flight_details where flightno=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, flightno);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String from = rs.getString("from_city");
				String to = rs.getString("to_city");
				String dept_date = rs.getString("departure_date");
				String arr_date = rs.getString("arrival_date");
				String dept_time = rs.getString("departure_time");
				String arr_time = rs.getString("arrival_time");
				int e_seats_left = rs.getInt("e_seats_left");
				int b_seats_left = rs.getInt("b_seats_left");
				float e_seat_price = rs.getFloat("e_price");
				float b_seat_price = rs.getFloat("b_price");
				String flight_company = rs.getString("flight_company");
				String status = rs.getString("status");
				flight = new Flights(flightno, from, to, dept_date, arr_date, dept_time, arr_time, e_seats_left,
						b_seats_left, e_seat_price, b_seat_price, flight_company, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flight;
	}

	public void updateFlight(Flights flight) {
		String separator = ",";
		Connection con = ConnectionHandler.getConnection();
		final String query = "update flight_details set from_city= ?,to_city= ?,departure_date = ?, "
				+ "arrival_date=?,departure_time=?,arrival_time=?,e_seats_left=?,b_seats_left=?,e_price=?,"
				+ "b_price=?,flight_company=?,status=? where flightno = ?";
		try {
			String flightnumber = flight.getFlightno();
			int sepPos = flightnumber.indexOf(separator);
			String flightno = flightnumber.substring(sepPos + separator.length());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, flight.getFrom());
			stmt.setString(2, flight.getTo());
			stmt.setString(3, flight.getDept_date());
			stmt.setString(4, flight.getArr_date());
			stmt.setString(5, flight.getDept_time());
			stmt.setString(6, flight.getArr_time());
			stmt.setInt(7, flight.getE_seats_left());
			stmt.setInt(8, flight.getB_seats_left());
			stmt.setFloat(9, flight.getE_seat_price());
			stmt.setFloat(10, flight.getB_seat_price());
			stmt.setString(11, flight.getFlight_company());
			stmt.setString(12, flight.getStatus());
			stmt.setString(13, flightno);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFlight(String flightno) {
		Connection con = ConnectionHandler.getConnection();
		String query = "delete from flight_details where flightno = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, flightno);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Flights> getUserFlight_details(String from, String to, String departure) {
		ArrayList<Flights> Flights_list = new ArrayList<Flights>();
		final String query = "select flightno,from_city,to_city,departure_date,arrival_date,departure_time,"
				+ "arrival_time,e_seats_left,b_seats_left,e_price,b_price,flight_company,status "
				+ "from flight_details where from_city=? and to_city=? and departure_date=?";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, from);
			stmt.setString(2, to);
			stmt.setString(3, departure);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String flightno = rs.getString("flightno");
				String from1 = rs.getString("from_city");
				String to1 = rs.getString("to_city");
				String dept_date = rs.getString("departure_date");
				String arr_date = rs.getString("arrival_date");
				String dept_time = rs.getString("departure_time");
				String arr_time = rs.getString("arrival_time");
				int e_seats_left = rs.getInt("e_seats_left");
				int b_seats_left = rs.getInt("b_seats_left");
				float e_seat_price = rs.getFloat("e_price");
				float b_seat_price = rs.getFloat("b_price");
				String flight_company = rs.getString("flight_company");
				String status = rs.getString("status");
				Flights flight = new Flights(flightno, from1, to1, dept_date, arr_date, dept_time, arr_time,
						e_seats_left, b_seats_left, e_seat_price, b_seat_price, flight_company, status);
				Flights_list.add(flight);
				System.out.println("Sent");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Flights_list;
	}

}