package com.nuisance.bean;

public class UserBean {
	private String email;
	private int phno,age,user_id;
	private String address,username,password;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String email, int phno, int age, String address, String username, String password) {
		super();
		this.email = email;
		this.phno = phno;
		this.age = age;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
