/**
 * 
 */
package com.hospitalmanagement.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.hospitalmanagement.dao.impl.PatientDAOImpl;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.services.PatientServices;

/**
 * @author rahul
 *
 */
public class PatientServicesImpl implements PatientServices {

	@Override
	public boolean createPatientService(Patient patient) throws SQLException {
		PatientDAOImpl patientDAOImpl= new PatientDAOImpl();
		boolean status = patientDAOImpl.createPatient(patient);
		return status;
	}
	
	@Override
	public List<Patient> readPatientsService() {
		return new PatientDAOImpl().readAllPatients();
	}
	
//	public static void main(String[] args) {
//		PatientServicesImpl userServiceImpl = new PatientServicesImpl();
//		Patient patient = new Patient();
//		patient.setUserFirstname("Rahul");
//		patient.setUserAge(19);
//		patient.setUserLastname("Raju");
//		patient.setUsername("rahul4");
//		patient.setUserPassword("rahul");
//		patient.setUserStreet("Palo Alto");
//		patient.setUserRoleId(2);
//		patient.setUserCity("SF");
//		patient.setUserState("Cal");
//		patient.setWeight(85);
//		patient.setHeight(6.1f);
//		patient.setBloodGroup("A+ve");
//		
//	
//		System.out.println(userServiceImpl.createPatientService(patient));
//		
//		List<Patient> res = userServiceImpl.readPatientsService();
//		for (Patient patient: res) {
//			System.out.println(patient.userToString() + patient.toString());
//		}
//	}

	

}
