package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idNews;
	private String title;
	private String briefNews;
	private String content;
	private String newsDate;
	private Integer idUser;
	
	
	public News(){}

	public News(int idNews, String title, String briefNews, String content, String newsDate, int userId) {
		super();
		this.idNews = idNews;
		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.newsDate = newsDate;
		this.idUser = userId;
	}

	public Integer getIdNews() {
		return idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefNews() {
		return briefNews;
	}

	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer userId) {
		this.idUser = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(briefNews, content, idNews, newsDate, title,
				idUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(briefNews, other.briefNews)
				&& Objects.equals(content, other.content)
				&& Objects.equals(idNews, other.idNews)
				&& Objects.equals(newsDate, other.newsDate)
				&& Objects.equals(title, other.title)
				&& Objects.equals(idUser, other.idUser);
	}

	@Override
	public String toString() {
		return "News [idNews=" + idNews + ", title=" + title + ", briefNews="
				+ briefNews + ", content=" + content + ", newsDate=" + newsDate
				+ ", userId=" + idUser + "]";
	}

	
	
}
