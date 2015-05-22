package service;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bean.UserBean;

@Component
public class LoginValidator implements Validator
{

	// Spring Message Source
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	/**
	 * This Validator validates just UserBean instances
	 */
	@SuppressWarnings("rawtypes")
	public boolean supports(Class user)
	{
		return UserBean.class.equals(user);
	}

	@Override
	public void validate(Object obj, Errors e)
	{
		Locale locale = LocaleContextHolder.getLocale();
		
		String emailField = this.messageSource.getMessage("field.email", null,
				locale);
		String passwordField = this.messageSource.getMessage("field.password",
				null, locale);

		ValidationUtils.rejectIfEmpty(e, "email", "field.empty", new Object [] {emailField});
		ValidationUtils.rejectIfEmpty(e, "password", "field.empty", new Object [] {passwordField});
		// UserBean user = (UserBean) obj;

	}

}
