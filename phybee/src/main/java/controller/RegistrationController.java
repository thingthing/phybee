package controller;

import bean.UserBean;

import bean.UserDTOBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import validator.EmailExistsException;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        UserDTOBean userForm = new UserDTOBean();
        model.put("userForm", userForm);

        return "registration";
    }

/*
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") UserDTOBean userDto,
                                      Map<String, Object> model) {

        // implement your own registration logic here...

        // for testing purpose:
        System.out.println("username: " + userDto.getFirstName());
        System.out.println("username: " + userDto.getLastName());
        System.out.println("password: " + userDto.getPassword());
        System.out.println("email: " + userDto.getEmail());
        userDto = UserService.subscribe(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
        final UserBean registered = createUserAccount(userDto);
        if (registered == null) {
            throw new UserAlreadyExistException();
        }
        System.out.println("Id: " + userBean.getId());
        return "RegistrationSuccess";
    }
*/

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("userForm") @Valid UserDTOBean accountDto,
                                            BindingResult result, WebRequest request, Errors errors) {
        UserBean registered = new UserBean();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("registrationSuccess", "user", accountDto);
        }
    }

    private UserBean createUserAccount(final UserDTOBean accountDto, BindingResult result) {
        UserBean registered = null;
        try {
            registered = UserService.subscribe(accountDto);
        } catch (final EmailExistsException e) {
            return null;
        }
        return registered;
    }
}
