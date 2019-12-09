package com.nuisance.bean;

public class StatusBean {
	private String issue_type,status,concerned_authority,username;
	private int issue_id,area_code,user_id;
	public StatusBean() {
		super();
	}
	public StatusBean(String issue_type, String status, String concerned_authority, String username, int issue_id,int area_code,int user_id) {
		super();
		this.issue_type = issue_type;
		this.status = status;
		this.concerned_authority = concerned_authority;
		this.username = username;
		this.issue_id = issue_id;
		this.user_id = user_id;
		this.area_code = area_code;
	}
	
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getIssue_type() {
		return issue_type;
	}
	
	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConcerned_authority() {
		return concerned_authority;
	}
	public void setConcerned_authority(String concerned_authority) {
		this.concerned_authority = concerned_authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}
	

}
