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
 * Servlet implementation class InsertUser
 */
@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int phno=Integer.parseInt(request.getParameter("phno"));
		int age=Integer.parseInt(request.getParameter("age"));
		UserBean bean=new UserBean(email,phno,age,address,username,password);
		int i=UserDao.InsertUser(bean);
		if(i>0){
			out.println("ACCOUNT CREATED");
		}
		else {
			out.println("Age limit Violated");
		}
	}



}
