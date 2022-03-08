package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.utils.DbConnector;

public class CourseDaoImpl implements Dao<Course> {

	@Override
	public int add(Course obj) {
		// convert obj to a course object
		Course theCourse = obj;
		System.out.println("LOG: conversion success!");
		System.out.println("LOG: " + theCourse.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("INSERT INTO course VALUES(?, ?, ?, ?)");
			ps.setString(1, theCourse.getId());
			ps.setString(2, theCourse.getTitle());
			ps.setDate(3, theCourse.getDateCreated());
			ps.setNull(4, Types.NULL);
			rowsAffected = ps.executeUpdate();
			System.out.println("LOG: sql update executed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}

	@Override
	public void delete(String id) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success! " + this.getClass());
			ps = dbCon.prepareStatement("DELETE FROM course WHERE id = ?");
			ps.setString(1, id);
			int rowCount = ps.executeUpdate();

			System.out.println("LOG: " + rowCount + " row deleted!");
			System.out.println("LOG: sql update executed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Course get(String id) throws SQLException {
		Course theCourse = null;
		PreparedStatement ps;

		// setup and create a prepared statement
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("SELECT * FROM course WHERE id = ?");
			ps.setString(1, id);

			// get the result set and move cursor to the first row
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				// initialize and return course object
				theCourse = new Course();
				theCourse.setId(resultSet.getString("id"));
				theCourse.setTitle(resultSet.getString("title"));
				theCourse.setDateCreated(resultSet.getDate("date_created"));
				System.out.println("LOG: sql query executed");
			} else {
				System.out.println("LOG: no courses found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return theCourse;
	}

	@Override
	public List<Course> getAll() throws SQLException {
		PreparedStatement ps;
		List<Course> courseList = new ArrayList<>();

		// setup and create a prepared statement
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("SELECT * FROM course ORDER BY id ASC");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				courseList.add(new Course(resultSet.getString("id"), null, resultSet.getString("title"),
						resultSet.getDate("date_created")));
			}
			System.out.println("LOG: sql query executed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public void update(Course course) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("UPDATE course SET title = ?, date_created = ?  WHERE id = ?");
			ps.setString(1, course.getTitle());
			ps.setDate(2, course.getDateCreated());
			ps.setString(3, course.getId());
			// TODO: ps.setString(4, course.getChapters()); junction table needed

			int rowCount = ps.executeUpdate();
			System.out.println("LOG: " + rowCount + " row updated!");
			System.out.println("LOG: sql update executed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addChapterToCourse(Chapter chapter, Course course) throws SQLException {
		// convert obj to a course object
		Course theCourse = course;
		System.out.println("LOG: conversion success!");
		System.out.println("LOG: " + theCourse.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("UPDATE course SET chapter_id = ? WHERE id = ?");

			// To-Do: create a reusable method for this and move to utils package
			String chapterId = new ArrayList<>(theCourse.getChapters()).get(0).getId();
			ps.setString(1, chapterId);
			ps.setString(2, theCourse.getId());

			rowsAffected = ps.executeUpdate();
			System.out.println("LOG: sql update executed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}

}
