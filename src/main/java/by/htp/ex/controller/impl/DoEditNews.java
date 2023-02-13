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

public class DoEditNews implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		News news = new News();

		String idNews = request.getParameter(ID_NEWS.getValueField());
		String title = request.getParameter(TITLE.getValueField());
		String briefNews = request.getParameter(BRIEF.getValueField());
		String content = request.getParameter(CONTENT.getValueField());

		news.setIdNews(Integer.parseInt(idNews));
		news.setTitle(title);
		news.setBriefNews(briefNews);
		news.setContent(content);

		try {

			newsService.update(news, request);

			request.getSession(true).setAttribute(LINK.getValueField(), "go_to_view_news");
			response.sendRedirect("controller?command=go_to_view_news&idNews=" + idNews);

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getValueField(), "An error has occurred. Data not edited. " + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}

}
