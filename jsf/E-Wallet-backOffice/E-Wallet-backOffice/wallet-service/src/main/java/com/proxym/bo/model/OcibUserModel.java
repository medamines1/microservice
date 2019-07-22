package com.proxym.bo.model;

import java.util.List;

public class OcibUserModel {
	public String id;
	public String userName;
	public String customerNumber;
	public String firstName;
	public String lastName;
	public String usedPhoneNumber;
	public boolean enabled;
	
	
	
	
	
	public OcibUserModel(String id, String userName, String customerNumber, String firstName, String lastName,
			String usedPhoneNumber, boolean enabled) {
		super();
		this.id = id;
		this.userName = userName;
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.usedPhoneNumber = usedPhoneNumber;
		this.enabled = enabled;
	}
	
	
	public OcibUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsedPhoneNumber() {
		return usedPhoneNumber;
	}
	public void setUsedPhoneNumber(String usedPhoneNumber) {
		this.usedPhoneNumber = usedPhoneNumber;
	}
	
	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
	@Override
	public String toString() {
		return "QIIBUserModel [id=" + id + ", userName=" + userName + ", customerNumber=" + customerNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", usedPhoneNumber=" + usedPhoneNumber
				+ ", enable=" + enabled + "]";
	}
	
	
	
	

}
