package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.LoginValidator;
import service.UserService;
import bean.UserBean;

@Controller
@RequestMapping(value = "/login")
public class UserController
{
	@Autowired
	private UserBean user;
	
	@Autowired
	private LoginValidator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String showLogin(Map<String, Object> model)
	{
		System.out.println("Get login");
		UserBean userForm = new UserBean();
		model.put("login", userForm);

		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(
			@ModelAttribute("login") UserBean userBean, BindingResult result)
	{
		//Validation code
	    validator.validate(userBean, result);
	     
	    //Check validation errors
	    if (result.hasErrors()) {
	        return "login";
	    }
	    
		try
		{
			userBean = UserService.login(userBean.getEmail(), userBean.getPassword());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setEmail(userBean.getEmail());
		user.setId(userBean.getId());
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		user.setPassword(userBean.getPassword());
		// for testing purpose:
		System.out.println("username: " + user.getFirstName());
		System.out.println("username: " + user.getLastName());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());

		System.out.println("Id: " + user.getId());
		return "redirect:reservation/movie";
	}
}
