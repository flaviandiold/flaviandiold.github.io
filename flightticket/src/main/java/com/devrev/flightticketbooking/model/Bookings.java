package com.devrev.flightticketbooking.model;

import java.sql.Date;

public class Bookings {

	int p_seatno;
	int p_id;

	String p_age;
	String p_fno;
	String p_from;
	String p_to;
	String p_detime;
	String p_artime;
	String p_status;
	String p_class;
	String p_email;
	String p_sex;
	String p_pnr;
	String p_name;

	Date p_bookingdate;
	Date p_dedate;
	Date p_ardate;

	public Bookings(String name, String flightno, String from, String to, Date dept_date,
			Date arr_date, String dept_time, String arr_time, String cclass, int seatno,
			Date bookingdate, String p_status) {
		super();
		this.p_name = name;
		this.p_fno = flightno;
		this.p_from = from;
		this.p_to = to;
		this.p_dedate = dept_date;
		this.p_ardate = arr_date;
		this.p_detime = dept_time;
		this.p_artime = arr_time;
		this.p_class = cclass;
		this.p_seatno = seatno;
		this.p_bookingdate = bookingdate;
		this.p_status = p_status;
	}

	public Bookings(String p_fno2, String p_from2, String p_to2, Date p_dedate2, Date p_ardate2, String p_detime2,
			String p_artime2, String p_status2, String p_name2, String p_age2, String p_sex2, String p_class2,
			String p_email2) {

		this.p_fno = p_fno2;
		this.p_from = p_from2;
		this.p_to = p_to2;
		this.p_dedate = p_dedate2;
		this.p_ardate = p_ardate2;
		this.p_detime = p_detime2;
		this.p_artime = p_artime2;
		this.p_status = p_status2;
		this.p_name = p_name2;
		this.p_age = p_age2;
		this.p_sex = p_sex2;
		this.p_class = p_class2;
		this.p_email = p_email2;

		// TODO Auto-generated constructor stub
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_fno() {
		return p_fno;
	}

	public void setP_fno(String p_fno) {
		this.p_fno = p_fno;
	}

	public String getP_from() {
		return p_from;
	}

	public void setP_from(String p_from) {
		this.p_from = p_from;
	}

	public String getP_to() {
		return p_to;
	}

	public void setP_to(String p_to) {
		this.p_to = p_to;
	}

	public Date getP_dedate() {
		return p_dedate;
	}

	public void setP_dedate(Date p_dedate) {
		this.p_dedate = p_dedate;
	}

	public Date getP_ardate() {
		return p_ardate;
	}

	public void setP_ardate(Date p_ardate) {
		this.p_ardate = p_ardate;
	}

	public String getP_detime() {
		return p_detime;
	}

	public void setP_detime(String p_detime) {
		this.p_detime = p_detime;
	}

	public String getP_artime() {
		return p_artime;
	}

	public void setP_artime(String p_artime) {
		this.p_artime = p_artime;
	}

	public String getP_class() {
		return p_class;
	}

	public void setP_class(String p_class) {
		this.p_class = p_class;
	}

	public int getP_seatno() {
		return p_seatno;
	}

	public void setP_seatno(int p_seatno) {
		this.p_seatno = p_seatno;
	}

	public Date getP_bookingdate() {
		return p_bookingdate;
	}

	public void setP_bookingdate(Date p_bookingdate) {
		this.p_bookingdate = p_bookingdate;
	}

	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public String toString1() {
		return "Passenger Name=" + p_name + "\n Flight Number="
				+ p_fno + " \n Class="
				+ p_class + "\n Seat Number=" + p_seatno + "\n\n";

	}

	public String toString2() {
		return "\nTravelling From=" + p_from + "\n Destination=" + p_to + "\n Departure Date=" + p_dedate
				+ "\n Arrival Date=" + p_ardate
				+ "\n Departure Time=" + p_detime + "\n Arrival Time=" + p_artime + "\n Booking Status=" + p_status
				+ "\n Booking Date=" + p_bookingdate
				+ "\n\n";
	}

}
