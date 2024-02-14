package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.SellerMachineryDetails;

public interface SellerMachineryDetailsRepository extends JpaRepository<SellerMachineryDetails, Long>{
	// --- Find entity methods ---
//	List<SellerMachineryDetails> findAll();
//	Optional<SellerMachineryDetails> findBySellerMachineryId(Long sellerMachineryId);
//	
//	// --- Delete entity by ID ---
//	void deleteBySellerMachineryId(Long sellerMachineryId);
	
	@Modifying
	@Query("update SellerMachineryDetails sm set sm.quantity=:quantity, sm.price=:price, sm.description=:description, sm.isAvailable=:isAvailable where sm.sellerMachineryId=:sellerMachineryId")
	int updateSellerMachineryDetails(
			@Param("quantity") int quantity,
			@Param("price") double price,
			@Param("description") String description,
			@Param("isAvailable") int isAvailable,
			@Param("sellerMachineryId") Long sellerMachineryId);
}
