/**
 * 
 */
package com.hospitalmanagement.service.impl;

import com.hospitalmanagement.dao.UserDAO;
import com.hospitalmanagement.dao.impl.PatientDAOImpl;
import com.hospitalmanagement.dao.impl.UserDAOImpl;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.model.User;
import com.hospitalmanagement.service.UserServices;

/**
 * @author rahul
 *
 */
public class UserServiceImpl implements UserServices {

	@Override
	public boolean createPatientService(User user, Patient patient) {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
		User newUser = userDAOImpl.createUser(user);
		patient.setUserId(newUser.getUsertId());
		Patient newPatient = patientDAOImpl.createPatient(patient);
		return true;
	}
	
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user = new User();
		user.setUserFirstname("Rahul");
		user.setUserAge(19);
		user.setUserLastname("Raju");
		user.setUsername("rahul");
		user.setUserPassword("rahul");
		user.setUserStreet("Palo Alto");
		user.setUserCity("SF");
		user.setUserState("Cal");
		
		Patient patient = new Patient();
		userServiceImpl.createPatientService(user, patient);
	}

}
