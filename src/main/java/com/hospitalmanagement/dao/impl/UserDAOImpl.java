/**
 * 
 */
package com.hospitalmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hospitalmanagement.dao.UserDAO;
import com.hospitalmanagement.dao.connection.DAOConfig;
import com.hospitalmanagement.model.User;

/**
 * @author VC
 *
 */
public class UserDAOImpl implements UserDAO {
	
	DAOConfig daoConfig = new DAOConfig();
	
	@Override
	public User createUser(User user) {
		Connection connection = null;
		String query = "INSERT INTO t_user (fk_role_id, firstname, lastname, age, username, password, street, city, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = daoConfig.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, user.getUserFirstname());
			preparedStatement.setString(3, user.getUserLastname());
			preparedStatement.setInt(4, user.getUserAge());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getUserPassword());
			preparedStatement.setString(7, user.getUserStreet());
			preparedStatement.setString(8, user.getUserCity());
			preparedStatement.setString(9, user.getUserState());
			
			preparedStatement.executeUpdate();
			ResultSet primaryKeys = preparedStatement.getGeneratedKeys();
			
			if (primaryKeys.next()) {
				user.setUsertId(primaryKeys.getInt(1));
			}
			System.out.println(user.getUsertId());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) 
				daoConfig.closeDatabaseConnection(connection);
		}
		
		return user;
		
	}
}
