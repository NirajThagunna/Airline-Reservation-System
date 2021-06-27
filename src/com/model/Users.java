package com.model;

// to model users in the database use the POJO

public class Users {

	private int id;
	private String userName;
	private String email;
	private String password;
	private String confirmPass;

	public Users() {
	}

	public Users(int id) {
		this.id = id;
	}
	
	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Users(String userName, String email, String password, String confirmPass) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPass = confirmPass;
	}
	
	public Users(int id, String userName, String email, String password, String confirmPass) {
		this(userName, email, password, confirmPass);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

}
