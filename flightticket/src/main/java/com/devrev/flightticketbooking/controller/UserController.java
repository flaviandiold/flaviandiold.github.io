package com.devrev.flightticketbooking.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devrev.flightticketbooking.model.Bookings;
import com.devrev.flightticketbooking.model.Flights;
import com.devrev.flightticketbooking.model.User;
import com.devrev.flightticketbooking.service.FlightService;
import com.devrev.flightticketbooking.service.LoginService;

@SessionAttributes({ "user" })
@Controller
public class UserController {
	@Autowired
	FlightService fservice;
	@Autowired
	LoginService service;

	double cost = 0.0;
	User userdata;
	ArrayList<Flights> Flight_list = new ArrayList<Flights>();
	ArrayList<Bookings> Booking_list = new ArrayList<Bookings>();

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user_register")
	public String showRegisterationPage(@ModelAttribute("user") User user, BindingResult result) {
		return "user_register";
	}

	@PostMapping("/user_register")
	public String addUserData(@RequestParam String u_name, @RequestParam String u_gender,
			@RequestParam String u_address, @RequestParam String u_email_id, @RequestParam String u_contact,
			@RequestParam String u_username, @RequestParam String u_password, ModelMap model,
			@ModelAttribute("user") User user, BindingResult result) {
		LOGGER.info("Start");
		service.addUser(u_name, u_gender, u_address, u_email_id, u_contact, u_username, u_password);
		model.addAttribute("message", "Your registration is successful.Use your credentials for login!");
		LOGGER.info("End");
		return "welcome";
	}

	@GetMapping("/user_login")
	public String showUserLogin(@ModelAttribute("user") User user, BindingResult result) {
		return "user_login";
	}

	@PostMapping("/user_login")
	public String validateUser(@RequestParam String u_username, @RequestParam String u_password, ModelMap model) {

		userdata = new User(u_username, u_password);
		userdata.setU_username(u_username);
		userdata.setU_password(u_password);

		boolean isValidUser = service.validateUser(u_username, u_password);

		if (isValidUser) {
			model.put("username", u_username);
			return "user_rights";
		} else {
			model.addAttribute("message", "Wrong Credentials. Please try again!");
			return "user_login";
		}
	}

	@GetMapping("/user_rights")
	public String showUserRights(@SessionAttribute("user") User user, ModelMap model) {
		return "user_rights";

	}

	@ModelAttribute("user")
	public User populateForm() {
		return new User();
	}

	@GetMapping("/user_search_flight")
	public String showSearch_Flight(@SessionAttribute("user") User user, ModelMap model) {
		return "user_search_flight";
	}

	@PostMapping("/user_search_flight")
	public ArrayList<Flights> showFlightsSearched(@RequestParam String from, @RequestParam String to,
			@RequestParam String dept_date, ModelMap model, @SessionAttribute("user") User user) {
		LOGGER.info("Start");
		model.addAttribute("Flight_list", fservice.getUserFlight_details(from, to, dept_date));
		model.addAttribute("FlightNumber", "Flight Number");
		model.addAttribute("From", "From");
		model.addAttribute("To", "To");
		model.addAttribute("DepartureDate", "Departure Date");
		model.addAttribute("ArrivalDate", "Arrival Date");
		model.addAttribute("DepartureTime", "Departure Time");
		model.addAttribute("ArrivalTime", "Arrival Time");
		model.addAttribute("EconomySeatsAvailable", "Economy Seats Available");
		model.addAttribute("BusinessSeatsAvailable", "Business Seats Available");
		model.addAttribute("EconomySeatPrice", "Economy Seat Price");
		model.addAttribute("BusinessSeatPrice", "Bussiness Seats Price");
		model.addAttribute("FlightCompany", "Flight Company");
		model.addAttribute("Action", "Action");
		String pnr = from + to + Integer.toString((((int) (Math.random() * 100000)) % 1000));
		model.addAttribute("pnr", pnr);
		LOGGER.info("End");

		return Flight_list;
	}

	@GetMapping("/user_book_flight")
	public String showBookingPage(@ModelAttribute("flight") Flights flight, BindingResult result,
			@SessionAttribute("user") User user, ModelMap model) {
		return "user_book_flight";
	}

	@PostMapping("/user_book_flight")
	public String addPassenger(@RequestParam String p_fno, @RequestParam String p_from, @RequestParam String p_to,
			@RequestParam Date p_dedate, @RequestParam Date p_ardate, @RequestParam String p_detime,
			@RequestParam String p_artime, @RequestParam String p_status, @RequestParam String p_name,
			@RequestParam String p_age, @RequestParam String p_sex, @RequestParam String p_class,
			@RequestParam String pnr, @RequestParam String p_email, @RequestParam(defaultValue = "0") double cost,
			@ModelAttribute("flight") Flights flight, BindingResult result, @SessionAttribute("user") User user,
			ModelMap model) {

		LOGGER.info("Start");
		double totalcost = fservice.addPassenger(p_fno, p_from, p_to, p_dedate, p_ardate, p_detime, p_artime, p_status,
				p_name, p_age, p_sex, p_class, pnr, p_email, cost);
		if (totalcost == 0) {
			model.addAttribute("message", "Not enough seats left please check the seats avalaible");
		} else {
			model.addAttribute("cost", cost + totalcost);
		}
		LOGGER.info("End");
		return "user_book_flight";

	}

	@GetMapping("/user_bookings")
	public String showSearchBookings(@SessionAttribute("user") User user, ModelMap model) {
		return "user_bookings";

	}

	@PostMapping("/user_bookings")
	public ArrayList<Bookings> showUserBookings(@RequestParam String pnr, @SessionAttribute("user") User user,
			ModelMap model) throws ParseException {
		LOGGER.info("Start");
		model.addAttribute("Booking_list", fservice.getUserBooking_details(pnr));
		model.addAttribute("pnr", pnr);
		model.addAttribute("PassengerName", "Passenger Name");
		model.addAttribute("FlightNo", "Flight Number");
		model.addAttribute("From", "From");
		model.addAttribute("To", "To");
		model.addAttribute("DepartureDate", "Departure Date");
		model.addAttribute("ArrivalDate", "Arrival Date");
		model.addAttribute("DepartureTime", "Departure Time");
		model.addAttribute("ArrivalTime", "Arrival Time");
		model.addAttribute("Class", "Class");
		model.addAttribute("SeatNumber", "Seat Number");
		model.addAttribute("Action", "Action");
		LOGGER.info("End");
		return Booking_list;

	}

	@GetMapping("/cancel_ticket")
	public String showCancelBooking(@SessionAttribute("user") User user, ModelMap model) {
		return "cancel_ticket";
	}

	@PostMapping("/cancel_ticket")
	public String cancelUserBookings(@RequestParam String pnr, @RequestParam String p_name,
			@RequestParam String p_class, @RequestParam String flightno, ModelMap model,
			@SessionAttribute("user") User user) throws ParseException {
		LOGGER.info("Start");
		fservice.cancelBooking(p_name, pnr, p_class, flightno);
		model.addAttribute("Update_success", "Airticket has been successfully cancelled");
		LOGGER.info("End");
		return "user_rights";
	}

	@GetMapping("/show_user_details")
	public String showUserDetails(ModelMap model, @SessionAttribute("user") User user) {
		LOGGER.info("Start");
		System.out.println(userdata.getU_username());
		User user1 = fservice.getUserDetails(userdata.getU_username(), userdata.getU_password());
		model.addAttribute("name", user1.getU_name());
		model.addAttribute("address", user1.getU_address());
		model.addAttribute("email", user1.getU_email_id());
		model.addAttribute("contact", user1.getU_contact());
		model.addAttribute("gender", user1.getU_gender());
		model.addAttribute("username", user1.getU_username());
		model.addAttribute("password", user1.getU_password());
		LOGGER.info("End");
		return "show_user_details";

	}

	@PostMapping("/show_user_details")
	public String saveUpdatedDetails(@RequestParam String name, @RequestParam String contact,
			@RequestParam String address, @RequestParam String gender, @RequestParam String email_id,
			@RequestParam String password, @RequestParam String username, ModelMap model,
			@SessionAttribute("user") User user) {

		LOGGER.info("Start");
		fservice.update_UserDetails(name, contact, address, gender, email_id, password, username);
		model.addAttribute("Update_success", "Your details are updated successfully!");
		LOGGER.info("End");
		return "user_rights";

	}

	@GetMapping("/user_edit_details")
	public String showEditDetailsForm(@SessionAttribute("user") User user, ModelMap model) {

		return "user_edit_details";

	}

	@GetMapping("/confirm_payment")

	public ArrayList<Bookings> showConfirmPayment(@RequestParam String pnr_no, @RequestParam double cost,
			ModelMap model, @SessionAttribute("user") User user) throws ParseException {

		LOGGER.info("Start");
		model.addAttribute("Booking_list", fservice.getUserBooking_details(pnr_no));
		model.addAttribute("pnr_no", pnr_no);
		model.addAttribute("cost", cost);
		LOGGER.info("End");
		return Booking_list;

	}

	@PostMapping("/confirm_payment")
	public String confirmAndSendMail(@RequestParam String pnr_no, @RequestParam String cost, ModelMap model,
			@SessionAttribute("user") User user) {

		LOGGER.info("Start");
		model.addAttribute("Update_success", "Ticket Booked Successfully!You can check in Manage Bookings.");
		LOGGER.info("End");
		return "user_rights";

	}

	@GetMapping("/finish")
	public String logoutUser(@ModelAttribute User user, HttpSession session, SessionStatus status) {

		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}

	@ExceptionHandler(value = Exception.class)
	public String exceptionHandlerGeneric(HttpSession session, RedirectAttributes r) {
		session.invalidate();
		r.addFlashAttribute("message", "Please login first or register if you are a new user");
		return "redirect:/";
	}
}
