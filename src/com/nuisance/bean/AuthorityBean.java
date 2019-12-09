package com.nuisance.bean;

public class AuthorityBean {
	private String authority_type,email,authority_name,office_address,username,password;
	private int phoneno,authority_id,area_code;
	public AuthorityBean() {
		super();
	}

	public AuthorityBean(String authority_type,String authority_name,String email,String office_address,int phoneno,String username,String password,int area_code) {
		
		super();
		this.authority_name=authority_name;
		this.authority_type=authority_type;
		this.email=email;
		this.office_address=office_address;
		this.phoneno=phoneno;
		this.username=username;
		this.password=password;
		this.area_code=area_code;
	}
	public int getArea_code() {
		return area_code;
	}

	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}

	public String getAuthority_type() {
		return authority_type;
	}
	public void setAuthority_type(String authority_type) {
		this.authority_type = authority_type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public String getOffice_address() {
		return office_address;
	}
	public void setOffice_address(String office_address) {
		this.office_address = office_address;
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

	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	
}
