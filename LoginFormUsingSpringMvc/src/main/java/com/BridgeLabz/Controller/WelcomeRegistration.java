package com.BridgeLabz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BridgeLabz.model.User;

@Controller
public class WelcomeRegistration 
{
	@RequestMapping("/registerPage")
	public ModelAndView goToRegistration()
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Welcome to registration..!!");
		mv.setViewName("registration.jsp");
		mv.addObject("user", new User());
		return mv;
	}
}
