package com.hospitalmanagement.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.dao.impl.DoctorDAOImpl;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.services.DoctorServices;

public class DoctorServicesImpl implements DoctorServices {
	@Override
	public boolean createDoctorService(Doctor doctor) throws SQLException {
		DoctorDAOImpl doctorDAOImpl= new DoctorDAOImpl();
		boolean status = doctorDAOImpl.createDoctor(doctor);
		return status;
	}
	
	@Override
	public List<Doctor> readAllDoctorsService() {
		return new DoctorDAOImpl().readAllDoctors();
	}
	
//	public static void main(String[] args) {
//		DoctorDAOImpl doctorDAOImpl = new DoctorDAOImpl();
//		Doctor doctor = new Doctor();
//		doctor.setUserFirstname("Rahul");
//		doctor.setUserAge(19);
//		doctor.setUserLastname("Raju");
//		doctor.setUsername("rahuldoc1");
//		doctor.setUserPassword("rahul");
//		doctor.setUserStreet("Palo Alto");
//		doctor.setUserRoleId(2);
//		doctor.setUserCity("SF");
//		doctor.setUserState("Cal");
//		doctor.setSpecialization("MBBS");
//		System.out.println(doctorDAOImpl.createDoctor(doctor));
//	}
}
