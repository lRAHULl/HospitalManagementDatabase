package com.hospitalmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hospitalmanagement.dao.PatientDAO;
import com.hospitalmanagement.dao.connection.DAOConfig;
import com.hospitalmanagement.model.Patient;

public class PatientDAOImpl implements PatientDAO {

	DAOConfig daoConfig = new DAOConfig();
	
	@Override
	public Patient createPatient(Patient patient) {
		Connection connection = null;
		String query = "INSERT INTO t_patient (fk_user_id) VALUES (?)";
		try {
			connection = daoConfig.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, patient.getUserId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);
		}
		
		return patient;
	}

}
