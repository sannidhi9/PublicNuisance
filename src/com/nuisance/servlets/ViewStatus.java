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

import com.nuisance.bean.StatusBean;
import com.nuisance.dao.StatusDao;

/**
 * Servlet implementation class ViewStatus
 */
@WebServlet("/ViewStatus")
public class ViewStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static int uid;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")=="true") {
		uid=UserLogin.uid;
		List<StatusBean> list=StatusDao.ViewStatus(uid);
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>view status</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<center>");
		pw.println("<br>");

		if(list==null) {pw.println("Add issue to see status");}
		pw.println("<h1>VIEW STATUS</h1>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<table border=2>");
		
		pw.println("<h3><tr><th>IssueID</th><th>IssueType</th><th>Status</th><th>Concerned Authority</th><th>Username</th><th>Area Code</th><th>userID</th></tr></h3>");
		for(StatusBean bean:list){
			pw.println("<h5><tr><td>"+bean.getIssue_id()+"</td><td>"+bean.getIssue_type()+"</td><td>"+bean.getStatus()+"</td><td>"+bean.getConcerned_authority()+"</td><td>"+bean.getUsername()+"</td><td>"+bean.getArea_code()+"</td><td>"+bean.getUser_id()+"</td></tr></h5>");
		}
		pw.println("</table>");
		pw.println("</center>");
		pw.println("</body>");
		pw.println("</html>");
	}

	}

}
