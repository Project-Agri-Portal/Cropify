package com.cropify.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cropify.entity.UserAddress;
import com.cropify.entity.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDetailsDTO {
	
//	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Password")
	private String password;
	private String mobileNo;
	private UserType userType;
	private UserAddress userAddress;
	private String aadharNo;
	private String panNo;
	private String status;
	
	// ---------------- Getter & Setter --------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public UserDetailsDTO() {}
	public UserDetailsDTO(Long id) {
		this.id = id;
	}
	public UserDetailsDTO(Long id, String firstName, String lastName, String email,
			@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Password") String password,
			String mobileNo, UserType userType, UserAddress userAddress, String aadharNo, String panNo, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.userType = userType;
		this.userAddress = userAddress;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.status = status;
	}
	
	// ------------- ToString() -----------------
//	@Override
//	public String toString() {
//		return "UserDetailsDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", mobileNo=" + mobileNo + ", userType=" + userType + ", userAddress=" + userAddress + "]";
//	}
	
}
