package cn.codehero.hibernate.helloworld;

import java.sql.Date;

public class Article {
	
	private Integer id;
	private String title;
	private String author;
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private Date createTime;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Article(String title, String author, String content,
			Date createTime) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.createTime = createTime;
	}

	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author
				+ ", content=" + content + ", createTime=" + createTime + "]";
	}
	
	
}
