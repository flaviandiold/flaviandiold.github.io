package com.devrev.flightticketbooking.service;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrev.flightticketbooking.dao.BookingsDao;
import com.devrev.flightticketbooking.dao.FlightDao;
import com.devrev.flightticketbooking.dao.UserDao;
import com.devrev.flightticketbooking.model.Bookings;
import com.devrev.flightticketbooking.model.Flights;
import com.devrev.flightticketbooking.model.User;
import com.devrev.flightticketbooking.util.DateUtil;

@Service
public class FlightService {

	@Autowired
	FlightDao fdao;

	@Autowired
	BookingsDao bdao;

	@Autowired
	UserDao udao;

	DateUtil date = new DateUtil();
	int seatcount = 0;

	public void addFlight(String flightno, String from, String to, String dept_date, String arr_date, String dept_time,
			String arr_time, int e_seats_left, int b_seats_left, float e_seat_price, float b_seat_price,
			String flight_company, String status) {
		fdao.addFlight(flightno, from, to, dept_date, arr_date, dept_time, arr_time, e_seats_left, b_seats_left,
				e_seat_price, b_seat_price, flight_company, status);

	}

	public ArrayList<Flights> getFlight_details() {

		ArrayList<Flights> Flights_list = fdao.getFlight_details();
		return Flights_list;
	}

	public Flights getFlight(String flightno) {
		Flights flight = fdao.getFlight(flightno);

		return flight;

	}

	public void updateFlight(Flights flight) {
		fdao.updateFlight(flight);
	}

	public void deleteFlight(String flightno) {
		fdao.deleteFlight(flightno);

	}

	public ArrayList<Flights> getUserFlight_details(String from, String to, String departure) {

		ArrayList<Flights> Flights_list = fdao.getUserFlight_details(from, to, departure);
		return Flights_list;
	}

	public double addPassenger(String p_fno, String p_from, String p_to, Date p_dedate, Date p_ardate, String p_detime,
			String p_artime, String p_status, String p_name, String p_age, String p_sex, String p_class, String pnr,
			String p_email, double cost) {
		double totalcost = bdao.addPassenger(p_fno, p_from, p_to, p_dedate, p_ardate, p_detime, p_artime, p_status,
				p_name, p_age, p_sex, p_class, pnr, p_email, cost);
		return totalcost;
	}

	public ArrayList<Bookings> getUserBooking_details(String pnr) throws ParseException {

		ArrayList<Bookings> Booking_list = bdao.showUserBookings(pnr);
		return Booking_list;

	}

	public ArrayList<Bookings> getAdminBooking_details() throws ParseException {

		ArrayList<Bookings> Booking_list = bdao.showAdminBookings();
		return Booking_list;

	}

	public void cancelBooking(String name, String pnr, String p_class, String flightno) {
		bdao.cancelBooking(name, pnr, p_class, flightno);
	}

	public User getUserDetails(String u_username, String u_password) {
		User user = null;
		user = udao.getUserDetails(u_username, u_password);
		return user;

	}

	public void update_UserDetails(String name, String contact, String address, String gender, String email_id,
			String password, String username) {
		udao.update_UserDetails(name, contact, address, gender, email_id, password, username);

	}

}
