package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.MovieService;
import service.UserService;
import bean.MovieBean;
import bean.UserBean;

@Controller
public class UserController
{
	@Autowired
	private UserBean user;

	@RequestMapping(value =
	{ "/", "/home**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage()
	{
		ModelAndView model = new ModelAndView();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		if (!name.equals("anonymousUser"))
		{
			UserBean userBean = new UserBean();
			try
			{
				userBean = UserService.login(name);
			} catch (Exception e)
			{
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

			model.addObject("username", name);
		}
		
		List<MovieBean> movies = MovieService.getCurrentMovies();
		
		model.addObject("title", "Spring Security Password Encoder");
		model.addObject("message", "This is default page!");
		model.addObject("movies", movies);
		model.setViewName("home");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
	{

		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null)
		{
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
}
