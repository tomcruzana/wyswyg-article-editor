package com.wyswyg.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton database connection
public class DbConnector {
	private static Connection con = null;

	static {
		String JdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "system";
		String password = "Password123";

		try {
			Class.forName(JdbcDriver);
			con = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
