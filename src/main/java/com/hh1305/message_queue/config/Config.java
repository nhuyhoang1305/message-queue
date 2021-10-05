package com.hh1305.message_queue.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.hh1305.message_queue.database.Query;

public class Config {

	private int maxSize;
	private int timePush;
	private int timePull;
	private int numberOfProducers;
	private int numberOfConsumers;

	// Defaut config
	public Config() {
		maxSize = 10;
		timePush = 1;
		timePull = 3;
		numberOfProducers = 1;
		numberOfConsumers = 1;
	}

	public Config(int maxSize, int timePush, int timePull, int numberOfProducers, int numberOfConsumers) {
		super();
		this.maxSize = maxSize;
		this.timePush = timePush;
		this.timePull = timePull;
		this.numberOfProducers = numberOfProducers;
		this.numberOfConsumers = numberOfConsumers;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getTimePush() {
		return timePush;
	}

	public void setTimePush(int timePush) {
		this.timePush = timePush;
	}

	public int getTimePull() {
		return timePull;
	}

	public void setTimePull(int timePull) {
		this.timePull = timePull;
	}

	public int getNumberOfProducers() {
		return numberOfProducers;
	}

	public void setNumberOfProducers(int numberOfProducers) {
		this.numberOfProducers = numberOfProducers;
	}

	public int getNumberOfConsumers() {
		return numberOfConsumers;
	}

	public void setNumberOfConsumers(int numberOfConsumers) {
		this.numberOfConsumers = numberOfConsumers;
	}

	public void loadFromProperties(String fileName) {
		Properties properties = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\resources\\" + fileName;
		// System.out.println(path);
		try {
			properties.load(new FileReader(new File(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setMaxSize(Integer.valueOf(properties.getProperty("maxsizeofqueue")));
		setTimePull(Integer.valueOf(properties.getProperty("timepull")));
		setTimePush(Integer.valueOf(properties.getProperty("timepush")));
		setNumberOfConsumers(Integer.valueOf(properties.getProperty("numofconsumers")));
		setNumberOfProducers(Integer.valueOf(properties.getProperty("numofproducers")));

	}

	public void loadConfigFromDB() {
		String query = "SELECT * FROM config";
		ResultSet rs = Query.query(query);

		if (rs != null) {
			try {

				rs.next();
				setMaxSize(rs.getInt(1));
				setTimePush(rs.getInt(2));
				setTimePull(rs.getInt(3));
				setNumberOfProducers(rs.getInt(4));
				setNumberOfConsumers(rs.getInt(5));

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
