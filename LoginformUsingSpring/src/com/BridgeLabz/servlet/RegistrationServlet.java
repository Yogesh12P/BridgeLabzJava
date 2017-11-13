package com.BridgeLabz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.BridgeLabz.Dao.JdbcUserDao;
import com.BridgeLabz.Dao.UserDaoInterface;
import com.BridgeLabz.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("Registration servlet called..!");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConf.xml");
		
		UserDaoInterface dao = (UserDaoInterface) ctx.getBean("userDao");
		User user = new User();
		user.setfName(request.getParameter("fName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		if(dao.registerUser(user))
		{
			System.out.println("Register succefully");
			response.sendRedirect("Login.html");
		}else
		{
			System.out.println("Not register..,");
			request.getRequestDispatcher("Registration.html");
		}
	}

}