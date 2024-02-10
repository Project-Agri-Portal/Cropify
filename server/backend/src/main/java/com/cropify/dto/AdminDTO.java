package com.cropify.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	private Long adminId;
	private String firstName;
	private String lastName;
	private String adminMobile;
	private String email;
	private String password;
	private LocalDate joinDate;
	private boolean isRootAdmin;
	
	// ---------------------- To String ---------------------------
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", adminMobile="
				+ adminMobile + ", email=" + email + ", joinDate=" + joinDate + ", isRootAdmin=" + isRootAdmin + "]";
	}
}
