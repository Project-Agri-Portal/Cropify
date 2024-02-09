package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserAddress {
	
	@Column(nullable = false, length = 50)
	private String city;
	
	@Column(nullable = false, length = 50)
	private String state;
	
	@Column(nullable = false, length = 80)
	private String pincode;
	
	@Column(name = "full_address", nullable = false)
	private String fullAddress;
	
	//-----------------------------Getter and Setters--------------------

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	
}
