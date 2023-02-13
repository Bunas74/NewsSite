package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;

public interface IUserDAO {
	
	NewUserInfo logination(String login, String password) throws DaoException;
	
	void registration(String login, String password) throws DaoException;

}
