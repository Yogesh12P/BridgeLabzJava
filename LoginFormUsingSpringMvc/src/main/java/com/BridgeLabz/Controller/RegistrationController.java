package com.BridgeLabz.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BridgeLabz.Dao.UserDao;
import com.BridgeLabz.Dao.UserImplDao;
import com.BridgeLabz.model.User;
import com.BridgeLabz.validator.SendingEmail;
import com.BridgeLabz.validator.UserValidator;

@Controller
public class RegistrationController 
{
	
	@Autowired
	private UserDao userDao;
	
	
	
	//@RequestMapping(value="/newRegister")
	public ModelAndView registerNewUser(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		System.out.println("New registration called");
		ModelAndView mv = new ModelAndView();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		
		
			if(userDao.newRegistration(user))
			{
				System.out.println("Register succefully");
				mv.setViewName("index.jsp");
				mv.addObject("error", "succefully register..!");
				
			}
			else
			{
				System.out.println("Error..! Not registered..!!");
				mv.setViewName("registration.jsp");
				mv.addObject("reerror", "Error..!!Try again..!!");
			}
		return mv;
	}
	
	@Autowired
	private UserValidator uservalidator;
	@Autowired
	private SendingEmail sendemail;
	@RequestMapping(value="/newRegister",method=RequestMethod.POST )
	public ModelAndView registration(@ModelAttribute("user") User user,BindingResult bindingResult)
	{
		
		uservalidator.validate(user, bindingResult);
		ModelAndView mav = null;
		
		if(bindingResult.hasErrors())
		{
			
			System.out.println("Error occured");
			mav = new ModelAndView("registration.jsp");
			mav.addObject("user", new User());
			return mav;
		}
		
		System.out.println("No error..!!");
		userDao.newRegistration(user);
		String status = sendemail.sendEmail(user);
		
		mav = new ModelAndView("showMessage.jsp");
		mav.addObject("showMessage", status);
		return mav;
		
	}
}
