package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userDao;
import com.model.Employee;

@WebServlet("/findAllUser")
public class findAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			ArrayList<Employee> arr = userDao.getUserList();
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			HttpSession session = request.getSession();
			if (arr != null) {
				session.setAttribute("msg", "Successful");
				session.setAttribute("user-details", arr);
			} else {
				arr = new ArrayList<>();
				session.setAttribute("msg", "Unsuccessful");
				session.setAttribute("user-details", arr);
			}

//			response.sendRedirect("index.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
