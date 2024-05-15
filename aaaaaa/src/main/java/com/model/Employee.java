package com.model;

public class Employee {

	private int id;
	private String name;
	private String emailId;
	private String moNumber;
	
	public Employee() {
		
	}
	public Employee(int id, String name, String emailId, String moNumber) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.moNumber = moNumber;
	}
	
	public Employee(String name, String emailId, String moNumber) {
		this.name = name;
		this.emailId = emailId;
		this.moNumber = moNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMoNumber() {
		return moNumber;
	}

	public void setMoNumber(String moNumber) {
		this.moNumber = moNumber;
	}
	
}
