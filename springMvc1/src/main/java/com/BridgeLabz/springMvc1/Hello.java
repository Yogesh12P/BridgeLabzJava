package com.BridgeLabz.springMvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {

	@RequestMapping("/hello")
	public ModelAndView sayHello()
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Hi...!!");
		mv.setViewName("welcome.jsp");
		mv.addObject("message", "Hi how are you..??");
		return mv;
	}
}
