package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuisance.bean.IssueBean;
import com.nuisance.dao.IssueDao;

/**
 * Servlet implementation class UpdateIssue
 */
@WebServlet("/UpdateIssue")
public class UpdateIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Update status</title>");
		pw.println("</head>");
		pw.println("<body>");
	
		String issue_type=request.getParameter("issue_type");
		String issue_description=request.getParameter("issue_description");
		String issue_location=request.getParameter("issue_location");
		String rdate=request.getParameter("report_date");
		Date report_date=Date.valueOf(rdate);
        int user_id=Integer.parseInt(request.getParameter("user_id"));
        int area_code=Integer.parseInt(request.getParameter("area_code"));
        int issue_id=Integer.parseInt(request.getParameter("issue_id"));


		IssueBean bean=new IssueBean(issue_type,issue_description,issue_location,report_date,user_id,area_code);
		if(IssueDao.update(bean,issue_id)==1) {
			pw.println("Updated!!!!");
		}
		else
			pw.println("Update failed :(");
		pw.println("</body>");
		pw.print("</html>");
		
	}


}
