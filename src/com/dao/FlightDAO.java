package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Flight;

// Flight DAO to insert the data into the database
public class FlightDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public FlightDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	// get the connection
	// Creating a new connection
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException ex) {
				throw new SQLException(ex);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	// Close the connection
	// disconnect() the connection
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	// Inserting the data into the database
	public boolean insertFlight(Flight flight) throws SQLException {
		
		// sql query to insert the data into the database
		String sql = "INSERT INTO flight (flight_no, flight_name, flight_from, flight_to, date, time, travel_duration, airport_name, ticket_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Connect to the database
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setString(1, flight.getFlightNo());
		ps.setString(2, flight.getFlightName());
		ps.setString(3, flight.getFrom());
		ps.setString(4, flight.getTo());
		ps.setString(5, flight.getDate());
		ps.setString(6, flight.getTime());
		ps.setDouble(7, flight.getTravelDuration());
		ps.setString(8, flight.getAirportName());
		ps.setDouble(9, flight.getTicketPrice());
		
		boolean rowInserted = ps.executeUpdate() > 0;
		
		// Closing the stream
		ps.close();
		disconnect();
		
		// return 
		return rowInserted;
	}
	
	// Selecting all the flight details
	public List<Flight> selectAllFlights() {
		
		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			// Establish a connection to the database
			connect();
			
			// SQL query to select all the users from the database
			String sql = "select * from flight";
			
			// Create a statement using connection object
			PreparedStatement ps = jdbcConnection.prepareStatement(sql);
			
			// Execute the query or update query
			ResultSet rs = ps.executeQuery();
			
			
			// Process the ResultSet object
			while (rs.next()) {
				String flightNO = rs.getString("flight_no");
				String flightName = rs.getString("flight_name");
				String from = rs.getString("flight_from");
				String to = rs.getString("flight_to");
				String date = rs.getString("date");
				String time = rs.getString("time");
				double travelDuration = rs.getDouble("travel_duration");
				String airportName = rs.getString("airport_name");
				double ticketPrice = rs.getDouble("ticket_price");
				
				// Adding all the flight data row by row into the list
				flights.add(new Flight(flightNO, flightName, from, to, date, time, travelDuration, airportName, ticketPrice));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// return flights
		return flights;
	}
	
	// delete the flight
	public boolean deleteFlight(String flightNo) {
		
		boolean rowDeleted = false;
		
		try {
			// Establish a connection
			connect();
			
			// SQL query to delete a flight corresponding to the flightId
			String sql = "delete from flight where flight_no = ?";
			
			// Creating a statement using connection object
			PreparedStatement ps = jdbcConnection.prepareStatement(sql);
			ps.setString(1, flightNo);
			
			rowDeleted = ps.executeUpdate() > 0;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return rowDeleted;
	}
	
	// Update the flight
	public boolean updateFlight(Flight flight) {
		
		boolean rowUpdated = false;
		
		try {
			connect();
			
			String sql = "update flight set flight_name = ?, flight_from = ?, flight_to = ?, date = ?, time = ?, travel_duration = ?, airport_name = ?, ticket_price = ? where flight_no = ?";
			
			PreparedStatement ps = jdbcConnection.prepareStatement(sql);
			
			ps.setString(1, flight.getFlightName());
			ps.setString(2, flight.getFrom());
			ps.setString(3, flight.getTo());
			ps.setString(4, flight.getFrom());
			ps.setString(5, flight.getTime());
			ps.setDouble(6, flight.getTravelDuration());
			ps.setString(7, flight.getAirportName());
			ps.setDouble(8, flight.getTicketPrice());
			ps.setString(9, flight.getFlightNo());
			
			rowUpdated = ps.executeUpdate() > 0;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return rowUpdated;
	}
	
	// select a flight
	public Flight selectFlight(String flightNo) {
		
		// Initializing the flight object
		Flight flight = null;
		
		try {
			connect();
			
			String sql = "select flight_name, flight_from, flight_to, date, time, travel_duration, airport_name, ticket_price from flight where flight_no = ?";
			
			PreparedStatement ps = jdbcConnection.prepareStatement(sql);
			ps.setString(1, flightNo);
			
			// Execute query
			ResultSet rs = ps.executeQuery();
			
			// process the ResultSet Object
			while (rs.next()) {
				String flightName = rs.getString("flight_name");
				String from = rs.getString("flight_from");
				String to = rs.getString("flight_to");
				String date = rs.getString("date");
				String time = rs.getString("time");
				double travelDuration = rs.getDouble("travel_duration");
				String airportName = rs.getString("airport_name");
				double ticketPrice = rs.getDouble("ticket_price");
				
				flight = new Flight(flightNo, flightName, from, to, date, time, travelDuration, airportName, ticketPrice);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return flight;
	}
}



