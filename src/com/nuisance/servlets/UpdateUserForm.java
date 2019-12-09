package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.bean.UserBean;
import com.nuisance.dao.UserDao;

/**
 * Servlet implementation class UpdateUserForm
 */
@WebServlet("/UpdateUserForm")
public class UpdateUserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")=="true") {
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit your profile</title>");
		out.println("</head>");
		out.println("<body background=\"images\\bp2.jpg\">");
		out.println("<center>");
		
		int id=UserLogin.uid;
		
		UserBean bean=UserDao.ViewUserId(id);
		out.println("<form action=\"UpdateUser\" method=\"GET\">");
		out.println("<h1>UPDATE YOUR Profile</h1>");
		out.println("<br><h4>User ID</h4>");
		out.println("<input type=\"text\" name=\"user_id\" value="+bean.getUser_id()+" readonly=\"readonly\"><br>");
		out.println("<h4>Email:</h4>");
		out.println("<input type=\"email\" name=\"email\" value=\""+bean.getEmail()+"\"readonly=\"readonly\"><br>");
		out.println("<h4>Phone No:</h4>");
		out.println("<input type=\"text\" name=\"phno\" value=\""+bean.getPhno()+"\"><br>");
		out.println("<h4>Age</h4>");
		out.println("<input type=\"text\" name=\"age\" value=\""+bean.getAge()+"\"<br>");
		out.println("<h4>Address</h4>");
		out.println("<textarea name=\"address\" cols=\"20\" rows=\"6\">"+bean.getAddress()+"</textarea><br>");
        out.println("<h4>User Name</h4>");
		out.println(" <input type=\"text\" name=\"username\" value=\""+bean.getUsername()+"\"><br>");
		out.println("<h4>Password</h4>");
		out.println(" <input type=\"text\" name=\"password\" value=\""+bean.getPassword()+"\"><br>");
		out.println("<input type=\"submit\" title=\"update\">");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	}

}
