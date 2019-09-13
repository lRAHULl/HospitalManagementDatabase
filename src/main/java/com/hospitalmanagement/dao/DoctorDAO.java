/**
 * 
 */
package com.hospitalmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.model.Doctor;

/**
 * @author rahul
 *
 */
public interface DoctorDAO {
	public boolean createDoctor(Doctor doctor) throws SQLException;
	public List<Doctor> readAllDoctors();
	public boolean updateDoctor(Doctor doctor) throws SQLException;
	public boolean deleteDoctor(Doctor doctor);
}
