package validator;

import bean.PasswordBean;
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
        if (obj instanceof UserDTOBean) {
            UserDTOBean user = (UserDTOBean) obj;
            return user.getPassword().equals(user.getMatchingPassword());
        }
        else if (obj instanceof PasswordBean) {
            PasswordBean user = (PasswordBean) obj;
            return user.getPassword().equals(user.getMatchingPassword());
        }
        else
            return false;
    }
}