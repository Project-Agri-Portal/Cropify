package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	// Seller Count
	
	@Query("Select count(*) from UserDetails u where u.userType=:type")
	int countOfSellers(
			@Param("type") String type
			);
	
	// Customer Count
	
	@Query("Select count(*) from UserDetails u where u.userType=:type")
	int countOfCustomer(
			@Param("type") String type
			);
	
	// Farmer Count
	
	@Query("Select count(*) from UserDetails u where u.userType=:type")
	int countOfFarmer(
				@Param("type") String type
				);
	
}

