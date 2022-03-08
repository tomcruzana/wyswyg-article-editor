package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.wyswyg.domain.Page;
import com.wyswyg.utils.DbConnector;

public class PageDaoImpl implements Dao<Page> {

	@Override
	public int add(Page obj) throws SQLException {
		// convert obj to a page object
		Page thePage = obj;
		System.out.println("LOG: conversion success!");
		System.out.println("LOG: " + thePage.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try (Connection dbCon = DbConnector.getConnection();) {
			System.out.println("LOG: connection success!");
			ps = dbCon.prepareStatement("INSERT INTO page VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, thePage.getId());
			ps.setString(2, thePage.getComponents());
			ps.setString(3, thePage.getTitle());
			ps.setInt(4, thePage.getNumber());
			ps.setString(5, thePage.getChapter().getId());

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
		// TODO Auto-generated method stub

	}

	@Override
	public Page get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Page> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Page course) throws SQLException {
		// TODO Auto-generated method stub

	}
}
