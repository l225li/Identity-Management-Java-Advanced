package com.linli.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.linli.datamodel.UserTable;
import com.linli.service.UserService;

public class loginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserTable user = new UserTable();
		user.setUsername(username);
		user.setPassword(password);
		try {
			if (new UserService().validateUser(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("../main.jsp");
			} else {
				response.sendRedirect("../index.jsp");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

}
