package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.SellerMachineryDetails;

public interface SellerMachineryDetailsRepository extends JpaRepository<SellerMachineryDetails, Long>{
	// --- Find entity methods ---
//	List<SellerMachineryDetails> findAll();
//	Optional<SellerMachineryDetails> findBySellerMachineryId(Long sellerMachineryId);
//	
//	// --- Delete entity by ID ---
//	void deleteBySellerMachineryId(Long sellerMachineryId);
}
