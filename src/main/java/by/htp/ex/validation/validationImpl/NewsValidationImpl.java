package by.htp.ex.validation.validationImpl;

import jakarta.servlet.http.HttpServletRequest;
import static by.htp.ex.controller.ConstField.*;

import by.htp.ex.bean.News;
import by.htp.ex.validation.INewsValidation;
import by.htp.ex.validation.ValidationException;

public class NewsValidationImpl implements INewsValidation{

	@Override
	public void validNews(HttpServletRequest request) throws ValidationException {

		String role = null;
		
		if(request.getSession() != null) {
			
			role = (String)request.getSession().getAttribute(ROLE.getValueField());
		}
		
		if(!role.equals(ADMIN.getValueField())) {
			
			throw new ValidationException("Insufficient access rights.");
		}
		
	}
	
	@Override
	public void validNews(News news) throws ValidationException {
		
		if(news.getTitle().equals("") || news.getBriefNews().equals("") || news.getContent().equals("")) {
			
			throw new ValidationException("Fields cannot be empty.");
			
		}
		
	}
	
}
