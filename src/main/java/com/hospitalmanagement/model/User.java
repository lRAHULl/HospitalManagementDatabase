package com.hospitalmanagement.model;

import java.sql.Date;

public class User {
	private int userId;
	private int userRoleId;
	private String userFirstname;
	private String userLastname;
	private int userAge;
	private String username;
	private String userPassword;
	private int isActive;
	private String userStreet;
	private String userCity;
	private String userState;
	private Date userCreatedOn;
	private Date userUpdatedOn;
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserFirstname() {
		return userFirstname;
	}
	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}
	public String getUserLastname() {
		return userLastname;
	}
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int isIs_active() {
		return isActive;
	}
	public void setIs_active(int is_active) {
		this.isActive = is_active;
	}
	public String getUserStreet() {
		return userStreet;
	}
	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public Date getUserCreatedOn() {
		return userCreatedOn;
	}
	public void setUserCreatedOn(Date userCreatedOn) {
		this.userCreatedOn = userCreatedOn;
	}
	public Date getUserUpdatedOn() {
		return userUpdatedOn;
	}
	public void setUserUpdatedOn(Date userUpdatedOn) {
		this.userUpdatedOn = userUpdatedOn;
	}

	public String userToString() {
		return "User [usertId=" + userId + ", userFirstname=" + userFirstname + ", userLastname=" + userLastname
				+ ", userAge=" + userAge + ", username=" + username + ", userPassword=" + userPassword + ", is_active="
				+ isActive + ", userStreet=" + userStreet + ", userCity=" + userCity + ", userState=" + userState
				+ ", userCreatedOn=" + userCreatedOn + ", userUpdatedOn=" + userUpdatedOn + "]";
	}
}
