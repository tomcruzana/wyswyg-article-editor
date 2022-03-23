package com.wyswyg.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.configuration2.ex.ConfigurationException;

// singleton database connection
public class DbConnector {
	private static Connection con = null;

	private DbConnector() {
	}

	static {
		try {
			String JdbcDriver = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.jdbcdriver");
			String url = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.url");
			String userName = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.username");
			String password = PropertiesConfigurationFactory.getPropertiesConfiguration("app.db.password");
			Class.forName(JdbcDriver);
			con = DriverManager.getConnection(url, userName, password);
		} catch (ConfigurationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
