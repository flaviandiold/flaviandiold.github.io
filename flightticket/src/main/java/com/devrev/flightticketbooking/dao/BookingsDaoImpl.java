package com.devrev.flightticketbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.devrev.flightticketbooking.model.Bookings;

@Service
public class BookingsDaoImpl implements BookingsDao {

	double cost = 0.0;
	int seatcount = 0;

	@Override
	public double addPassenger(String p_fno, String p_from, String p_to, Date p_dedate, Date p_ardate, String p_detime,
			String p_artime, String p_status, String p_name, String p_age, String p_sex, String p_class, String pnr,
			String p_email, double cost) {

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String todaysDate = simpleDateFormat.format(new java.util.Date());
		String separator = ",";
		Connection con = ConnectionHandler.getConnection();
		String Query = "insert into passenger_details(p_pnr,p_name,p_age,p_sex,p_fno,p_from,p_to,p_dedate,p_ardate,p_detime,p_artime,p_status,p_class,p_seatno,p_email,p_bookingdate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			int sepPos = pnr.indexOf(separator);
			String pnrno = pnr.substring(sepPos + separator.length());
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, pnrno);
			stmt.setString(2, p_name);
			stmt.setString(3, p_age);
			stmt.setString(4, p_sex);
			stmt.setString(5, p_fno);
			stmt.setString(6, p_from);
			stmt.setString(7, p_to);
			stmt.setDate(8, p_dedate);
			stmt.setDate(9, p_ardate);
			stmt.setString(10, p_detime);
			stmt.setString(11, p_artime);
			stmt.setString(12, "booked");
			stmt.setString(13, p_class);
			if (p_class.equals("Economy")) {
				final String seatcountquery = "select e_seats_left,e_price from flight_details where flightno=?";

				try {
					PreparedStatement stmtcount = con.prepareStatement(seatcountquery);
					stmtcount.setString(1, p_fno);
					ResultSet rs = stmtcount.executeQuery();
					while (rs.next()) {
						seatcount = rs.getInt("e_seats_left");
						if (seatcount <= 0) {
							return 0;
						}
						cost = rs.getFloat("e_price");
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

			} else {
				final String seatcountquery = "select b_seats_left,b_price from flight_details where flightno=?";

				try {
					PreparedStatement stmtcount = con.prepareStatement(seatcountquery);
					stmtcount.setString(1, p_fno);
					ResultSet rs = stmtcount.executeQuery();
					while (rs.next()) {
						seatcount = rs.getInt("b_seats_left");
						if (seatcount <= 0) {
							return 0;
						}
						cost = rs.getFloat("b_price");

					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

			stmt.setInt(14, seatcount);
			stmt.setString(15, p_email);
			stmt.setString(16, todaysDate);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (p_class.equals("Economy")) {

			final String seatupdatequery = "update flight_details set e_seats_left=e_seats_left-1 where flightno=?";// set

			try {
				System.out.println(p_fno);
				PreparedStatement stmt = con.prepareStatement(seatupdatequery);
				stmt.setString(1, p_fno);

				stmt.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {

			final String seatupdatequery = "update flight_details set b_seats_left=b_seats_left-1 where flightno = ?";

			try {

				PreparedStatement stmt = con.prepareStatement(seatupdatequery);
				stmt.setString(1, p_fno);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cost;
	}

	@Override
	public ArrayList<Bookings> showUserBookings(String pnr) {

		ArrayList<Bookings> Booking_list = new ArrayList<Bookings>();

		final String query = "select p_fno,p_name,p_from,p_to,p_dedate,p_ardate,p_detime,p_artime,p_seatno,p_bookingdate,p_class,p_status from passenger_details where p_pnr=?";

		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, pnr);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				String flightno = rs.getString("p_fno");
				String name = rs.getString("p_name");
				String from = rs.getString("p_from");
				String to = rs.getString("p_to");
				Date dept_date = rs.getDate("p_dedate");
				Date arr_date = rs.getDate("p_ardate");
				String dept_time = rs.getString("p_detime");
				String arr_time = rs.getString("p_artime");
				String cclass = rs.getString("p_class");
				int seatno = rs.getInt("p_seatno");
				Date bookingdate = rs.getDate("p_bookingdate");
				String p_status = rs.getString("p_status");

				Bookings booking = new Bookings(name, flightno, from, to, dept_date, arr_date, dept_time, arr_time,
						cclass, seatno, bookingdate, p_status);
				Booking_list.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Booking_list;
	}

	@Override
	public ArrayList<Bookings> showAdminBookings() {

		ArrayList<Bookings> Booking_list = new ArrayList<Bookings>();

		final String query = "select p_fno,p_name,p_from,p_to,p_dedate,p_ardate,p_detime,p_artime,p_seatno,p_bookingdate,p_class,p_status from passenger_details";

		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				String flightno = rs.getString("p_fno");
				String name = rs.getString("p_name");
				String from = rs.getString("p_from");
				String to = rs.getString("p_to");
				Date dept_date = rs.getDate("p_dedate");
				Date arr_date = rs.getDate("p_ardate");
				String dept_time = rs.getString("p_detime");
				String arr_time = rs.getString("p_artime");
				String cclass = rs.getString("p_class");
				int seatno = rs.getInt("p_seatno");
				Date bookingdate = rs.getDate("p_bookingdate");
				String p_status = rs.getString("p_status");

				Bookings booking = new Bookings(name, flightno, from, to, dept_date, arr_date, dept_time, arr_time,
						cclass, seatno, bookingdate, p_status);
				Booking_list.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Booking_list;
	}

	@Override
	public void cancelBooking(String name, String pnr, String cclass, String flightno) {

		final String update_query = "update passenger_details set p_status=? where p_name=? and p_pnr=?";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(update_query);
			stmt.setString(1, "cancelled");
			stmt.setString(2, name);
			stmt.setString(3, pnr);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		final String seatupdate;
		try {
			if (cclass.equals("Economy")) {

				seatupdate = "update flight_details set e_seats_left=e_seats_left+1 where flightno=?";

				PreparedStatement stmt = con.prepareStatement(seatupdate);
				stmt.setString(1, flightno);
				stmt.executeUpdate();
			} else {
				seatupdate = "update flight_details set b_seats_left=b_seats_left+1 where flightno=?";

				PreparedStatement stmt = con.prepareStatement(seatupdate);
				stmt.setString(1, flightno);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addTopnrCostData(String pnr_no, String cost) {

		Connection con = ConnectionHandler.getConnection();
		String Query = "insert into pnr(pnr_no,total_amount) values (?,?)";

		try {

			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, pnr_no);
			stmt.setString(2, cost);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
