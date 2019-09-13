package com.hospitalmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hospitalmanagement.dao.PatientDAO;
import com.hospitalmanagement.dao.connection.DAOConfig;
import com.hospitalmanagement.model.Patient;

import static com.hospitalmanagement.dao.constants.DAOConstants.*;
import static com.hospitalmanagement.dao.constants.PatientDAOConstants.*;

public class PatientDAOImpl implements PatientDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientDAOImpl.class);
	DAOConfig daoConfig = new DAOConfig();

	@Override
	public boolean createPatient(Patient patient) throws SQLException {
		Connection connection = null;
		int status = 0;
		try {
			String userInsertionquery = USER_INSERT_QUERY;
			connection = daoConfig.getDatabaseConnection();
			PreparedStatement userTablePreparedStatement = connection.prepareStatement(userInsertionquery, Statement.RETURN_GENERATED_KEYS);
			userTablePreparedStatement.setInt(ONE, patient.getUserRoleId());
			userTablePreparedStatement.setString(TWO, patient.getUserFirstname());
			userTablePreparedStatement.setString(THREE, patient.getUserLastname());
			userTablePreparedStatement.setInt(FOUR, patient.getUserAge());
			userTablePreparedStatement.setString(FIVE, patient.getUsername());
			userTablePreparedStatement.setString(SIX, patient.getUserPassword());
			userTablePreparedStatement.setString(SEVEN, patient.getUserStreet());
			userTablePreparedStatement.setString(EIGHT, patient.getUserCity());
			userTablePreparedStatement.setString(NINE, patient.getUserState());
			
			userTablePreparedStatement.executeUpdate();
			ResultSet primaryKeys = userTablePreparedStatement.getGeneratedKeys();
			
			if (primaryKeys.next()) {
				patient.setUserId(primaryKeys.getInt(1));
				String patientInsertionquery = PATIENT_INSERT_QUERY;
				PreparedStatement patientTablePreparedStatement = connection.prepareStatement(patientInsertionquery);
				patientTablePreparedStatement.setInt(ONE, patient.getUserId());
				patientTablePreparedStatement.setFloat(TWO, patient.getWeight());
				patientTablePreparedStatement.setFloat(THREE, patient.getHeight());
				patientTablePreparedStatement.setString(FOUR, patient.getBloodGroup());
				
				status =  patientTablePreparedStatement.executeUpdate();
				connection.commit();
			}
			
			
		} catch (SQLException e) {
			connection.rollback();
			LOGGER.error(e.getMessage());
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);
		}
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Patient> readAllPatients() {
		Connection connection = null;
		List<Patient> patientsList = null;
		try {
			connection = daoConfig.getDatabaseConnection();
			Statement statement = connection.createStatement();
			String patientReadquery = PATIENT_READ_QUERY;
			ResultSet readResults = statement.executeQuery(patientReadquery);
			
			patientsList = new ArrayList<Patient>();
			while(readResults.next()) {
				Patient patient = new Patient();
				patient.setUserId(readResults.getInt(1));
				patient.setPatientId(readResults.getInt(2));
				patient.setUsername(readResults.getString(3));
				patient.setUserPassword(readResults.getString(4));
				patient.setUserFirstname(readResults.getString(5));
				patient.setUserLastname(readResults.getString(6));
				patient.setUserAge(readResults.getInt(7));
				patient.setUserStreet(readResults.getString(8));
				patient.setUserCity(readResults.getString(9));
				patient.setUserState(readResults.getString(10));
				patient.setWeight(readResults.getFloat(11));
				patient.setHeight(readResults.getFloat(12));
				patient.setBloodGroup(readResults.getString(13));
				patient.setAmount(readResults.getDouble(14));
				patient.setUserCreatedOn(readResults.getDate(15));
				patient.setUserUpdatedOn(readResults.getDate(16));
				patientsList.add(patient);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);
		}
		return patientsList;
	}

	@Override
	public boolean updatePatient(Patient patient) throws SQLException {
		Connection connection = null;
		int status = 0;
		try {
			connection = daoConfig.getDatabaseConnection();
			String userUpdateQuery = USER_UPDATE_QUERY;
			PreparedStatement userTablePreparedStatement = connection.prepareStatement(userUpdateQuery);
			userTablePreparedStatement.setString(ONE, patient.getUserFirstname());
			userTablePreparedStatement.setString(TWO, patient.getUserLastname());
			userTablePreparedStatement.setString(THREE, patient.getUsername());
			userTablePreparedStatement.setString(FOUR, patient.getUserPassword());
			userTablePreparedStatement.setString(FIVE, patient.getUserStreet());
			userTablePreparedStatement.setString(SIX, patient.getUserCity());
			userTablePreparedStatement.setString(SEVEN, patient.getUserState());
			userTablePreparedStatement.setInt(EIGHT, patient.getUserAge());
			userTablePreparedStatement.setInt(NINE, patient.getUserId());
			status = userTablePreparedStatement.executeUpdate();
			
			if (status == 1) {
				String patientUpdateQuery = PATIENT_UPDATE_QUERY;
				PreparedStatement patientTablePreparedStatement = connection.prepareStatement(patientUpdateQuery);
				patientTablePreparedStatement.setDouble(ONE, patient.getAmount());
				patientTablePreparedStatement.setDouble(TWO, patient.getWeight());
				patientTablePreparedStatement.setDouble(THREE, patient.getHeight());
				patientTablePreparedStatement.setString(FOUR, patient.getBloodGroup());
				patientTablePreparedStatement.setInt(FIVE, patient.getUserId());
				
				status = patientTablePreparedStatement.executeUpdate();
				connection.commit();
			}
		} catch (SQLException e) {
			connection.rollback();
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);	
		}
		if (status > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deletePatient(Patient patient) throws SQLException {
		Connection connection = null;
		int status = 0;
		try {
			connection = daoConfig.getDatabaseConnection();
			String userUpdateQuery = USER_DELETE_QUERY;
			PreparedStatement userTablePreparedStatement = connection.prepareStatement(userUpdateQuery);
			userTablePreparedStatement.setInt(1, 0);
			userTablePreparedStatement.setInt(2, patient.getUserId());
			status = userTablePreparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);	
		}
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	

}
