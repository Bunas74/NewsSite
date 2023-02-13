package by.htp.ex.controller.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import static by.htp.ex.controller.ConstField.*;

public class AuthFilter implements Filter {
	
	private static final String DO_ADD_NEWS = "do_add_news";
	private static final String DO_DELETE_NEWS = "do_delete_news";
	private static final String DO_EDIT_NEWS = "do_edit_news";

	public AuthFilter() {
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, jakarta.servlet.FilterChain chain) throws IOException, jakarta.servlet.ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = null;

		if (req.getSession() != null) {
			
			session = req.getSession();
		}

		String role = (String) session.getAttribute(ROLE.getValueField());
		String command = req.getParameter(COMMAND.getValueField());

		switch (command) {

			case DO_ADD_NEWS :

				if (!role.equals(ADMIN.getValueField())) {

					req.getSession(true).setAttribute(ERROR.getValueField(), "Insufficient access rights.");
					req.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
					
				} else {
					
					chain.doFilter(request, response);
				}
				break;

			case DO_DELETE_NEWS :

				if (!role.equals(ADMIN.getValueField())) {

					req.getSession(true).setAttribute(ERROR.getValueField(), "Insufficient access rights.");
					req.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
					
				} else {
					
					chain.doFilter(request, response);
				}
				break;
				
			case DO_EDIT_NEWS :

				if (!role.equals(ADMIN.getValueField())) {

					req.getSession(true).setAttribute(ERROR.getValueField(), "Insufficient access rights.");
					req.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
					
				} else {
					
					chain.doFilter(request, response);
				}
				break;

			default :
				
				chain.doFilter(request, response);
		}

	}

}
