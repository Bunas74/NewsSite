package by.htp.ex.validation;

import by.htp.ex.validation.validationImpl.NewsValidationImpl;
import by.htp.ex.validation.validationImpl.UserValidationImpl;

public class ValidationProvider {

	private static final ValidationProvider instance = new ValidationProvider();

	private ValidationProvider() {}

	private final IUserValidation userValidation = new UserValidationImpl();
	private final INewsValidation newsValidation = new NewsValidationImpl();

	

	public IUserValidation getUserValidation() {
		return userValidation;
	}

	public INewsValidation getNewsValidation() {
		return newsValidation;
	}

	public static ValidationProvider getInstance() {
		return instance;
	}
}
