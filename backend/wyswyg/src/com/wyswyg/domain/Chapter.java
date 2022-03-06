package com.wyswyg.domain;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Chapter implements Serializable, Comparable<Chapter> {
	private String id;
	private Set<Page> pages;
	private String title;
	private int number;
	private Course course;

	public Chapter() {
	}

	public Chapter(String id, Set<Page> pages, String title, int number, Course course) {
		this.id = id;
		this.pages = pages;
		this.title = title;
		this.number = number;
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	public String toString() {
		return "Chapter [id=" + id + ", pages=" + pages + ", title=" + title + ", number=" + number + ", course="
				+ course + "]";
	}

	@Override
	public int compareTo(Chapter o) {
		// extract and get the chapter numbers
		// e.g: SP100CH100 = 100
		// test logs
		Integer thisChapter = Integer.parseInt(this.id.substring(7, 10));
		Integer otherChapter = Integer.parseInt(o.getId().substring(7, 10));
		System.out.println(thisChapter + " " + otherChapter);

		// comparison logic
		if (this.id == o.getId()) {
			return 0;
		} else if (thisChapter > otherChapter) {
			return 1;
		} else {
			return -1;
		}
	}

}
