package com.cropify.dto;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long adminId;
	private String firstName;
	private String lastName;
	private String adminMobile;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinDate;
	private String isRootAdmin;
	
	// ---------------------- To String ---------------------------
	// @Override
	// public String toString() {
	// 	return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", adminMobile="
	// 			+ adminMobile + ", email=" + email + ", joinDate=" + joinDate + ", isRootAdmin=" + isRootAdmin + "]";
	// }
}
