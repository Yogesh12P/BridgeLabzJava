package com.BridgeLabz.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.BridgeLabz.Dao.UserDao;
import com.BridgeLabz.model.User;

public class RegisterUserController {

	public static void main(String[] args) 
	{
		boolean check = true;
		Scanner sc = new Scanner(System.in);
		
		while (check) 
		{
			System.out.println("Register new user Menu");
			System.out.println("1.Register New User");
			System.out.println("2.Show All User");
			System.out.println("3.show user by Name");
			System.out.println("4.Delete User");
			System.out.println("5.Update user data");
			System.out.println("Enter your choise:");
			int ch = sc.nextInt();
			RegisterUserController.selectOption(ch);
			
		}
	}
	
	public static void selectOption(int ch)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConf.xml");
		UserDao dao = (UserDao) ctx.getBean("userDao");
		
		Scanner sc = new Scanner(System.in);
		User user = new User();
		
		switch (ch) {
					
		case 1:
				
			System.out.println("Enter name:");
			String name = sc.nextLine();
			
			System.out.println("Enter Email:");
			String email = sc.nextLine();
			
			System.out.println("Enter password:");
			String password = sc.nextLine();
			
			System.out.println("Enter Mobile No:");
			double mobileNo = sc.nextDouble();
			
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setMobileNo((long) mobileNo);
			
			if(dao.insertUser(user))
			{
				System.out.println("user register succefully...!!");
			}
			else
			{
				System.out.println("user not registered..!");
			}
			
			break;
		case 2:
			List<User> data = dao.showAllUsers();
			System.out.println("All Registered user:");
			
			System.out.println("id \t name \t emai \t MobileNo");
				for(int i=0;i<data.size();i++)
				{
					
					System.out.println(data.get(i).getId()+"\t"+data.get(i).getName()+"\t"+data.get(i).getEmail()+"\t"+data.get(i).getMobileNo());
				}
			break;
		case 3:
			
			System.out.println("Enter user Id:");
			int uId = sc.nextInt();
			User idUser = dao.findByUserId(uId);
			System.out.println("user find "+idUser.getName()+" for name :"+uId);
			break;
		case 4:
			System.out.println("Enter the user name you want  to delete:");
			int dId = sc.nextInt();
			
			boolean dRes = dao.deleteByName(dId);
			
			if(dRes == false)
			{
				System.out.println("User is not deleted succefully");
				return;
			}
			System.out.println("User deleted succefully");
			break;
		case 5:
			System.out.println("Enter the id of user you want to update");
			int nId = sc.nextInt();
			System.out.println("Enter new name");
			String nName = sc.next();
			System.out.println("Enter Email :");
			String nEmail = sc.next();
			
			if(!dao.updateUser(nId, nName, nEmail))
			{
				System.out.println("User not updated..!");
				
			}
			else{
			System.out.println("User update succefully");
			}
			break;

		default:
			break;
		}
	}

}
