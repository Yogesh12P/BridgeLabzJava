package com.BridgeLabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OnservletContext
 */
//@WebServlet("/OnservletContext")
public class OnservletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OnservletContext() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("onservletcontext called");
		PrintWriter pw = response.getWriter();
		
		ServletContext ctx = request.getServletContext();
		ServletConfig cfg = getServletConfig();
		
		String login = ctx.getInitParameter("loginValue");
		String in = cfg.getInitParameter("initparamContext");
		Enumeration<String> l2 = ctx.getInitParameterNames();
		System.out.println("context param value ::"+login);
		System.out.println("l2 :: "+l2);
		System.out.println("init param is "+in);
		//response.sendRedirect("login.html");
	}

}
