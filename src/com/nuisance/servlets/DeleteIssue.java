package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nuisance.dao.IssueDao;

/**
 * Servlet implementation class DeleteIssue
 */
@WebServlet("/DeleteIssue")
public class DeleteIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Edit your issue Form</title>");
		pw.println("</head>");
		pw.println("<body>");
		int x=Integer.parseInt(request.getParameter("issue_id"));
        if(IssueDao.delete(x)==1)
        		pw.println("<h3>issue deleted</h3>");
        else
    		pw.println("<h3>failed</h3>");
		pw.println("</body>");
		pw.print("</html>");

	}


}
