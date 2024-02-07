package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.FarmerProductDetails;

public interface FarmerProductDetailsRepository extends JpaRepository<FarmerProductDetails, Long> {	
	
	@Query
	Optional<FarmerProductDetails> findById(Long id);

//	If you give @Query annotation then STS will not throw any error
//	It is an IDE(STS) error it does not recognize JPA methods
	@Query
	void deleteById(Long id);
	
	List<FarmerProductDetails> findAll();
}
