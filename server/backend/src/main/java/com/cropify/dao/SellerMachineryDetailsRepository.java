package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.SellerMachineryDetails;

public interface SellerMachineryDetailsRepository extends JpaRepository<SellerMachineryDetails, Long>{

	@Modifying
	@Query(value = "update avail_quantity = :availQuantity from seller_machinery_details where seller_id = :sellerId and machine_id = :machineId", nativeQuery = true)
	SellerMachineryDetails updateAvailableMachineQuantity(@Param("availQuantity") int availQuantity, @Param("sellerId") Long sellerId, @Param("machineId") Long machineId);

	// @Query("select (*) from seller_machinery_details where seller_id = :sellerId and machine_id = :machineId")
	// public SellerMachineryDetails findSellerMachinery(@Param("sellerId") Long sellerId, @Param("machineId") String machineId);

	public SellerMachineryDetails findBySellerIdAndMachineryId(Long sellerId, String machineId);

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
