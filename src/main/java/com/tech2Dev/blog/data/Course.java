package com.tech2Dev.blog.data;

import java.sql.Date;

public class Course {

	private int id;
	private String name;
	private String description;
	private String author;
	private Date creationDate;
	private Date lastModifiedDate;
	
	public Course() {

	}

	public Course(int id, String name, String description, String author, Date creationDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
		this.creationDate = creationDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author
				+ ", creationDate=" + creationDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	
}
