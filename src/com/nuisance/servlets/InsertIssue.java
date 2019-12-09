package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.bean.IssueBean;

import com.nuisance.dao.IssueDao;


/**
 * Servlet implementation class InsertIssue
 */
@WebServlet("/InsertIssue")
public class InsertIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")=="true") {
		String issue_type=request.getParameter("issue_type");
		String issue_description=request.getParameter("description");
		String issue_location=request.getParameter("issue_location");
        String report_d=request.getParameter("report_date");
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		Date report_date=Date.valueOf(report_d);
		int area_code=Integer.parseInt(request.getParameter("area_code"));

		
		IssueBean bean=new IssueBean(issue_type,issue_description,issue_location,report_date,user_id,area_code);
		int i=IssueDao.InsertIssue(bean);
		if(i>0){
			out.println("<h3>Book saved successfully</h3>");
		}
	}

	}

}
