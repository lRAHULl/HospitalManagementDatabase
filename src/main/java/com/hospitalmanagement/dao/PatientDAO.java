/**
 * 
 */
package com.hospitalmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.model.Patient;

/**
 * @author rahul
 *
 */
public interface PatientDAO {
	public boolean createPatient(Patient patient) throws SQLException;
	public List<Patient> readAllPatients();
	public boolean updatePatient(Patient patient) throws SQLException;
	public boolean deletePatient(Patient patient) throws SQLException;
}

