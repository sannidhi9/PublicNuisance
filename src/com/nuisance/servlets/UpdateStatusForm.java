package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuisance.bean.AuthorityBean;
import com.nuisance.bean.StatusBean;
import com.nuisance.dao.AuthDao;
import com.nuisance.dao.StatusDao;

/**
 * Servlet implementation class UpdateStatusForm
 */
@WebServlet("/UpdateStatusForm")
public class UpdateStatusForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
		PrintWriter out=response.getWriter();
HttpSession session=request.getSession();
		
		if(session.getAttribute("auth")=="true") {
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit your issue Form</title>");
		out.println("</head>");
		out.println("<body background=\"images\\bp2.jpg\">");
		out.println("<center>");
		int id=Authlogin.aid;
		AuthorityBean abean =new AuthorityBean();
		abean=AuthDao.ViewAuthId(id);
		List<StatusBean>list=StatusDao.ViewAuthStatus(abean.getArea_code(),abean.getAuthority_type());
		for(StatusBean bean:list){
		out.println("<form action=\"UpdateStatus\" method=\"GET\">");
		out.println("<h1>UPDATE ISSUE PROGRESS</h1>");
		out.println("<br><h4>USER ID</h4>");
		out.println("<input type=\"text\" name=\"user_id\" value="+bean.getUser_id()+" readonly=\"readonly\"><br>");
		out.println("<h4>Issue ID</h4>");
		out.println("<input type=\"text\" name=\"issue_id\" value="+bean.getIssue_id()+" readonly=\"readonly\"><br><br>");
		
		out.println("<h4>Status</h4>");
		out.println("<input type=\"text\" name=\"status\" value=\""+bean.getStatus()+"\"><br>");
		out.println("<h4>Issue Type</h4>");
		out.println("<input type=\"text\" name=\"issue_type\" value="+bean.getIssue_type()+" readonly=\"readonly\"><br><br>");
		out.println("<h4>Concerned Authority</h4>");
		out.println("<input type=\"text\" name=\"concerned_authority\" value="+bean.getConcerned_authority()+" readonly=\"readonly\"><br><br>");
		out.println("<h4>Username</h4>");
		out.println("<input type=\"text\" name=\"username\" value="+bean.getUsername()+" readonly=\"readonly\"><br><br>");
		
		out.println("<h4>Area Code</h4>");
		out.println("<input type=\"text\" name=\"area_code\" value=\""+bean.getArea_code()+"\" readonly=\"readonly\"><br><br>");
		out.println("<input type=\"submit\" value=\"update\">");
		out.println("</form>");
		}
		out.println("<center>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

 }
}
