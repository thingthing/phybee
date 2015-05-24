package validator;

import bean.UserDTOBean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Eric on 23/05/2015.
 */

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDTOBean user = (UserDTOBean) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}