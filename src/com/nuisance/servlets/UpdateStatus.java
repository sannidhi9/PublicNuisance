package com.nuisance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuisance.bean.StatusBean;
import com.nuisance.dao.StatusDao;

/**
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
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
		
		String issue_type=request.getParameter("issue_type");
		String concerned_authority=request.getParameter("concerned_authority");
		String status=request.getParameter("status");
		String username=request.getParameter("username");
		
        int user_id=Integer.parseInt(request.getParameter("user_id"));
        int area_code=Integer.parseInt(request.getParameter("area_code"));
        int issue_id=Integer.parseInt(request.getParameter("issue_id"));


		StatusBean bean=new StatusBean(issue_type,status,concerned_authority,username,issue_id,area_code,user_id);
		if(StatusDao.update(bean)==1) {
			pw.println("Updated!!!!!!");
		}
		else
			pw.println("Update failed :(");

		pw.print("</body>");
		pw.print("</html>");

	}


}
