package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.bean.IssueBean;
import com.nuisance.dao.IssueDao;

/**
 * Servlet implementation class SearchIssue
 */
@WebServlet("/SearchIssue")
public class SearchIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")=="true") {
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>search issue</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<center>");
		pw.println("<br>");
		pw.println("<h1>ISSUE INFO</h1>");
		pw.println("<br>");
		pw.println("<br>");
		
        IssueBean bean=new IssueBean();
        bean=IssueDao.search(Integer.parseInt(request.getParameter("area_code")),request.getParameter("issue_type"));
        pw.println("<table border=2>");
		pw.println("<h3><tr><th>IssueID</th><th>IssueType</th><th>IssueDescription</th><th>IssueLocation</th><th>ReportDate</th><th>Area Code</th><th>userID</th></tr></h3>");
		pw.println("<h5><tr><td>"+bean.getIssue_id()+"</td><td>"+bean.getIssue_type()+"</td><td>"+bean.getIssue_description()+"</td><td>"+bean.getIssue_location()+"</td><td>"+bean.getReport_date()+"</td><td>"+bean.getArea_code()+"</td><td>"+bean.getUser_id()+"</td></tr></h5>");
		pw.println("</table>");
		pw.println("<form action=\"DeleteIssue\">");
		pw.print("<br><br>enter issueID to delete issue:");
		pw.println("<input type=\"text\" name=\"issue_id\"><br>");
		pw.println("<input type=\"submit\" value=\"DELETE ISSUE\" style=\"background-color:red; border-color:blue; color:white\">");
		pw.println("</form>");
		pw.println("</center>");
		pw.println("</body>");
		pw.print("</html>");


	}
	}

}
