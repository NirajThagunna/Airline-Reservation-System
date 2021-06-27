package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FlightDAO;
import com.dao.PaymentDAO;
import com.dao.UserDAO;
import com.model.Flight;
import com.model.Payment;
import com.model.Users;

/*
 * @Author: Niraj Thagunna
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all the requests from the user.
 */
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// object for the UserDAO class
	private UserDAO userDAO;
	private FlightDAO flightDAO;
	private PaymentDAO paymentDAO;

	// get the database config parameter i.e. init() parameter
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		// call the UserDAO constructor
		userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);

		// call the FlightDAO Constructor
		flightDAO = new FlightDAO(jdbcURL, jdbcUsername, jdbcPassword);
		
		// sent all the initial parameter to the paymentDAO class
		paymentDAO = new PaymentDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();

		try {
			switch (action) {
			case "/signUp":
				signUp(request, response);
				break;

			case "/login":
				login(request, response);
				break;

			case "/logout":
				logout(request, response);
				break;

			case "/addFlight":
				addFlight(request, response);
				break;

			case "/flight":
				flightList(request, response);
				break;

			case "/delete":
				deleteFlight(request, response);
				break;

			case "/update":
				showEditForm(request, response);
				break;

			case "/updateFlight":
				updateFlight(request, response);
				break;

			case "/bookTicket":
				bookTicket(request, response);
				break;

			case "/payment":
				payment(request, response);
				break;
			}
		}
		catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// signUp
	public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		// getting all the parameter value from the client side form
		String userName = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPass = request.getParameter("confirm_pass");

		// Submit all the data to the Users.java Model class
		Users newUser = new Users(userName, email, password, confirmPass);

		// all the fetched data store in the database using UserDAO
		userDAO.insertUser(newUser);

		//		System.out.println("Registration successfully!!!");

		// Creating a session object to show the user about successful registration
		HttpSession session = request.getSession();
		session.setAttribute("alertMsg", userName + ", You have successfully registed!");

		response.sendRedirect("registration.jsp");
	}

	// login
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		// getting the parameters from the client 
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");

		// Call the method to search the data from the database
		Users user = userDAO.selectUser(userName); // returns an object of Users

		// getting the data from the database
		String userName1 = user.getUserName();
		String password1 = user.getPassword();

		//		System.out.println(userName1);
		//		System.out.println(password1);

		// for admin
		if (userName.equals("nirajthagunna") && password.equals("admin123")) {

			// HttpSession
			HttpSession session = request.getSession();
			session.setAttribute("username1", userName);

			response.sendRedirect("admin.jsp");
		}
		else if (userName.equals(userName1) && password.equals(password1)) {
			//			System.out.println("Success!!!");

			// HttpSession for the remembering the user
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);

			//			request.getRequestDispatcher("index.jsp").forward(request, response);

			response.sendRedirect("/AirlineReservationSystem");
		}
		else {
			//			System.out.println("Sorry!!!");
			//			request.getRequestDispatcher("registration.jsp").forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "Sorry ... Invalid username and password!");

			response.sendRedirect("registration.jsp");
		}
	}

	// logout
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting the HttpSession object
		HttpSession session = request.getSession(false);

		// Invalidates this session then unbinds any objects bound to it
		session.invalidate();

		response.sendRedirect("/AirlineReservationSystem");
	}

	// addFlight
	public void addFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		// getting all the data from the admin to insert the data
		String flightNo = request.getParameter("flightNo");
		String flightName = request.getParameter("flightName");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		double travelDuration = Double.parseDouble(request.getParameter("duration"));
		String airportName = request.getParameter("airportName");
		double ticketPrice = Double.parseDouble(request.getParameter("price"));

		// Submit all data to the Flight
		Flight flight = new Flight(flightNo, flightName, from, to, date, time, travelDuration, airportName, ticketPrice);

		// submit all the data to the database
		flightDAO.insertFlight(flight);

		//		System.out.println("Added Flight");

		HttpSession session = request.getSession();
		session.setAttribute("successMsg", "Flight Added Successfully!");

		response.sendRedirect("addFlight.jsp");
	}

	// Flight List
	public void flightList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// List of all the flights
		List<Flight> listFlight = flightDAO.selectAllFlights();

		// sending these data into the flight-list.jsp file
		request.setAttribute("listFlight", listFlight);

		// Request dispatcher to send all the flight data into the flight-list.jsp file
		RequestDispatcher rd = request.getRequestDispatcher("flight-list.jsp");
		rd.forward(request, response);
	}

	// delete flight
	public void deleteFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the flight number which comes from the url
		String flightNo = request.getParameter("flightNo");

		// pass the flightNo to the FloghtDAO
		flightDAO.deleteFlight(flightNo);

		// send the response
		response.sendRedirect("flight");
	}

	// Update the flight form
	public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the flight no
		String flightNo = request.getParameter("flightNo");

		// select the flight details 
		Flight existingFlight = flightDAO.selectFlight(flightNo);

		RequestDispatcher rd = request.getRequestDispatcher("addFlight.jsp");
		request.setAttribute("flight", existingFlight);
		rd.forward(request, response);

		//		HttpSession session = request.getSession();
		//		session.setAttribute("flight", existingFlight);
		//		
		//		response.sendRedirect("addFlight.jsp");
	}

	// Update the flight
	public void updateFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting all the data from the update form to update the data
		String flightNo = request.getParameter("flightNo");
		String flightName = request.getParameter("flightName");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		double travelDuration = Double.parseDouble(request.getParameter("duration"));
		String airportName = request.getParameter("airportName");
		double ticketPrice = Double.parseDouble(request.getParameter("price"));

		// pass all the data to the Flight object
		Flight flight = new Flight(flightNo, flightName, from, to, date, time, travelDuration, airportName, ticketPrice);

		// update the data in the flightDAO
		flightDAO.updateFlight(flight);

		//		boolean msg = flightDAO.updateFlight(flight);
		//		System.out.println(msg);

		// send the response
		HttpSession session = request.getSession();
		session.setAttribute("successMsg", "Flight Updated Successfully!");

		response.sendRedirect("addFlight.jsp");
	}

	public void bookTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the flight number
		String flightNo = request.getParameter("flightNo");

		// Select the flight details
		Flight flightDetails = flightDAO.selectFlight(flightNo);

		RequestDispatcher rd = request.getRequestDispatcher("bookTicket.jsp");
		request.setAttribute("flightData", flightDetails);
		rd.forward(request, response);
	}

	public void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		// getting the payment data
		String cardNo = request.getParameter("cardNo");
		String cardHolderName = request.getParameter("cardHolderName");
		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		String cvvNo = request.getParameter("cvvNo");
		double amtToPay = Double.parseDouble(request.getParameter("amountToPay"));
		
		
		// Payment object to sent data to the database
		Payment payment = new Payment(cardNo, cardHolderName, month, year, cvvNo, amtToPay);
		
		// submit all the data to the database
		paymentDAO.payAmount(payment);

		// if payment success the show the message
		HttpSession session = request.getSession();
		session.setAttribute("successMsg", "Your Payment Successful!");

		response.sendRedirect("bookTicket.jsp");
	}

}







