package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nuisance.dao.UserDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Delete Form</title>");
		pw.println("</head>");
		pw.println("<body>");
		int x=Integer.parseInt(request.getParameter("user_id"));
        if(UserDao.delete(x)==1)
        		pw.println("<h3>user deleted</h3>");
        else
    		pw.println("<h3>failed</h3>");
		pw.println("</body>");
		pw.print("</html>");
	}
}
