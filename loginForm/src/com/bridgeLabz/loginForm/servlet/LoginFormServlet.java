package com.bridgeLabz.loginForm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeLabz.loginForm.dao.UserDao;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao dao = null;
	private RequestDispatcher dispatcher =null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("LoginForm servlet called");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		dao = new UserDao();
		Boolean result = dao.authUser(email, password);
		
		if(result){
			HttpSession session = request.getSession();
			session.setAttribute("useremail", email );
			response.sendRedirect("welcome");
		}else{
			dispatcher = request.getRequestDispatcher("login");
			request.setAttribute("error", "Invalid Crediantial");
			dispatcher.forward(request, response);
		}
			
		
		
		response.sendRedirect("/Registration");
	}

	
}
