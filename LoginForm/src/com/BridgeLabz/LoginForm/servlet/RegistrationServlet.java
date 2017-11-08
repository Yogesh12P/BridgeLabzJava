package com.BridgeLabz.LoginForm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BridgeLabz.LoginForm.dao.RegistrationDao;
import com.BridgeLabz.LoginForm.dao.Validate;
import com.BridgeLabz.LoginForm.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validate validate = new Validate();
		RegistrationDao dao = new RegistrationDao();
		System.out.println("registration");
		User newUser = new User(request.getParameter("rFirst_name"), 
				request.getParameter("rLast_name"),
				request.getParameter("rEmail"),
				request.getParameter("rPassword"),
				request.getParameter("rMno"));
		
		String RegErro = validate.validateData(newUser);
		HttpSession session = request.getSession();
		
		
			if(RegErro != null)
			{
				System.out.println(" error found");
				session.setAttribute("Regerror", RegErro);
				request.getRequestDispatcher("registration").forward(request, response);
			}
			else
			{
				session.setAttribute("Regerror", "");
				System.out.println("No Error found");
				if(dao.registerNewUser(newUser))
				{
					System.out.println("Register succefully");
					response.sendRedirect("login");
					}
					else
						{
						System.out.println("Sorry..,Not user registered");
						request.getRequestDispatcher("registration").forward(request, response);;
				}
			}
			
			
		
			/*session.invalidate();
			*/
		
	}
			
			
	

}