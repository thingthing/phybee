package controller;

import bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        UserBean userForm = new UserBean();
        model.put("userForm", userForm);

        return "Registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") UserBean userBean,
                                      Map<String, Object> model) {

        // implement your own registration logic here...

        // for testing purpose:
        System.out.println("username: " + userBean.getFirstName());
        System.out.println("username: " + userBean.getLastName());
        System.out.println("password: " + userBean.getPassword());
        System.out.println("email: " + userBean.getEmail());

        return "RegistrationSuccess";
    }
}
