package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;

public class DoSignOut implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getSession().removeAttribute(USER.getValueField());
			request.getSession().removeAttribute(ROLE.getValueField());
			request.getSession().removeAttribute(ID_USER.getValueField());
			response.sendRedirect("controller?command=go_to_base_page");
		
	}

}
