package com.BridgeLabz.LoginForm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BridgeLabz.LoginForm.dao.ValidateUserDao;
import com.BridgeLabz.LoginForm.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String req1 = request.getParameter("submit");
		String req2 = request.getParameter("registration");
		
		if(req1 != null)
		{
			//get validation
			
			ValidateUserDao dao = new ValidateUserDao();
			
			User user = new User(null, null, request.getParameter("username"), 
					request.getParameter("password"), null);
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			if(dao.validUser(userName, password))
			{
				System.out.println("User is valid");
				
				//set session
				HttpSession session = request.getSession();
				System.out.println("servlet:session created");
				session.setAttribute("user", request.getParameter("username"));
				response.sendRedirect("home");
			}
			else
			{
				System.out.println("User is invalid");
				request.setAttribute("error", "User is invalid");
				request.getRequestDispatcher("login").forward(request, response);;
				
				
			}
			
			
		}
		else if(req2 != null)
		{
			//Go for registration
			response.sendRedirect("registration");
			
		}
	}

}
