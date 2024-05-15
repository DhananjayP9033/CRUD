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

@WebServlet("/empForm")
public class empForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		System.out.println("This is Username: " + name);
		System.out.println("This is Email: " + email);
		System.out.println("This is Mobile Number: " + mobile);
		
		
		int recordNumber = 1;
		Employee object = new Employee();
		//object.setId(recordNumber);
		object.setName(name);
		object.setEmailId(email);
		object.setMoNumber(mobile);
		
		boolean InsertionResult = userDao.createUser(object);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		
		if(InsertionResult) {
			System.out.println("record instrted in the db");
			request.setAttribute("msg", "Record Inserted.Please click on show record to see updated record list");
			recordNumber++;
			rd.forward(request, response);
			//response.sendRedirect("./index.jsp");
		}else {
			System.out.println("record not inserted in the db");
			request.setAttribute("error", "Not Inserted, Something Wrong!!");
			rd.forward(request, response);
		}
		
	}
}
