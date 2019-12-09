package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.dao.UserDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int uid;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("</head>");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(UserDao.authenticate(username, password)){
			uid=UserDao.getUid(username,password);
			HttpSession session=request.getSession();
			session.setAttribute("user","true");

			request.getRequestDispatcher("UserPanel.html").include(request, response);
			
		}else{
			request.setAttribute("message","invalid username or password");
			request.getRequestDispatcher("UserLogin.jsp").include(request, response);
			
		}
		out.println("</body>");
		out.println("</html>");
	}


}
