package controller;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Eric on 06/05/2015.
 */

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("loginForm", "command", new User());
    }


    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
                                      Map<String, Object> model) {

        // implement your own registration logic here...

        // for testing purpose:

        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());

        return "LoginSuccess";
    }
}
