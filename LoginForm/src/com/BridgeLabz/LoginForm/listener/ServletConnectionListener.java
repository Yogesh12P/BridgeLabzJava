package com.BridgeLabz.LoginForm.listener;

import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import com.BridgeLabz.Dao.DBConnectionManager;
import com.mysql.jdbc.Connection;;
/**
 * Application Lifecycle Listener implementation class ServletConnectionListener
 *
 */
//@WebListener
public class ServletConnectionListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletConnectionListener() {
        // TODO Auto-generated constructor stub
    	
    	System.out.println("hii");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	ServletContext ctx = sce.getServletContext();
    	try{
    	Connection conn = (Connection) ctx.getAttribute("DBManager");
    	conn.close();
    	System.out.println("Database connection closed..!");
    	}catch (Exception e) {

    		e.printStackTrace();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	ServletContext ctx = sce.getServletContext();
    	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/loginFormServlet";
		Connection connection = (Connection) DriverManager.getConnection(url,"root","root");
    	
		ctx.setAttribute("DBManager", connection);
    	System.out.println("Data base connection Established");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception at listener.., ");
    	}
    }
	
}
