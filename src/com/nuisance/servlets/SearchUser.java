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
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")=="true") {
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>search user</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<center>");
		pw.println("<br>");
		pw.println("<h1>USER INFO</h1>");
		pw.println("<br>");
		pw.println("<br>");
		
        UserBean bean=new UserBean();
        bean=UserDao.search(request.getParameter("username"));
        pw.println("<table border=2>");
		pw.println("<h3><tr><th>UserID</th><th>Email</th><th>PhoneNo</th><th>Age</th><th>Address</th><th>username</th></tr></h3>");
	
        pw.println("<h5><tr><td>"+bean.getUser_id()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPhno()+"</td><td>"+bean.getAge()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getUsername()+"</td></tr></h5>");
		
		pw.println("</table>");
		pw.println("<form action=\"DeleteUser\">");
		pw.print("<br><br>delete user with userID ?:");
		pw.println("<input type=\"text\" name=\"user_id\" value="+bean.getUser_id()+" readonly=\"readonly\"><br>");
		pw.println("<input type=\"submit\" value=\"DELETE USER\" style=\"background-color:red; border-color:blue; color:white\">");
		pw.println("</form>");
		pw.println("</body>");
		pw.print("</html>");
		}
}
}