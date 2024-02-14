package com.cropify.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long adminId;
	private String firstName;
	private String lastName;
	private String admin_Mobile;
	private String email;
	private String password;
	private LocalDate joinDate;
	private boolean isRootAdmin;
	
	// ---------------------- To String ---------------------------
//	@Override
//	public String toString() {
//		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", adminMobile="
//				+ adminMobile + ", email=" + email + ", joinDate=" + joinDate + ", isRootAdmin=" + isRootAdmin + "]";
//	}
}
