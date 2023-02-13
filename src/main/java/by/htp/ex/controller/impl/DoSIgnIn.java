package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class DoSIgnIn implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter(LOGIN.getValueField());
		String password = request.getParameter(PASSWORD.getValueField());

		try {
			
			NewUserInfo user = service.signIn(login, password);
			String role = user.getRole();
			Integer idUser = user.getIdUser();

			if (!role.equals(GUEST.getValueField())) {

				request.getSession(true).setAttribute(USER.getValueField(), "active");
				request.getSession(true).setAttribute(ROLE.getValueField(), role);
				request.getSession(true).setAttribute(ID_USER.getValueField(), idUser);
				response.sendRedirect("controller?command=go_to_news_list");

			} else {

				request.getSession(true).setAttribute(USER.getValueField(), "not active");
				request.getRequestDispatcher("controller?command=go_to_base_page").forward(request, response);
			}

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getValueField(), "An error occurred during authorization. " + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}

}
