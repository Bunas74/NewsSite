package by.htp.ex.controller;

import java.io.IOException;
import by.htp.ex.dao.connectionpool.ConnectionPool;
import by.htp.ex.dao.connectionpool.ConnectionPoolException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.ConstField.*;


public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();
	private final ConnectionPool pool = ConnectionPool.getInstance();

    public FrontController() {
        super();
    }
    
    @Override
    public void init () throws ServletException {
    	
				try {
					
					pool.initPoolData();
					
				} catch (ConnectionPoolException e) {
					throw new ServletException("Connection pool initialization failed.");
				}  	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commandName = request.getParameter(COMMAND.getValueField());
		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	}

}
