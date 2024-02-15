package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "admin_mobile", length = 10, nullable = false, unique = true)
	private String adminMobile;
	
	@Column(name = "admin_email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "admin_password", nullable = false, unique = true)
	private String password;
	
	@Column(name = "join_date", nullable = false)
	private LocalDate joinDate;
	
	@Column(name = "root_admin", nullable = false)
	private String isRootAdmin;
	
	// ------------------ Constructors ---------------------------
	public Admin() {}
	
	public Admin(Long adminId, String firstName, String lastName, String adminMobile, String email, String password,
			LocalDate joinDate, String isRootAdmin) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminMobile = adminMobile;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.isRootAdmin = isRootAdmin;
	}
}	
