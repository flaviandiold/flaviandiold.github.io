package com.devrev.flightticketbooking.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.devrev.flightticketbooking.model.Bookings;

public interface BookingsDao {

	public ArrayList<Bookings> showUserBookings(String pnr);

	public ArrayList<Bookings> showAdminBookings();

	public void cancelBooking(String name, String pnr, String cclass, String flightno);

	public double addPassenger(String p_fno, String p_from, String p_to, Date p_dedate, Date p_ardate, String p_detime,
			String p_artime, String p_status, String p_name, String p_age, String p_sex, String p_class, String pnr,
			String p_email, double cost);

	public void addTopnrCostData(String pnr_no, String cost);

}
