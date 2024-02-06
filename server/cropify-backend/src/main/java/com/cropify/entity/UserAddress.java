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
}
