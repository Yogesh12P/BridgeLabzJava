package com.BridgeLabz.Listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletRequestListener
 *
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyServletRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  
    { 
    	
        ServletRequest request = sre.getServletRequest();
//    	System.out.println("Servlet request initialised for IP: "+request.getRemoteAddr());
//    	System.out.print(" and Host: "+request.getRemoteHost());
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  
    { 
    	
        ServletRequest request = sre.getServletRequest();
//        System.out.println("Servlet request destroy for IP: "+request.getRemoteAddr());
//        System.out.print(" and Host: "+request.getRemoteHost());

    	
    }
	
}
