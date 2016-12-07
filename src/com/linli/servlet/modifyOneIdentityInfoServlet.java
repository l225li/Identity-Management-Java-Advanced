package com.linli.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linli.datamodel.Identity;
import com.linli.service.IdentityService;

public class modifyOneIdentityInfoServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public modifyOneIdentityInfoServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("UID"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		byte sex = Byte.parseByte(request.getParameter("sex"));
		String email = request.getParameter("email");
		String birthDate = request.getParameter("birthDate");
		
		
		Identity identity = new Identity();
		identity.setUID(id);
		identity.setFirstName(firstName);
		identity.setLastName(lastName);
		identity.setSex(sex);
		identity.setEmail(email);
		identity.setBirthDate(birthDate);
		if(new IdentityService().updateIdentity(identity))
			response.sendRedirect("../modifyIdentity_success.jsp");
		else {
			response.sendRedirect("../modifyOneIdentity.jsp");
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
