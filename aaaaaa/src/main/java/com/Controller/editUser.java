package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" You are in edit user page");
		
		RequestDispatcher rd = request.getRequestDispatcher("editFormPage.jsp");
		
		int id = Integer.parseInt(request.getParameter("variable1"));
		String name =request.getParameter("variable2");
		String emailId =request.getParameter("variable3");
		String mobileNo =request.getParameter("variable4");

		request.setAttribute("var1", id);
		request.setAttribute("var2", name);
		request.setAttribute("var3", emailId);
		request.setAttribute("var4", mobileNo);
		
		rd.forward(request, response);
	}

}
