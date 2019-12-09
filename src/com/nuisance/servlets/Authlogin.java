package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.dao.AuthDao;


/**
 * Servlet implementation class Authlogin
 */
@WebServlet("/Authlogin")
public class Authlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int aid;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("</head>");
		if(AuthDao.authenticate(username, password)){
			aid=AuthDao.getAid(username,password);
			HttpSession session=request.getSession();
			session.setAttribute("auth","true");
            request.getRequestDispatcher("AuthPanel.html").include(request, response);
			
		}else{
			request.setAttribute("message","invalid username or password");
			request.getRequestDispatcher("AuthLogin.jsp").include(request, response);
			
		}
		out.println("</body>");
		out.println("</html>");	
	}
	
	}

