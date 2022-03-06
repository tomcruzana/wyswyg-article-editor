package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			ps.setInt(1, theCourse.getId());
			ps.setString(2, theCourse.getTitle());
			ps.setDate(3, theCourse.getDateCreated());
			
			// To-Do: figure out how to insert the chapter object!!!
			ps.setString(4, theCourse.getChapters());
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
	public void delete(int id) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("DELETE FROM course WHERE id = ?");
			ps.setInt(1, id);
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
	public Course get(int id) throws SQLException {
		Course theCourse = null;
		PreparedStatement ps;

		// setup and create a prepared statement
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("SELECT * FROM course WHERE id = ?");
			ps.setInt(1, id);

			// get the result set and move cursor to the first row
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();

			// initialize and return course object
			theCourse = new Course(resultSet.getInt("id"), null, resultSet.getString("title"),
					resultSet.getDate("date_created"));
			System.out.println("LOG: sql query executed");

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
				courseList.add(new Course(resultSet.getInt("id"), null, resultSet.getString("title"),
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
			ps = dbCon.prepareStatement("UPDATE course SET title = ? WHERE id = ?");
			ps.setString(1, course.getTitle());
			ps.setInt(2, course.getId());

			int rowCount = ps.executeUpdate();
			System.out.println("LOG: " + rowCount + " row updated!");
			System.out.println("LOG: sql update executed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
