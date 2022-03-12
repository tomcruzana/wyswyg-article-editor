package com.wyswyg.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.wyswyg.dao.ChapterDaoImpl;
import com.wyswyg.dao.CourseDaoImpl;
import com.wyswyg.dao.PageDaoImpl;
import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;
import com.wyswyg.utils.CourseBuilder;
import com.wyswyg.utils.PropertiesConfigurationFactory;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Temp {

	private static Logger log = Logger.getLogger(Temp.class);

	public static void main(String[] args) throws SQLException, ConfigurationException {
		log.info("Initializing app...");
		String title = PropertiesConfigurationFactory.getPropertiesConfiguration("app.title");
		String version = PropertiesConfigurationFactory.getPropertiesConfiguration("app.version");
		String jdriver = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.jdbcdriver");
		String jurl = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.url");

		log.info(title + " " + version);
		log.info(jdriver + " " + jurl);
		log.info("App initialization success!");

		CourseBuilder cb = new CourseBuilder();
		Course course = cb.prepareCourse("NJ400", "Node.js");
		Chapter chapter1 = cb.prepareChapter("NJ400CH100", "History of Node.js", 1, course);
		Page page1 = cb.preparePage("NJ400CH100PG100", "<p>Lorem ipsum dolor</p>", "Section 1: History of Node.js", 1, chapter1);
	
		ChapterDaoImpl chdi = new ChapterDaoImpl();
		List<Chapter> allChapters = chdi.getAll();
		allChapters.forEach(ch->System.out.println(ch));
	}

}
