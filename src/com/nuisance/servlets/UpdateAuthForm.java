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
 * Servlet implementation class UpdateAuthForm
 */
@WebServlet("/UpdateAuthForm")
public class UpdateAuthForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
HttpSession session=request.getSession();
		
		if(session.getAttribute("auth")=="true") {
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit your profile</title>");
		out.println("</head>");
		out.println("<body background=\"images\\bp2.jpg\">");
		out.println("<center>");
		
		int id=Authlogin.aid;
		
		AuthorityBean bean=AuthDao.ViewAuthId(id);
		out.println("<form action=\"UpdateAuth\" method=\"GET\">");
		out.println("<h1>UPDATE YOUR Profile</h1>");
		out.println("<h4>Authority ID</h4>");
		out.println("<input type=\"text\" name=\"authority_id\" value="+bean.getAuthority_id()+" readonly=\"readonly\">");
		out.println("<h4>Authority Name</h4>");
		out.println("<input type=\"text\" name=\"authority_name\" value="+bean.getAuthority_name()+" readonly=\"readonly\"><br>");
		out.println("<h4>Authority type</h4>");
		out.println("<select name=\"authority_type\" value=\""+bean.getAuthority_type()+"\"");
		
		out.println("<option value=\"Transport\">TRANSPORT</option><option value=\"Water\">WATER</option><option value=\"Power\">POWER</option><option value=\"Other\">OTHER</option></select><br> ");
		out.println("<h4>Office Address</h4>");
		out.println("<textarea name=\"office_address\" cols=\"50\" rows=\"3\">"+bean.getOffice_address()+"</textarea><br>");
		out.println("<h4>Email:</h4>");
		out.println("<input type=\"email\" name=\"email\" value=\""+bean.getEmail()+"\"readonly=\"readonly\"><br>");
		out.println("<h4>Phone No:</h4>");
		out.println("<input type=\"text\" name=\"phoneno\" value=\""+bean.getPhoneno()+"\"><br>");
		out.println("<h4>Area Code</h4>");
		out.println("<input type=\"text\" name=\"area_code\" value=\""+bean.getArea_code()+"\"><br>");
		out.println("<h4>User Name</h4>");
		out.println(" <input type=\"text\" name=\"username\" value=\""+bean.getUsername()+"\"><br>");
		out.print("<h4>Password</h4>");
		out.print(" <input type=\"text\" name=\"password\" value=\""+bean.getPassword()+"\"><br>");
		out.println("<input type=\"submit\" title=\"update\">");
		out.println("</form>");
		out.println("<center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	}
}
