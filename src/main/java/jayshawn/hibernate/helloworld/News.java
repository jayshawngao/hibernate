package jayshawn.hibernate.helloworld;

import java.sql.Timestamp;

public class News {
	private Integer id;
	private String title;
	private String author;
	private Timestamp date;
	public News() {
		super();
	}
	
	
	public News(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}


	public News(String title, String author, Timestamp date) {
		super();
		this.title = title;
		this.author = author;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author + ", date=" + date + "]";
	}
	
}
