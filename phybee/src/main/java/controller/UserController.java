package controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import service.MovieService;
import service.UserService;
import bean.MovieBean;
import bean.PasswordBean;
import bean.UserBean;
import bean.UserMovies;

@Controller
public class UserController
{
	@Autowired
	private UserBean user;
	private List<UserMovies> userMovies;

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

	@RequestMapping(value = "/changePwd")
	public String viewChangePassword (Map<String, Object> model)
	{
		PasswordBean pwdForm = new PasswordBean();
		model.put("pwdForm", pwdForm);

		return "changePassword";
	}

	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	public ModelAndView changePwd(@ModelAttribute ("pwdForm") @Valid PasswordBean pwd,
								  BindingResult result, WebRequest request, Error errors) {

		Boolean done = false;
		if (!result.hasErrors()) {
			done = updatePassword(user, pwd);
		}
		if (result.hasErrors()) {
			return new ModelAndView("changePassword", "password", pwd);
		} else if (done == false){
			return new ModelAndView("passwordUnchanged");
		}
		else {
			return new ModelAndView("passwordChanged");
		}
	}

	private Boolean updatePassword(final UserBean user, final PasswordBean pwd) {
		Boolean success = UserService.setUserPassword(user, pwd);
		return success;
	}

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public ModelAndView profil()
	{
		this.userMovies = UserService.getUserMovies(user.getId());
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.addObject("listmovie", userMovies);
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
