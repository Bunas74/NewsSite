package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.connectionpool.ConnectionPool;
import by.htp.ex.dao.connectionpool.ConnectionPoolException;

public class NewsDAOImpl implements INewsDAO {

	private static final ConnectionPool pool = ConnectionPool.getInstance();
	
	private static final String PATTERN_DATE = "dd.MM.yyyy";

	private static final String GET_LATESTS_LIST = "SELECT * FROM news_site.news_en ORDER BY idNews DESC LIMIT ?";
	private static final String GET__LIST = "SELECT * FROM news_site.news_en";
	private static final String FETCH_BY_ID = "SELECT * FROM news_site.news_en WHERE idNews=?";
	private static final String ADD_NEWS = "INSERT INTO news_site.news_en (title, briefNews, content, users_id) Values (?, ?, ?, ?)";
	private static final String UPDATE_NEWS = "UPDATE news_site.news_en SET title = ?, briefNews = ?, content = ? WHERE idNews = ?";
	private static final String DELETE_NEWS = "DELETE FROM news_site.news_en WHERE idNews = ?";

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {

		List<News> latestList = new ArrayList<>();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(GET_LATESTS_LIST);
			preparedStatement.setInt(1, count);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int idNews = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String briefNews = resultSet.getString(3);
				String content = resultSet.getString(4);
				String newsDate = new SimpleDateFormat(PATTERN_DATE).format(resultSet.getDate(5));
				int userId = resultSet.getInt(6);

				latestList.add(new News(idNews, title, briefNews, content, newsDate, userId));
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

		return latestList;
	}

	@Override
	public List<News> getList() throws NewsDAOException {

		ArrayList<News> newsList = new ArrayList<>();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			con = pool.takeConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(GET__LIST);

			while (resultSet.next()) {

				int idNews = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String briefNews = resultSet.getString(3);
				String content = resultSet.getString(4);
				String newsDate = new SimpleDateFormat(PATTERN_DATE).format(resultSet.getDate(5));
				int userId = resultSet.getInt(6);

				newsList.add(new News(idNews, title, briefNews, content, newsDate, userId));
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		} finally {

			try {
				pool.closeConnection(con, statement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}
		return newsList;
	}

	@Override
	public News fetchById(int id) throws NewsDAOException {

		News news = null;

		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(FETCH_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				int idNews = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String briefNews = resultSet.getString(3);
				String content = resultSet.getString(4);
				String newsDate = new SimpleDateFormat(PATTERN_DATE).format(resultSet.getDate(5));
				int userId = resultSet.getInt(6);

				news = new News(idNews, title, briefNews, content, newsDate, userId);
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

		return news;
	}

	@Override
	public void addNews(News news) throws NewsDAOException {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(ADD_NEWS);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getBriefNews());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setInt(4, news.getIdUser());

			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

	}

	@Override
	public void updateNews(News news) throws NewsDAOException {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(UPDATE_NEWS);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getBriefNews());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setInt(4, news.getIdNews());

			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

	}

	@Override
	public void deleteNews(int id) throws NewsDAOException {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = pool.takeConnection();
			preparedStatement = con.prepareStatement(DELETE_NEWS);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		} finally {

			try {
				pool.closeConnection(con, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

	}

}
