package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.bean.IssueBean;
import com.nuisance.dao.IssueDao;

/**
 * Servlet implementation class UpdateIssueForm
 */
@WebServlet("/UpdateIssueForm")
public class UpdateIssueForm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")=="true") {
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit your issue Form</title>");
		out.println("</head>");
		out.println("<body background=\"images\\bp2.jpg\">");
		out.println("<center>");
		
		int id=UserLogin.uid;
		
		List<IssueBean>list=IssueDao.ViewUserIssue(id);
		for(IssueBean bean:list){
		out.println("<form action=\"UpdateIssue\" method=\"GET\">");
		out.println("<h1>UPDATE YOUR ISSUE INFO</h1>");
		out.println("<br><h4>USER ID</h4>");
		out.println("<input type=\"text\" name=\"user_id\" value="+bean.getUser_id()+" readonly=\"readonly\"><br>");
		out.println("<h4>Issue ID</h4>");
		out.println("<input type=\"text\" name=\"issue_id\" value="+bean.getIssue_id()+" readonly=\"readonly\"><br><br>");
		out.println("<select name=\"issue_type\" value=\""+bean.getIssue_type()+"\"");
		out.println("<option value=\"Transport\">TRANSPORT</option><option value=\"Water\">WATER</option><option value=\"Power\">POWER</option><option value=\"Other\">OTHER</option></select><br> ");
		out.println("<h4>DESCRIPTION</h4>");
		out.println("<textarea name=\"issue_description\" cols=\"20\" rows=\"6\">"+bean.getIssue_description()+"</textarea><br>");
		out.println("<h4>ISSUE LOCATION</h4>");
		out.println("<input type=\"text\" name=\"issue_location\" value=\""+bean.getIssue_location()+"\"><br>");
		out.println("<h4>REPORT DATE</h4>");
		out.println(" <input type=\"date\" name=\"report_date\" value=\""+bean.getReport_date()+"\"><br>");
		out.println("<h4>Area Code</h4>");
		out.println("<input type=\"text\" name=\"area_code\" value=\""+bean.getArea_code()+"\"><br>");
		out.println("<input type=\"submit\" value=\"update\">");
		out.println("</form>");
		}
		out.println("</center>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	}
	}

