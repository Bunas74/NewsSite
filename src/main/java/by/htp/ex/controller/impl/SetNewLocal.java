package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class SetNewLocal implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String local = request.getParameter(LOCAL.getValueField());
		String link = null;

		if (request.getSession() != null) {
			
			link = (String) request.getSession().getAttribute(LINK.getValueField());
		}

		request.getSession(true).setAttribute(LOCAL.getValueField(), local);
		request.getRequestDispatcher("controller?command=" + link).forward(request, response);

	}
}
