package com.BridgeLabz.LoginForm.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class ValidateListener
 *
 */
@WebListener
public class ValidateListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public ValidateListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         
    	System.out.println("session logout");
    	
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	System.out.println("Session Initialised");
    	
    }
	
}
