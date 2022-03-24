package com.wyswyg.utils;

import java.sql.Clob;
import java.sql.Date;
import java.time.LocalDate;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.wyswyg.dao.CourseDaoImpl;
import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;

public class CourseBuilder {
	private static Logger log = Logger.getLogger(CourseBuilder.class);
	
	public Course prepareCourse(String id, String title) {
		Course course = new Course(id, null, title, Date.valueOf(LocalDate.now()));
		log.info("Course object instance created");
		return course;
	}

	public Chapter prepareChapter(String id, String title, int chapterNumber, Course course) {
		Chapter chapter = new Chapter(id, null, title, chapterNumber, course);
		log.info("Chapter object instance created");
		return chapter;
	}

	public Page preparePage(String id, String components, String title, int pageNumber, Chapter chapter) {
		Page page = new Page(id, components, title, pageNumber, chapter);
		log.info("Page object instance created");
		return page;
	}


}
