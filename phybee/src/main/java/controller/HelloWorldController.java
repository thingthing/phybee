package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.UserBean;
 
@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
 
	@Autowired
	private UserBean user;
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		
		System.out.println("in controller hello world");
		 
		System.out.println("username: " + user.getFirstName());
		System.out.println("username: " + user.getLastName());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("Id: " + user.getId());
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("user", user);
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
