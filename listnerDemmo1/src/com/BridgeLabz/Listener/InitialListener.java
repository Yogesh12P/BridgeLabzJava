package com.BridgeLabz.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.BridgeLabz.Dao.DBConnectionManager;

/**
 * Application Lifecycle Listener implementation class InitialListener
 *
 */
@WebListener
public class InitialListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	ServletContext ctx = sce.getServletContext();
    	
    	String url = ctx.getInitParameter("jdbc:mysql://localhost:3306/loginFormServlet");
    	String User = ctx.getInitParameter("root");
    	String password = ctx.getInitParameter("root");
    	
    	//create database connection from init parameter and set it to context
    	DBConnectionManager dbManager = new DBConnectionManager(url, User, password);
    	ctx.setAttribute("DBManager", dbManager);
    	System.out.println("Data base connection Established");
    	
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
    	ServletContext ctx = sce.getServletContext();
    	
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
    	dbManager.closeConnection();
    	System.out.println("Database connection closed..!");
    }
	
}
