package by.htp.ex.dao;

import by.htp.ex.dao.impl.NewsDAOImpl;
import by.htp.ex.dao.impl.UserDAOImpl;

public final class DaoProvider {
	
	private static final DaoProvider instance = new DaoProvider();

	private final IUserDAO userDao = new UserDAOImpl();
	private final INewsDAO newsDAO = new NewsDAOImpl();
	
	
	private DaoProvider() {
	}
		
	public IUserDAO getUserDao() {
		return userDao;
	}
	
	public INewsDAO getNewsDAO() {
		return newsDAO;
	}

	public static DaoProvider getInstance() {
		return instance;
	}
}
