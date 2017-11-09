package com.BridgeLabz.Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppContextAttributeListener
 *
 */
@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public AppContextAttributeListener() {
        
    	System.out.println("Servlet context attribute Listener constructor");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
        // System.out.println("Servlet context Attribute added : "+scae.getName()+" , "+scae.getValue());
         
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	//System.out.println("ServletContext attribute removed::{"+scae.getName()+","+scae.getValue()+"}");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	//System.out.println("ServletContext attribute replaced::{"+scae.getName()+","+scae.getValue()+"}");
    }
	
}
