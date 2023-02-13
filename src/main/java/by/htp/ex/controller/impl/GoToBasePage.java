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

public class GoToBasePage implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<News> latestNews;

		String link = request.getParameter(COMMAND.getValueField());

		try {

			latestNews = newsService.latestList(LIST_COUNT.getCount());

			if(!latestNews.isEmpty()) {
				request.setAttribute(NEWS.getValueField(), latestNews);
			}
			
			request.getSession(true).setAttribute(LINK.getValueField(), link);
			request.setAttribute(PRESENTATION.getValueField(), "guestInfo");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getValueField(), "Error while getting list of news.");
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}

}
