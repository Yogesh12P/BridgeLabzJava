package com.BridgeLabz.Dao;

import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

//import javax.activation.DataSource;
import javax.sql.DataSource;

import com.BridgeLabz.model.User;

public class JdbcUserDao implements UserDaoInterface 
{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean registerUser(User user) {

		boolean result = false;	
		
		String quiry = "Insert into User "+" (UserName, UserEmail, UserPassword) values (?, ?, ?)";
		
		Connection conn = null;
		Properties pop = new Properties();
		InputStream input = null;
		
		try {
			System.out.println("hi...,");
			//for do maually connection used db.properties..!
			
			input = this.getClass().getResourceAsStream("db.properties");
			//FileReader reader = new FileReader("/db.properties");
			System.out.println("2");
			pop.load(input);
			
			String driver = pop.getProperty("driverClassName");
			System.out.println("driver : "+driver);
			Class.forName(driver);
			String url = pop.getProperty("url");
			String username = pop.getProperty("username");
			String pass = pop.getProperty("password"); 
			conn = DriverManager.getConnection(url,username,pass);
			System.out.println("Connection : "+url+username+pass);
			//for get connection from spring use datasource
			//conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(quiry);
			ps.setString(1, user.getfName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
			ps.close();
			result = true;
		} catch (Exception e) {
			result = false;
			System.out.println("Error at register new user..!"+e);
			e.printStackTrace();
		}
		
		return result;
	}

	
}
