package com.BridgeLabz.Dao;

import java.sql.Connection;

public class DBConnectionManager 
{
	private String dbURL;
	private String user;
	private String password;
	private Connection con;
	
	public DBConnectionManager()
	{
		
	}
	
	
	public DBConnectionManager(String dbURL, String user, String password) {
		super();
		this.dbURL = dbURL;
		this.user = user;
		this.password = password;
		this.con = con;
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public void closeConnection(){
		//close DB connection here
	}

}
