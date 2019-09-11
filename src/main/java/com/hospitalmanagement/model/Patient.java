package com.hospitalmanagement.model;

public class Patient {
	private int patientId;
	private int userId;
	private double patientDueAmount;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return patientDueAmount;
	}
	public void setAmount(double amount) {
		this.patientDueAmount = amount;
	}
	
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", userId=" + userId + ", amount=" + patientDueAmount + "]";
	}
}
