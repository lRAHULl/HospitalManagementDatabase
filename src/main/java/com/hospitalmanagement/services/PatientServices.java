/**
 * 
 */
package com.hospitalmanagement.services;

import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.model.Patient;

/**
 * @author rahul
 *
 */
public interface PatientServices {
	public boolean createPatientService(Patient patient) throws SQLException;
	public List<Patient> readPatientsService();
}
