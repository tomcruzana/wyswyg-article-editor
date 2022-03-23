package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
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
		try {
			Connection dbCon = DbConnector.getConnection();
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
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success! " + this.getClass());

			ps = dbCon.prepareStatement("DELETE FROM page WHERE id = ?");
			ps.setString(1, id);
			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				log.info(rowCount + " row deleted!");
				log.info("SQL update executed");
			} else {
				log.info("No records found!");
			}
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

	}

	@Override
	public Page get(String id) throws SQLException {
		Page thePage = null;
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");
			ps = dbCon.prepareStatement("SELECT * FROM page WHERE id = ?");
			ps.setString(1, id);

			// get the result set and move cursor to the first row
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				// initialize and return chapter object
				thePage = new Page();

				thePage.setId(resultSet.getString("id"));
				thePage.setTitle(resultSet.getString("title"));
				thePage.setComponents(resultSet.getString("components"));
				thePage.setNumber(resultSet.getInt("page_number"));

				Dao<Chapter> chdi = new ChapterDaoImpl();
				Chapter chapter = chdi.get(resultSet.getString("chapter_id"));
				thePage.setChapter(chapter);

				log.info("SQL query executed");
			} else {
				log.info("No chapters found!");
			}

		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

		return thePage;
	}

	@Override
	public List<Page> getAll() throws SQLException {
		PreparedStatement ps;
		List<Page> pageList = new ArrayList<>();

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			ps = dbCon.prepareStatement("SELECT * FROM page ORDER BY id ASC");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				// TODO: try a left join instead
				pageList.add(new Page(resultSet.getString("id"), resultSet.getString("components"),
						resultSet.getString("title"), resultSet.getInt("page_number"), null));
			}
			log.info("SQL query executed");
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}
		return pageList;
	}

	@Override
	public void update(Page page) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			ps = dbCon.prepareStatement("UPDATE page SET components = ?, title = ?, page_number = ? WHERE id = ?");
			ps.setString(1, page.getComponents());
			ps.setString(2, page.getTitle());
			ps.setInt(3, page.getNumber());
			ps.setString(4, page.getId());

			int rowCount = ps.executeUpdate();
			log.info(rowCount + " row updated!");
			log.info("SQL update executed");
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

	}
}
