package com.BridgeLabz.LoginForm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.BridgeLabz.LoginForm.model.User;

public class RegistrationDao 
{
	
	public boolean registerNewUser(User newUser)
	{
		boolean result = false;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/loginFormServlet";
			Connection connection = DriverManager.getConnection(url,"root","root");
			
			String query = "insert into userInfo (firstName, lastName, email, password, mobileNo) values (?, ?, ?, ?, ?)"; 
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, newUser.getFirstName());
			ps.setString(2, newUser.getLastName());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());
			ps.setString(5, newUser.getMobileNo());
			ps.execute();
			connection.close();
			result = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception At Register New User "+e);
			result = false;
		}finally {
			
		}
		
		return result;
	}

}
