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
 * Servlet implementation class SearchAuth
 */
@WebServlet("/SearchAuth")
public class SearchAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")=="true") {
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Search Form</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<center>");
		pw.println("<br>");
		pw.println("<h1>AUTHORITY INFO</h1>");
		pw.println("<br>");
		pw.println("<br>");
		
        AuthorityBean bean=new AuthorityBean();
        bean=AuthDao.search(Integer.parseInt(request.getParameter("area_code")),request.getParameter("authority_type"));
        pw.println("<table border=2>");
		pw.println("<h3><tr><th>authority_type</th><th>AuthorityID</th><th>AuthorityName</th><th>Email</th><th>OfficeAddress</th><th>PhoneNo</th><th>Area Code</th><th>username</th></tr></h3>");
		pw.println("<h5><tr><td>"+bean.getAuthority_type()+"</td><td>"+bean.getAuthority_id()+"</td><td>"+bean.getAuthority_name()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getOffice_address()+"</td><td>"+bean.getPhoneno()+"</td><td>"+bean.getArea_code()+"</td><td>"+bean.getUsername()+"</td></tr></h5>");
		pw.println("</table>");
		pw.println("<form action=\"DeleteAuth\">");
		pw.print("<br><br>delete AuthorityID :");
		pw.println("<input type=\"text\" name=\"authority_id\" value="+bean.getAuthority_id()+" readonly=\"readonly\"><br>");
		pw.println("<input type=\"submit\" value=\"DELETE AUTHORITY\" style=\"background-color:red; border-color:blue; color:white\">");
		pw.println("</form>");
		pw.println("</center>");
		pw.println("</body>");
		pw.print("</html>");

		}
        
        
}
}