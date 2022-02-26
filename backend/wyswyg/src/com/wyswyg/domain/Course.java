package com.wyswyg.domain;

import java.sql.Date;
import java.util.Set;

public class Course {
	private int id;
	private Set<Chapter> chapters;
	private String title;
	private Date dateCreated;

	public Course(int id, Set<Chapter> chapters, String title, Date dateCreated) {
		this.id = id;
		this.chapters = chapters;
		this.title = title;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", chapters=" + chapters + ", title=" + title + ", dateCreated=" + dateCreated
				+ "]";
	}

}
