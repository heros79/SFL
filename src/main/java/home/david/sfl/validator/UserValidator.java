package home.david.sfl.validator;

import home.david.sfl.model.User;
import home.david.sfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by David on 6/16/2017.
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");

        if (user.getUserName().length() < 6 || user.getUserName().length() > 20) {
            errors.rejectValue("userName", "Size.userform.userName");
        }

        if (userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userform.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPasswordHash().length() < 8) {
            errors.rejectValue("password", "Size.userform.password");
        }
    }
}
