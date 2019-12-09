package com.nuisance.bean;

public class AdminBean {
	private String username,password;
	private int adminID;
	public AdminBean() {
		super();
	}
	
	public AdminBean(String username,String password,int adminID) {
		super();
		this.adminID=adminID;
		this.password=password;
		this.username=username;
	}
	

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
