package com.nuisance.bean;
import java.sql.Date;
public class IssueBean {
	private String issue_type,issue_description,issue_location;
	private Date report_date;
	private int user_id,issue_id,area_code;
	
	public IssueBean(String issue_type,String issue_description,String issue_location,Date report_date,int user_id,int area_code) {
		super();
		this.issue_description=issue_description;
		this.issue_location=issue_location;
		this.issue_type=issue_type;
		this.report_date=report_date;
		this.user_id=user_id;
		this.area_code=area_code;
	}
	public IssueBean() {
		super();
	}
	
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public String getIssue_type() {
		return issue_type;
	}
	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}
	public String getIssue_description() {
		return issue_description;
	}
	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}
	public String getIssue_location() {
		return issue_location;
	}
	public void setIssue_location(String issue_location) {
		this.issue_location = issue_location;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}

}
