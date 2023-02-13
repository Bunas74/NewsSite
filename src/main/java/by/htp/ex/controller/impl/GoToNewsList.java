package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class GoToNewsList implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<News> newsList;

		try {

			newsList = newsService.list();

			if(!newsList.isEmpty()) {
				request.setAttribute(NEWS.getValueField(), newsList);
			}
			
			request.setAttribute(PRESENTATION.getValueField(), "newsList");
			request.getSession(true).setAttribute(LINK.getValueField(), "go_to_news_list");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

		} catch (ServiceException e) {

			request.setAttribute(ERROR.getValueField(), "Error while getting list of news.");
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}

}
