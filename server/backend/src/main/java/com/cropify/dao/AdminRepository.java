package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	// Seller Count --> native query
	
	@Query( value="Select count(*) from user_details where user_type=:type",nativeQuery=true)
	int countOfSellers(
			@Param("type") String type
			);
	
	
	
	// Customer Count
	
	@Query( value="Select count(*) from user_details where user_type=:type",nativeQuery=true)
	int countOfCustomers(			
			@Param("type") String type
			);
	

	
	// Farmer Count
	
	@Query( value="Select count(*) from user_details where user_type=:type",nativeQuery=true)
	int countOfFarmers(
			@Param("type") String type
			);
	
	
	// Farmer Product Count (Types of product that all farmer sold)
	
	@Query(value="Select count(*) from farm_products",nativeQuery=true)
	int farmProductCount();
	
	// Agri Product Count (Types of product that all farmer sold)
	
	@Query(value="Select count(*) from agriculture_products",nativeQuery=true)
	int agriProductCount();
	
	// All machine Count (Types of product that all farmer sold)

	@Query(value="Select count(*) from machinery",nativeQuery=true)
	int machineCount();
}

