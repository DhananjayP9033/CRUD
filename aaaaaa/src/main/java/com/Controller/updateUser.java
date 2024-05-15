package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userDao;
import com.model.Employee;

@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println(" You are in Update user page");
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("username");
		String emailId =request.getParameter("email");
		String mobileNo =request.getParameter("mobile");
		
		Employee object = new Employee();
		object.setId(id);
		object.setName(name);
		object.setEmailId(emailId);
		object.setMoNumber(mobileNo);
		
		boolean UpdateResult = userDao.updateUser(object);
		
		
		if(UpdateResult) {
			System.out.println("Record Updated In The Database Successufully");
			request.setAttribute("msg", "Record Updated. Please click on show record to see updated records");
			rd.forward(request, response);
		}else {
			System.out.println("record not deleted from the db");
			request.setAttribute("error", "Not Deleted, Something Wrong!!");
			rd.forward(request, response);
		}
		
		rd.forward(request, response);
	}

}
