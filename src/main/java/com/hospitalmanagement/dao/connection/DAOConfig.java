package com.hospitalmanagement.dao.connection;

import static com.hospitalmanagement.dao.constants.PatientDAOConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOConfig {
private static final Logger LOGGER = LoggerFactory.getLogger(DAOConfig.class);

	public Connection getDatabaseConnection() {
		try {
			Connection hospitalManagementDatabaseConnection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			LOGGER.info("New DB Connection created");
			return hospitalManagementDatabaseConnection;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public boolean closeDatabaseConnection(Connection hospitalManagementDatabaseConnection) {
		if (hospitalManagementDatabaseConnection != null) {
			try {
				hospitalManagementDatabaseConnection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			LOGGER.info("DB Connection Closed");
			return true;
		} else {
			return false;
		}
	}
}	