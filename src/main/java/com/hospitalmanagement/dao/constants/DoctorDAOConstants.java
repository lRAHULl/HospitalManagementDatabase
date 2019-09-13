package com.hospitalmanagement.dao.constants;

public class DoctorDAOConstants {
	public static final String DOCTOR_INSERT_QUERY = "INSERT INTO t_doctor (fk_user_id, specialization) VALUES (?, ?)";
	public static final String DOCTOR_READ_QUERY = "SELECT t_user.pk_user_id, t_doctor.pk_doctor_id, t_user.username, t_user.password, t_user.firstname, t_user.lastname, t_user.age, t_doctor.specialization, t_user.street, t_user.city, t_user.state,t_user.created_on, t_user.last_updated from t_user LEFT JOIN t_doctor ON t_user.pk_user_id = t_doctor.fk_user_id WHERE t_user.is_active = 1 AND t_user.fk_role_id = 3";
	public static final String DOCTOR_UPDATE_QUERY = "UPDATE t_doctor SET specialization=? WHERE fk_user_id=?";
}
