package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.bean.AuthorityBean;
import com.nuisance.dao.AuthDao;

/**
 * Servlet implementation class InsertAuth
 */
@WebServlet("/InsertAuth")
public class InsertAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
	 PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")=="true") {
		String authority_type=request.getParameter("authority_type");
		String authority_name=request.getParameter("authority_name");
		String email=request.getParameter("email");
		String office_address=request.getParameter("office_address");
		int phoneno=Integer.parseInt(request.getParameter("phoneno"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int area_code=Integer.parseInt(request.getParameter("area_code"));


	
		AuthorityBean bean=new AuthorityBean(authority_type,authority_name,email,office_address,phoneno,username,password,area_code);
		int i=AuthDao.InsertAuthority(bean);
		if(i>0){
			out.println("<h3>Book saved successfully</h3>");
		}
 
 }
 }
}

