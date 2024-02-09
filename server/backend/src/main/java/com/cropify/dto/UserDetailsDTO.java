package com.cropify.dto;

import javax.validation.constraints.Size;

import com.cropify.entity.UserAddress;
import com.cropify.entity.UserType;

public class UserDetailsDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	@Size(min = 6)
	private String password;
	private long mobileNo;
	private UserType userType;
	private UserAddress userAddress;
	private byte verify;
	private long aadharNo;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
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
	public byte getVerify() {
		return verify;
	}
	public void setVerify(byte verify) {
		this.verify = verify;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
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
	
	// ------------- ToString() -----------------
	@Override
	public String toString() {
		return "UserDetailsDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", userType=" + userType + ", userAddress=" + userAddress + ", verify="
				+ verify + "]";
	}
	
}
