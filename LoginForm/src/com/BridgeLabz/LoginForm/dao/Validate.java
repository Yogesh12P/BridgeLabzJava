package com.BridgeLabz.LoginForm.dao;

import com.BridgeLabz.LoginForm.model.User;

public class Validate 
{
	public String validateData(User user)
	{
		System.out.println("validate user");
		String result = null;
		String email = user.getEmail();
		System.out.println("Email : "+email);
		if(email.equals(""))
		{
			result = "All Fields Required";
			System.out.println("All field required");
		}
		if(user.getEmail() == null)
		{
			result = "All Fields Required";
			System.out.println("Email required");
		}
		if(user.getPassword() == null)
		{
			result = "Password Required";
			System.out.println("password required");
		}
		return result;
	}
}
