package com.wyswyg.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Page implements Serializable, Comparable<Page> {
	private String id;
	private String components;
	private String title;
	private int number;
	private Chapter chapter;

	public Page() {
	}

	public Page(String id, String components, String title, int number, Chapter chapter) {
		this.id = id;
		this.components = components;
		this.title = title;
		this.number = number;
		this.chapter = chapter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
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

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", components=" + components + ", title=" + title + ", number=" + number
				+ ", chapter=" + chapter + "]";
	}

	@Override
	public int compareTo(Page o) {
		// extract and get the chapter numbers
		// e.g: CJ100CH100PG1 = 1
		Integer thisPage = Integer.parseInt(this.id.substring(12));
		Integer otherPage = Integer.parseInt(o.getId().substring(12));
		// test log: System.out.println(thisPage + " " + otherPage);

		// comparison logic
		if (this.id == o.getId()) {
			return 0;
		} else if (thisPage > otherPage) {
			return 1;
		} else {
			return -1;
		}
	}

}
