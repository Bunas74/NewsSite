package by.htp.ex.validation;

import by.htp.ex.bean.News;
import jakarta.servlet.http.HttpServletRequest;

public interface INewsValidation {

	void validNews(HttpServletRequest request) throws ValidationException;

	void validNews(News news) throws ValidationException;
}
