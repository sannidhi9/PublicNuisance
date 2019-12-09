package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuisance.bean.UserBean;
import com.nuisance.dao.UserDao;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
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
		
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int phno=Integer.parseInt(request.getParameter("phno"));
		int age=Integer.parseInt(request.getParameter("age"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
  
		UserBean bean=new UserBean(email,phno,age,address,username,password);
		if(UserDao.update(bean)==1) {
			pw.println("Updated!!!");
		}
		else {pw.println("update failed :(");}
		pw.println("</body>");
		pw.print("</html>");
	}


}
