package controller;

import java.security.Principal;
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

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user)
	{

		ModelAndView model = new ModelAndView();

		if (user != null)
		{
			model.addObject("msg", "Hi " + user.getName()
					+ ", you do not have permission to access this page!");
		} else
		{
			model.addObject("msg",
					"You do not have permission to access this page!");
		}

		model.setViewName("accessDenied");
		return model;

	}

	@RequestMapping(value =
	{ "/", "/home**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(
			@RequestParam(value = "logout", required = false) String logout)
	{
		ModelAndView model = new ModelAndView();

		try
		{
			UserService.login(user);

			model.addObject("user", user);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		List<MovieBean> movies = MovieService.getCurrentMovies();

		model.addObject("title", "Spring Security Password Encoder");
		model.addObject("message", "This is default page!");
		model.addObject("movies", movies);

		if (logout != null)
		{
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("home");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error)
	{

		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("error", "Invalid username and password!");
		}

		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public ModelAndView profig()
	{

		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("profil");

		return model;

	}

	@RequestMapping(value = "/infos", method = RequestMethod.GET)
	public ModelAndView infos()
	{

		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("infos");

		return model;

	}
}
