package com.BridgeLabz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private HttpSession session ;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		Object sss = session.getAttribute("hi");
		String ss = (String) request.getAttribute("hi");
		
		String s = (String) request.getSession(false).getAttribute("hi");
		
		
		System.out.println("value of hi = "+sss+" or "+ss+" or "+s);
		//session.setAttribute("hi..,", "hi");
		
		//session.invalidate();
		response.sendRedirect("index.jsp");
	}
	
	public HttpSession getSession()
	{
		return session;
	}

}
