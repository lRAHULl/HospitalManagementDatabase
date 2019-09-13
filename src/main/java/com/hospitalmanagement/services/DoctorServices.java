package com.hospitalmanagement.services;

import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.model.Doctor;

public interface DoctorServices {
	public boolean createDoctorService(Doctor doctor) throws SQLException;
	public List<Doctor> readAllDoctorsService();
}
