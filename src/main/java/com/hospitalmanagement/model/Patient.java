package com.hospitalmanagement.model;

public class Patient extends User {
	private int patientId;
	private float weight;
	private float height;
	private String bloodGroup;
	private double patientDueAmount;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public double getAmount() {
		return patientDueAmount;
	}
	public void setAmount(double amount) {
		this.patientDueAmount = amount;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", weight=" + weight + ", height=" + height
				+ ", bloodGroup=" + bloodGroup + ", patientDueAmount=" + patientDueAmount + "]";
	}	
	
}
