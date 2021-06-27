package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Payment;

public class PaymentDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public PaymentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public boolean payAmount(Payment payment) throws SQLException {

		// sql query to insert the data into the database
		String sql = "INSERT INTO payment (card_no, name, month, year, cvv_no, amt) VALUES (?, ?, ?, ?, ?, ?)";

		// Connect to the database
		connect();

		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setString(1, payment.getCardNo());
		ps.setString(2, payment.getCardHolderName());
		ps.setInt(3, payment.getMonth());
		ps.setInt(4, payment.getYear());
		ps.setString(5, payment.getCvvNo());
		ps.setDouble(6, payment.getAmtToPay());

		boolean rowInserted = ps.executeUpdate() > 0;

		// Closing the stream
		ps.close();
		disconnect();

		// return 
		return rowInserted;
	}
}
