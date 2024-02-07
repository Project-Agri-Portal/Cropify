package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.SellerMachineryDetails;

public interface SellerMachineryDetailsRepository extends JpaRepository<SellerMachineryDetails, Long>{
	// --- Find entity methods ---
	List<SellerMachineryDetails> findAll();
	
	@Query	// Providing @Query annotation to fix the IDE error of 'no derived query'
	Optional<SellerMachineryDetails> findById(Long sellerMachineryId);
	
	// --- Delete entity by ID ---
	@Query
	void deleteById(Long sellerMachineryId);
}
