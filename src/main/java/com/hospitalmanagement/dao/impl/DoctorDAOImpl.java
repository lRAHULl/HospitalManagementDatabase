/**
 * 
 */
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

import com.hospitalmanagement.dao.DoctorDAO;
import com.hospitalmanagement.dao.connection.DAOConfig;
import com.hospitalmanagement.model.Doctor;

import static com.hospitalmanagement.dao.constants.DAOConstants.*;
import static com.hospitalmanagement.dao.constants.DoctorDAOConstants.*;

/**
 * @author rahul
 *
 */
public class DoctorDAOImpl implements DoctorDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorDAOImpl.class);
	DAOConfig daoConfig = new DAOConfig();
	
	@Override
	public boolean createDoctor(Doctor doctor) throws SQLException {
		Connection connection = null;
		int status = 0;
		try {
			String userInsertionquery = USER_INSERT_QUERY;
			connection = daoConfig.getDatabaseConnection();
			PreparedStatement userTablePreparedStatement = connection.prepareStatement(userInsertionquery, Statement.RETURN_GENERATED_KEYS);
			userTablePreparedStatement.setInt(1, 3);
			userTablePreparedStatement.setString(2, doctor.getUserFirstname());
			userTablePreparedStatement.setString(3, doctor.getUserLastname());
			userTablePreparedStatement.setInt(4, doctor.getUserAge());
			userTablePreparedStatement.setString(5, doctor.getUsername());
			userTablePreparedStatement.setString(6, doctor.getUserPassword());
			userTablePreparedStatement.setString(7, doctor.getUserStreet());
			userTablePreparedStatement.setString(8, doctor.getUserCity());
			userTablePreparedStatement.setString(9, doctor.getUserState());
			
			userTablePreparedStatement.executeUpdate();
			ResultSet primaryKeys = userTablePreparedStatement.getGeneratedKeys();
			
			if (primaryKeys.next()) {
				doctor.setUserId(primaryKeys.getInt(1));
				String patientInsertionquery = DOCTOR_INSERT_QUERY;
				PreparedStatement patientTablePreparedStatement = connection.prepareStatement(patientInsertionquery);
				patientTablePreparedStatement.setInt(1, doctor.getUserId());
				patientTablePreparedStatement.setString(2, doctor.getSpecialization());
				
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
	public List<Doctor> readAllDoctors() {
		Connection connection = null;
		List<Doctor> readDoctors = new ArrayList<Doctor>();
		try {
			connection = daoConfig.getDatabaseConnection();
			Statement statement = connection.createStatement();
			String doctorReadquery = DOCTOR_READ_QUERY;
			ResultSet readResults = statement.executeQuery(doctorReadquery);
			
			
			while(readResults.next()) {
				Doctor doctor = new Doctor();
				doctor.setUserId(readResults.getInt(1));
				doctor.setDoctorId(readResults.getInt(2));
				doctor.setUsername(readResults.getString(3));
				doctor.setUserPassword(readResults.getString(4));
				doctor.setUserFirstname(readResults.getString(5));
				doctor.setUserLastname(readResults.getString(6));
				doctor.setUserAge(readResults.getInt(7));
				doctor.setSpecialization(readResults.getString(8));
				doctor.setUserStreet(readResults.getString(9));
				doctor.setUserCity(readResults.getString(10));
				doctor.setUserState(readResults.getString(11));
				doctor.setUserCreatedOn(readResults.getDate(12));
				doctor.setUserUpdatedOn(readResults.getDate(13));
				readDoctors.add(doctor);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);
		}
		return readDoctors;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) throws SQLException {

		Connection connection = null;
		int status = 0;
		try {
			connection = daoConfig.getDatabaseConnection();
			String userUpdateQuery = USER_UPDATE_QUERY;
			PreparedStatement userTablePreparedStatement = connection.prepareStatement(userUpdateQuery);
			userTablePreparedStatement.setString(ONE, doctor.getUserFirstname());
			userTablePreparedStatement.setString(TWO, doctor.getUserLastname());
			userTablePreparedStatement.setString(THREE, doctor.getUsername());
			userTablePreparedStatement.setString(FOUR, doctor.getUserPassword());
			userTablePreparedStatement.setString(FIVE, doctor.getUserStreet());
			userTablePreparedStatement.setString(SIX, doctor.getUserCity());
			userTablePreparedStatement.setString(SEVEN, doctor.getUserState());
			userTablePreparedStatement.setInt(EIGHT, doctor.getUserAge());
			userTablePreparedStatement.setInt(NINE, doctor.getUserId());
			status = userTablePreparedStatement.executeUpdate();
			
			if (status == 1) {
				String patientUpdateQuery = DOCTOR_UPDATE_QUERY;
				PreparedStatement patientTablePreparedStatement = connection.prepareStatement(patientUpdateQuery);
//				"UPDATE t_doctor SET specialization=? WHERE fk_user_id=?"
				patientTablePreparedStatement.setString(ONE, doctor.getSpecialization());
				patientTablePreparedStatement.setInt(TWO, doctor.getUserId());
				
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
	public boolean deleteDoctor(Doctor doctor) {
		Connection connection = null;
		int status = 0;
		try {
			connection = daoConfig.getDatabaseConnection();
			String userUpdateQuery = USER_DELETE_QUERY;
			PreparedStatement userTablePreparedStatement = connection.prepareStatement(userUpdateQuery);
			userTablePreparedStatement.setInt(ONE, 0);
			userTablePreparedStatement.setInt(TWO, doctor.getUserId());
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
