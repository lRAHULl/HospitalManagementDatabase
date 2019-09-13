/**
 * 
 */
package com.hospitalmanagement.dao;

import java.util.List;

import com.hospitalmanagement.model.User;

/**
 * @author rahul
 *
 */
public interface UserDAO {
	public User createUser(User user);
	public List<User> readUser();
}
