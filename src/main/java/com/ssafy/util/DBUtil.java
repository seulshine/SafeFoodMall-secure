package com.ssafy.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static DBUtil util = new DBUtil();
	public static DBUtil getUtil() {
		return util;
	}

	private DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			initProp();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initProp() throws IOException {
		Properties props = new Properties();
		props.load(DBUtil.class.getResourceAsStream("dbconfig.properties"));
		this.name = props.getProperty("name");
		this.url = props.getProperty("url");
		this.pass = props.getProperty("pass");
	}

	String url;
	String name;
	String pass;

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, pass);
	}

	public void close(ResultSet rset) {
		if (rset != null)
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void rollback(Connection con) {
		if (con != null)
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
