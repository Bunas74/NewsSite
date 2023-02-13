package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class DoDeleteNews implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String idNews = request.getParameter(ID_NEWS.getValueField());

		try {

			newsService.delete(Integer.parseInt(idNews), request);

			request.getSession(true).setAttribute(LINK.getValueField(), "go_to_new_list");
			response.sendRedirect("controller?command=go_to_news_list");

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getValueField(),"An error has occurred. Data not deleted. " + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);

		}

	}

}
