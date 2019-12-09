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

import com.nuisance.bean.UserBean;
import com.nuisance.dao.UserDao;

/**
 * Servlet implementation class ViewUser
 */
@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")=="true") {
		List<UserBean> list=UserDao.ViewUser();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>view user</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<center>");
		pw.println("<br>");
		pw.println("<h1>USER INFO</h1>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<table border=2>");

		pw.println("<tr><th>UserID</th><th>Email</th><th>PhoneNo</th><th>Age</th><th>Address</th><th>username</th><th>password</th></tr>");
		for(UserBean bean:list){
			pw.println("<tr><td>"+bean.getUser_id()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPhno()+"</td><td>"+bean.getAge()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getUsername()+"</td><td>"+bean.getPassword()+"</td></tr>");
		}
		pw.println("</table>");
		pw.println("</center>");
		pw.println("</body>");
		pw.println("</html>");
	}
	}
}
