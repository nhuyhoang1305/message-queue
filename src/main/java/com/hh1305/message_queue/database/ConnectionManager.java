package com.hh1305.message_queue.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hh1305.message_queue.constants.Constants;

public class ConnectionManager {
	private static Connection connection = null;

	private ConnectionManager() {

	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD);
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
