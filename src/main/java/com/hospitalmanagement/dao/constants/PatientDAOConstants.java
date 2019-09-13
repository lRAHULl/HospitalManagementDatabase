package com.hospitalmanagement.dao.constants;

public class PatientDAOConstants {
	public static final String PATIENT_INSERT_QUERY = "INSERT INTO t_patient (fk_user_id, weight, height, blood_group) VALUES (?, ?, ?, ?)";
	public static final String PATIENT_READ_QUERY = "SELECT t_user.pk_user_id, t_patient.pk_patient_id, t_user.username, t_user.password, t_user.firstname, t_user.lastname, t_user.age, t_user.street, t_user.city, t_user.state, t_patient.weight, t_patient.height, t_patient.blood_group, t_patient.amount_due, t_user.created_on, t_user.last_updated from t_user LEFT JOIN t_patient ON t_user.pk_user_id = t_patient.fk_user_id WHERE t_user.is_active = 1 AND t_user.fk_role_id = 2";
	public static final String PATIENT_UPDATE_QUERY = "UPDATE t_patient SET amount_due=?, weight=?, height=?,blood_group=? WHERE fk_user_id=?";
}
