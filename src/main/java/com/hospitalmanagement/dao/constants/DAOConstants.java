/**
 * 
 */
package com.hospitalmanagement.dao.constants;

/**
 * @author VC
 *
 */
public class DAOConstants {
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hospital_management";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1234";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String USER_INSERT_QUERY = "INSERT INTO t_user (fk_role_id, firstname, lastname, age, username, password, street, city, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String USER_UPDATE_QUERY = "UPDATE t_user SET firstname=?, lastname=?,username=?,password=?,street=?,city=?,state=?,age=? WHERE pk_user_id=?";
	public static final String USER_DELETE_QUERY = "UPDATE t_user SET is_active=? WHERE pk_user_id=?";
	
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
}
