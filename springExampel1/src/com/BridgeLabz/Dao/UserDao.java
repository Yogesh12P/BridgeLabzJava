package com.BridgeLabz.Dao;

import java.util.List;

import com.BridgeLabz.model.User;

public interface UserDao 
{

	public boolean insertUser(User user);
	public List<User> showAllUsers();
	public User findByUserId(int id);
	public boolean deleteByName(int id);
	public boolean updateUser(int id,String name,String email);
}
