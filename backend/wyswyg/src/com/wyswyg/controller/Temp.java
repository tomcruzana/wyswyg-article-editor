package com.wyswyg.controller;

import java.sql.SQLException;
import java.util.List;
import com.wyswyg.dao.CourseDaoImpl;
import com.wyswyg.dao.Dao;
import com.wyswyg.domain.Course;

public class Temp {

	public static void main(String[] args) throws SQLException {

//		// create a new course Date theDate = Date.valueOf(LocalDate.now()); // xfer to
//		// utils package?
//		Course theCourse = new Course(500, null, "React", theDate);
//		System.out.println("LOG: course instance created!");
//
//		// persist into db Dao theCourseDao = new CourseDaoImpl(); int res =
//		theCourseDao.add(theCourse);
//		System.out.println("LOG: course object added!");
//
//		// check if transaction is successful if (res > 0)
//		System.out.println("LOG: done!");
//
//		// ======================================
//		// get an existing course
//		int courseId = 500;
//		Dao<Course> theCourseDao = new CourseDaoImpl();
//		Course theCourse = (Course) theCourseDao.get(courseId);
//		System.out.println(theCourse);

		// ======================================

		// delete an existing course
//		Dao<Course> theCourseDao = new CourseDaoImpl();
//		theCourseDao.delete(600);

		// ======================================
		// get all courses
//		Dao<Course> theCourseDao = new CourseDaoImpl();
//		List<Course> allCourses = theCourseDao.getAll();
//		for (Course c : allCourses) {
//			System.out.println(c.toString());
//		}
		
		// ======================================

		// update an existing course
		Dao<Course> theCourseDao = new CourseDaoImpl();
		theCourseDao.update(new Course(300, null, "MySQL", null));

	}

}
