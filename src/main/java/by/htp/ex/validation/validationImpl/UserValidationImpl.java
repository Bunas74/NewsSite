package by.htp.ex.validation.validationImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.ex.validation.IUserValidation;
import by.htp.ex.validation.ValidationException;

public class UserValidationImpl implements IUserValidation{

	private static final String PATTERN_LOGIN = "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
	private static final String PATTERN_PASSWORD = "[\\d]+";

	private static final Pattern P_LOGIN = Pattern.compile(PATTERN_LOGIN);
	private static final Pattern P_PASSWORD = Pattern.compile(PATTERN_PASSWORD);

	@Override
	public void validUser(String login, String password) throws ValidationException {

		if (login == null || login.equals("")) {

			throw new ValidationException("Login must not be empty.");

		} else {

			Matcher m = P_LOGIN.matcher(login);

			if (!m.matches()) {
				throw new ValidationException("Incorrect login.");
			}
		}

		if (password == null || password.equals("")) {

			throw new ValidationException("Password must not be empty.");

		} else {

			Matcher m = P_PASSWORD.matcher(password);

			if (!m.matches()) {

				throw new ValidationException("Incorrect password.");
			}

		}
		
	}
	
}
