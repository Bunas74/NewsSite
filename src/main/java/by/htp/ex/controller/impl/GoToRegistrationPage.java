package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class GoToRegistrationPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute(PRESENTATION.getValueField(), "regPage");
		request.getSession(true).setAttribute(LINK.getValueField(), "go_to_registration_page");
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

	}

}
