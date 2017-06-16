package home.david.sfl.controller;

import home.david.sfl.model.User;
import home.david.sfl.service.SecurityService;
import home.david.sfl.service.UserService;
import home.david.sfl.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by David on 6/16/2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration (Model model) {

        model.addAttribute("userForm", new User());

        return "redirect:/admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration (@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login (User user, Model model, String error, String logout) {

        if (user.getRole() != null && user.getRole().equals("USER_ROLE")) {
            return "redirect:/user";
        }

        if (user.getRole() != null && user.getRole().equals("ADMIN_ROLE")) {
            return "redirect:/admin";
        }

        if (error != null) {
            model.addAttribute("error", "username or password is incorrect");
        }

        if (logout != null) {
            model.addAttribute("massage", "Logged out is successfully");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/user"}, method = RequestMethod.GET)
    public String welcome (Model model) {
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin (Model model) {
        return "admin";
    }

}
