package by.htp.ex.service;

import by.htp.ex.bean.NewUserInfo;

public interface IUserService {
	
	NewUserInfo signIn(String login, String password) throws ServiceException;
	
	void registration(String login, String password) throws ServiceException;

}
