/**
 * 
 */
package com.hospitalmanagement.utils;

import com.hospitalmanagement.exception.InputConstraintsNotAsExpectedException;

/**
 * @author rahul
 *
 */
public class DriverUtils {
	public int stringToInteger(String s) throws InputConstraintsNotAsExpectedException {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			throw new InputConstraintsNotAsExpectedException("This Input cannot be converted to int");
		}
	}
}
