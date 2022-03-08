package com.wyswyg.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.TreeSet;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;

public class CourseBuilder {
	public Course prepareCourse(String courseTitle) {
		Course course = new Course("SP200", new TreeSet<Chapter>(), courseTitle, Date.valueOf(LocalDate.now()));
		System.out.println("LOG: new course created");
		return course;
	}

	public Chapter prepareChapter(Course c, String chapterTitle, int chapterNumber) {
		Chapter chapter = new Chapter("SP200CH100", new TreeSet<Page>(), chapterTitle, chapterNumber, c);
		System.out.println("LOG: new chapter created");
		return chapter;
	}

	public boolean addChapterToCourse(Course course, Chapter chapter) {
		boolean res =  course.getChapters().add(chapter);
		System.out.println("LOG: new chapter added -" + res);
		return res;
	}

	public Page preparePage(Chapter ch, String pageTitle, int pageNumber) {
		 Page page = new Page("SP200CH100PG1", "<h1>Welcome!!!</h1>", pageTitle, pageNumber, ch);
		 System.out.println("LOG: new page created");
		 return page;
	}

	public boolean addPagetoChapter(Chapter chapter, Page page) {
		boolean res = chapter.getPages().add(page);
		System.out.println("LOG: new page added -" + res);
		return res;
	}
}
