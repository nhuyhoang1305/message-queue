package com.hh1305.message_queue.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
	public static ResultSet query(String _query) {
		try {
			return ConnectionManager.getConnection().createStatement().executeQuery(_query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void insert(String query) {
		try {
			ConnectionManager.getConnection().createStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
