package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class GoToAddNewsPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession(true).setAttribute(LINK.getValueField(), "go_to_add_news_page");
		request.setAttribute(PRESENTATION.getValueField(), "addNews");
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
	}

}
