package com.Controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userDao;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("variable1"));
		System.out.println("this is the id of user to delete : " + id);
		
		
		boolean deletionResult = userDao.deleteUser(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		if(deletionResult) {
			System.out.println("record deleted from the db");
			request.setAttribute("msg", "Record Deleted. Please click on show record to see updated records list");
			rd.forward(request, response);
		}else {
			System.out.println("record not deleted from the db");
			request.setAttribute("error", "Not Deleted, Something Wrong!!");
			rd.forward(request, response);
		}
	}

}
