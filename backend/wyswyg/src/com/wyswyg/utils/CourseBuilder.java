package com.wyswyg.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;

public class CourseBuilder {
	public Course prepareCourse(Chapter ch) {
		// create the course
		Course course = new Course("SP200", new TreeSet<Chapter>(), "Spring Boot", Date.valueOf(LocalDate.now()));
		return course;
	}

	public Chapter prepareChapter(Course c) {
		// create the course
		Chapter chapter = new Chapter("SP200CH100", new TreeSet<Page>(), "Chapter 1", 1, c);
		return chapter;
	}

	public Page preparePage(Chapter ch) {
		// create the course
		Page page = new Page("SP200CH100P1", "<h1>Welcome!!!</h1>", "Section 1", 1, ch);
		return page;
	}
}
