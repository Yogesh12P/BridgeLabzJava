package com.BridgeLabz.LoginForm.filter;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ValidateFilter
 */
@WebFilter("/ValidateFilter")
public class ValidateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidateFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("Filter validate called");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Filter Destroy called");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		
		HttpServletRequest filterReq = (HttpServletRequest) request;
		HttpServletResponse filterRes = (HttpServletResponse) response;
		HttpSession session = filterReq.getSession();

		String url = filterReq.getRequestURL().toString();
		
		String strurl = "http://localhost:8080/LoginForm/";
		
		System.out.println("Before filter url check");
		if(url.equals("http://localhost:8080/LoginForm/"))
		{
			System.out.println("After filter url check");
			System.out.println("Filter called");
			String userName = (String)session.getAttribute("loginusername");
			System.out.println("UserNAme : "+userName);
			
			if(userName != null)
			{
				request.getRequestDispatcher("homepage").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("login").forward(filterReq, filterRes);;
			}
		}
		else
		{
			
			chain.doFilter(request, response);
			System.out.println("chain do..,!!");
		}
			
	
		}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter init method called");
	}

}
