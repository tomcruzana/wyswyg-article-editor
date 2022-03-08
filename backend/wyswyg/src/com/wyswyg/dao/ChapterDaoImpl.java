package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;
import com.wyswyg.utils.DbConnector;

public class ChapterDaoImpl implements Dao<Chapter> {

	@Override
	public int add(Chapter obj) throws SQLException {
		// convert obj to a chapter object
		Chapter theChapter = obj;
		System.out.println("LOG: conversion success!");
		System.out.println("LOG: " + theChapter.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("INSERT INTO chapter VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, theChapter.getId());
			ps.setString(2, theChapter.getTitle());
			ps.setInt(3, theChapter.getNumber());
			ps.setNull(4, Types.NULL);
			ps.setString(5, theChapter.getCourse().getId());

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
		// TODO Auto-generated method stub

	}

	@Override
	public Chapter get(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chapter> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Chapter course) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int addPagetoChapter(Page page, Chapter chapter) throws SQLException {
		// convert obj to a course object
		Chapter theChapter = chapter;
		System.out.println("LOG: conversion success!");
		System.out.println("LOG: " + theChapter.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("UPDATE chapter SET page_id = ? WHERE id = ?");

			// To-Do: create a reusable method for this and move to utils package
			String pageId = new ArrayList<>(theChapter.getPages()).get(0).getId();
			ps.setString(1, pageId);
			ps.setString(2, theChapter.getId());

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
