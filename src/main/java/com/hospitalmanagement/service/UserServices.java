/**
 * 
 */
package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.model.User;

/**
 * @author rahul
 *
 */
public interface UserServices {
	public boolean createPatientService(User user, Patient patient);
}
