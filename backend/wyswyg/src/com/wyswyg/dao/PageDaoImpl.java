package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.wyswyg.domain.Page;
import com.wyswyg.utils.DbConnector;

public class PageDaoImpl implements Dao<Page> {
	private static Logger log = Logger.getLogger(PageDaoImpl.class);
	
	@Override
	public int add(Page obj) throws SQLException {
		// convert obj to a page object
		Page thePage = obj;
		log.info("Conversion success!");
		log.info(thePage.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try (Connection dbCon = DbConnector.getConnection();) {
			log.info("Connection success!");
			ps = dbCon.prepareStatement("INSERT INTO page VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, thePage.getId());
			ps.setString(2, thePage.getComponents());
			ps.setString(3, thePage.getTitle());
			ps.setInt(4, thePage.getNumber());
			ps.setString(5, thePage.getChapter().getId());

			rowsAffected = ps.executeUpdate();
			log.info("SQL update executed");

		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

		return rowsAffected;
	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Page get(String id) throws SQLException {
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
