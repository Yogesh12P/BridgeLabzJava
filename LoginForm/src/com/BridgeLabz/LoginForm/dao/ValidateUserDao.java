package com.BridgeLabz.LoginForm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;


public class ValidateUserDao 
{
	
	//for datasource connection
	public boolean validUser(String userName, String password, ServletContext ctx)
	{
		boolean result = false;
		
		try {
			
			//To get connect by Datasource
			//Connection conn =  (Connection) ctx.getAttribute("DBManager");
			Connection conn = Dbutil.getConnectionDBUtil();
			Statement stmt = conn.createStatement();
			String sql = "Select * from userInfo Where email='" + userName + "' and password='" + password + "'";	
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				result = true;
				
			}else
			{
				result = false;
			}
		} catch (Exception e) {
			result = false;
			System.out.println("Exception at Validate user "+e);
		}
		return result;
	}
}
