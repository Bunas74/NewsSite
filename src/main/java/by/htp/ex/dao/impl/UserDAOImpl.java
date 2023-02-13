package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.connectionpool.ConnectionPool;
import by.htp.ex.dao.connectionpool.ConnectionPoolException;

public class UserDAOImpl implements IUserDAO {

	private static final ConnectionPool pool = ConnectionPool.getInstance();
	
	private static final String LOGINATION = "SELECT * FROM news_site.users WHERE email=?";
	private static final String REGISTRATION = "INSERT INTO news_site.users (email, password, role) Values (?, ?, ?)";

	@Override
	public NewUserInfo logination(String login, String password) throws DaoException {

		NewUserInfo user = null;

		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			
			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(LOGINATION);
			preparedStatement.setString(1, login);
			resultSet = preparedStatement.executeQuery();

			if(!resultSet.next()) {
				throw new DaoException("Wrong login.");
				
			}else {

				int id = resultSet.getInt(1);
				String email = resultSet.getString(2);
				String passwordUser = resultSet.getString(3);
				String role = resultSet.getString(4);

				if(!passwordUser.equals(password)) {
					throw new DaoException("Wrong password.");
				}
				
				user = new NewUserInfo(id, email, passwordUser, role);
			}
			
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Something went wrong. Error during login.");
			}
		}

		return user;

	}

	@Override
	public void registration(String login, String password) throws DaoException {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			
			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(REGISTRATION);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, "user");

			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new DaoException("Something went wrong. Error during registration.");
			}
		}

	}

}
