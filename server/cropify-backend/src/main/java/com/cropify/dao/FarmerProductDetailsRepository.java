package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.FarmerProductDetails;

public interface FarmerProductDetailsRepository extends JpaRepository<FarmerProductDetails, Long> {	
	
	Optional<FarmerProductDetails> findByFarmerProductDetailsId(Long id);

//	If you give @Query annotation then STS will not throw any error
//	It is an IDE(STS) error it does not recognize JPA methods
	@Query
	void deleteByFarmerProductDetailsId(Long id);
	
	List<FarmerProductDetails> findAll();
}
