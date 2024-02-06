package com.cropify.entity;

import javax.persistence.Column;

public class UserDetails {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long mobileNo;
	private UserType userType;
	private String city;
	private String state;
	private String pincode;
	
	@Column
	private String fullAddress;
	
//	if value is 0 then user/seller is not verify
//	if value is +ve then user/seller is verify
	private byte verify;
	private long aadharNo;
	private String panNo;
	
//	if seller has poor review or if seller is fraud
//	in such cases Admin can/has ability to block seller
//	if status is "block" then seller cannot sell any products
	private String status;
}
