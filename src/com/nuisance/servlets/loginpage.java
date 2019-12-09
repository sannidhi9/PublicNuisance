package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.dao.AdminDao;

/**
 * Servlet implementation class loginpage
 */
@WebServlet("/loginpage")
public class loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		if(AdminDao.authenticate(username, password)){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			request.getRequestDispatcher("AdminPanel.html").include(request, response);
			
		}else{
		
		request.setAttribute("message","invalid username or password");
		request.getRequestDispatcher("login.jsp").include(request, response);
		

			
		}
	
		
		}

	
}
