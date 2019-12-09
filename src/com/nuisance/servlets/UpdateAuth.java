package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuisance.bean.AuthorityBean;
import com.nuisance.dao.AuthDao;

/**
 * Servlet implementation class UpdateAuth
 */
@WebServlet("/UpdateAuth")
public class UpdateAuth extends HttpServlet {
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
		
		String authority_type=request.getParameter("authority_type");
		String authority_name=request.getParameter("authority_name");
		String office_address=request.getParameter("office_address");
		int phoneno=Integer.parseInt(request.getParameter("phoneno"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int area_code=Integer.parseInt(request.getParameter("area_code"));

		AuthorityBean bean=new AuthorityBean(authority_type,authority_name,email,office_address,phoneno,username,password,area_code);
		if(AuthDao.update(bean)==1) {
			pw.println("Updated!!!");
		}
		else {pw.println("Update failed :(");}
		pw.println("</body>");
		pw.print("</html>");
	}


}
