package com.BridgeLabz.LoginForm.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> validateInputData(User user)
	{
		List<String> errors = new ArrayList<String>();
		
		String email = user.getEmail();
		String pass = user.getPassword();
		String mbl = user.getMobileNo();
		
		if(email == null && pass == null && mbl == null)
		{
			errors.add(0, email);
			errors.add("All Fields Required");
		}
		if(email == null)
		{
			errors.add("Email Required");
		}else
		{
			
		}
		if(pass == null)
		{
			errors.add("Password required");
		}
		
		System.out.println("List : "+errors);
		
		return errors;
	}
}
