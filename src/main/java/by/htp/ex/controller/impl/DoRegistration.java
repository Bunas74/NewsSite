package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class DoRegistration implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter(LOGIN.getValueField());
		String password = request.getParameter(PASSWORD.getValueField());

		try {

			service.registration(login, password);

			request.getSession(true).setAttribute(LINK.getValueField(), "go_to_base_page");
			response.sendRedirect("controller?command=go_to_base_page");

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getValueField(), "An error occurred while registering. " + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}

}
