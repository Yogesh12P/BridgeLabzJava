package com.BridgeLabz.Dao;

import com.BridgeLabz.model.User;

public interface UserDao 
{
	public boolean newRegistration(User user);
	public boolean validUser(String userName, String password);
}
