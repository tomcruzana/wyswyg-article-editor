package com.wyswyg.domain;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Chapter implements Serializable {
	private int id;
	private Set<Page> pages;
	private String title;
	private int number;
	private Course course;

	public Chapter() {
	}

	public Chapter(int id, Set<Page> pages, String title, int number, Course course) {
		this.id = id;
		this.pages = pages;
		this.title = title;
		this.number = number;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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
		Chapter other = (Chapter) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
