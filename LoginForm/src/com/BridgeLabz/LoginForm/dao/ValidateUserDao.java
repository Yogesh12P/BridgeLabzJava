package com.BridgeLabz.LoginForm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.BridgeLabz.LoginForm.model.User;

public class ValidateUserDao 
{
	
	public boolean validUser(String userName, String password)
	{
		boolean result = false;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/loginFormServlet";
			Connection conn = DriverManager.getConnection(url,"root","root");
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
