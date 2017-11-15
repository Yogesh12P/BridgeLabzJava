package com.BridgeLabz.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BridgeLabz.Dao.UserDao;
import com.BridgeLabz.Dao.UserImplDao;
import com.BridgeLabz.model.User;

@Controller
public class LoginController 
{
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/login")
	public ModelAndView validUser(HttpServletRequest request ,HttpServletResponse response)
	{
		
		System.out.println("login controller called..!");
		//UserDao dao = new UserImplDao();
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
		boolean res = userDao.validUser(userName, password);
		ModelAndView mv = null;
		if(res)
		{
			System.out.println("Login succefully");

			mv = new ModelAndView("welcome.jsp");
			mv.addObject("firstname", userName);
		}else
		{
			System.out.println("Sorry..!!,,Something went wrong..!!");

			mv = new ModelAndView("index.jsp");
			mv.addObject("error", "Username and password incorrect");
		}
		
		return mv;
		
	}
}