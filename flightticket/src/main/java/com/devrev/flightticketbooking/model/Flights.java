package com.devrev.flightticketbooking.model;

public class Flights {

	int e_seats_left;
	int b_seats_left;
	float e_seat_price;
	float b_seat_price;

	String flightno;
	String from;
	String to;
	String dept_date;
	String arr_date;
	String dept_time;
	String arr_time;
	String flight_company;
	String status;
	

	public Flights(String flightno, String from, String to, String dept_date, String arr_date, String dept_time,
			String arr_time, int e_seats_left, int b_seats_left, float e_seat_price, float b_seat_price,
			String flight_company,String status) {
		super();
		this.flightno = flightno;
		this.from = from;
		this.to = to;
		this.dept_date = dept_date;
		this.arr_date = arr_date;
		this.dept_time = dept_time;
		this.arr_time = arr_time;
		this.e_seats_left = e_seats_left;
		this.b_seats_left = b_seats_left;
		this.e_seat_price = e_seat_price;
		this.b_seat_price = b_seat_price;
		this.flight_company = flight_company;
		this.status=status;
	}

	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDept_date() {
		return dept_date;
	}
	public void setDept_date(String dept_date) {
		this.dept_date = dept_date;
	}
	public String getArr_date() {
		return arr_date;
	}
	public void setArr_date(String arr_date) {
		this.arr_date = arr_date;
	}
	public String getDept_time() {
		return dept_time;
	}
	public void setDept_time(String dept_time) {
		this.dept_time = dept_time;
	}
	public String getArr_time() {
		return arr_time;
	}
	public void setArr_time(String arr_time) {
		this.arr_time = arr_time;
	}
	public int getE_seats_left() {
		return e_seats_left;
	}
	public void setE_seats_left(int e_seats_left) {
		this.e_seats_left = e_seats_left;
	}
	public int getB_seats_left() {
		return b_seats_left;
	}
	public void setB_seats_left(int b_seats_left) {
		this.b_seats_left = b_seats_left;
	}
	public float getE_seat_price() {
		return e_seat_price;
	}
	public void setE_seat_price(float e_seat_price) {
		this.e_seat_price = e_seat_price;
	}
	public float getB_seat_price() {
		return b_seat_price;
	}
	public void setB_seat_price(float b_seat_price) {
		this.b_seat_price = b_seat_price;
	}
	public String getFlight_company() {
		return flight_company;
	}
	public void setFlight_company(String flight_company) {
		this.flight_company = flight_company;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
