package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class GoToEditNewsPage implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		News news;

		String idNews = request.getParameter(ID_NEWS.getValueField());

		try {

			news = newsService.findById(Integer.parseInt(idNews));

			request.setAttribute(NEWS.getValueField(), news);
			request.setAttribute(PRESENTATION.getValueField(), "editNews");
			request.getSession(true).setAttribute(LINK.getValueField(), "go_to_edit_news_page&idNews=" + idNews);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getValueField(), "Error while getting news.");
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}

}
