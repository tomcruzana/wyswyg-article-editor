package com.wyswyg.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;
import com.wyswyg.utils.CourseBuilder;
import com.wyswyg.utils.PropertiesConfigurationFactory;

public class Temp {

	public static void main(String[] args) throws SQLException, ConfigurationException {
		System.out.println("Log: starting app");
		String title = PropertiesConfigurationFactory.getPropertiesConfiguration("app.title");
		String version = PropertiesConfigurationFactory.getPropertiesConfiguration("app.version");
		String jdriver = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.jdbcdriver");
		String jurl = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.url");

		System.out.printf("%s %s \n%s \n%s \n", title, version, jdriver, jurl);
		System.out.println("Log: connection successful");
		
		CourseBuilder cb = new CourseBuilder();
		Course c1 = cb.prepareCourse(null);
		Chapter ch1 = cb.prepareChapter(c1);
		Page p1 = cb.preparePage(ch1);
		
		// redesign this crap
		System.out.println(c1);

	}

}
