package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.service.ServiceException;
import by.htp.ex.validation.IUserValidation;
import by.htp.ex.validation.ValidationException;
import by.htp.ex.validation.ValidationProvider;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	private final IUserValidation userValidation = ValidationProvider.getInstance().getUserValidation();

	@Override
	public NewUserInfo signIn(String login, String password) throws ServiceException {

		try {

			userValidation.validUser(login, password);
			return userDAO.logination(login, password);

		} catch (ValidationException e) {
			throw new ServiceException(e);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void registration(String login, String password) throws ServiceException {

		try {

			userValidation.validUser(login, password);
			userDAO.registration(login, password);

		} catch (ValidationException e) {
			throw new ServiceException(e);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
