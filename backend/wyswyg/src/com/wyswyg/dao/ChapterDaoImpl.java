package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;
import com.wyswyg.utils.DbConnector;

public class ChapterDaoImpl implements Dao<Chapter> {
	private static Logger log = Logger.getLogger(ChapterDaoImpl.class);

	@Override
	public int add(Chapter obj) throws SQLException {
		// convert obj to a chapter object
		Chapter theChapter = obj;
		log.info("Conversion success!");
		log.info(theChapter.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");
			ps = dbCon.prepareStatement("INSERT INTO chapter VALUES(?, ?, ?, ?)");
			ps.setString(1, theChapter.getId());
			ps.setString(2, theChapter.getTitle());
			ps.setInt(3, theChapter.getNumber());
			ps.setString(4, theChapter.getCourse().getId());

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

			ps = dbCon.prepareStatement("DELETE FROM chapter WHERE id = ?");
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
	public Chapter get(String id) throws SQLException {
		Chapter theChapter = null;
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");
			ps = dbCon.prepareStatement("SELECT * FROM chapter WHERE id = ?");
			ps.setString(1, id);

			// get the result set and move cursor to the first row
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				// initialize and return chapter object
				theChapter = new Chapter();

				theChapter.setId(resultSet.getString("id"));
				theChapter.setTitle(resultSet.getString("title"));
				theChapter.setNumber(resultSet.getInt("chapter_number"));

				Dao<Course> cdi = new CourseDaoImpl();
				Course course = cdi.get(resultSet.getString("course_id"));
				theChapter.setCourse(course);

				log.info("SQL query executed");
			} else {
				log.info("No chapters found!");
			}

		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

		return theChapter;
	}

	@Override
	public List<Chapter> getAll() throws SQLException {
		PreparedStatement ps;
		List<Chapter> chapterList = new ArrayList<>();
		Dao<Course> cdi = new CourseDaoImpl();

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			// TODO : finalize this query for get all
			ps = dbCon.prepareStatement(
					"SELECT chapter.id, chapter.title, chapter.chapter_number, course.id FROM course INNER JOIN chapter ON course.id = chapter.course_id WHERE course.id=?");
			ps.setString(1, "CJ100");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				chapterList.add(new Chapter(resultSet.getString("id"), null, resultSet.getString("title"),
						resultSet.getInt("chapter_number"), null));
			}
			log.info("SQL query executed");
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}
		return chapterList;
	}

	@Override
	public void update(Chapter chapter) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			ps = dbCon.prepareStatement("UPDATE chapter SET title = ?, chapter_number = ?  WHERE id = ?");
			ps.setString(1, chapter.getTitle());
			ps.setInt(2, chapter.getNumber());
			ps.setString(3, chapter.getId());

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
