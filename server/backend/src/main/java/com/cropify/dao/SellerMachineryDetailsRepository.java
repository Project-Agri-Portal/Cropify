package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.SellerMachineryDetails;

public interface SellerMachineryDetailsRepository extends JpaRepository<SellerMachineryDetails, Long>{

	@Modifying
	@Query(value = "update seller_machinery_details set avail_quantity = :availQuantity where seller_id = :sellerId and machine_id = :machineId", nativeQuery = true)
	SellerMachineryDetails updateAvailableMachineQuantity(@Param("availQuantity") int availQuantity, @Param("sellerId") Long sellerId, @Param("machineId") Long machineId);

	// @Query("select (*) from seller_machinery_details where seller_id = :sellerId and machine_id = :machineId")
	// public SellerMachineryDetails findSellerMachinery(@Param("sellerId") Long sellerId, @Param("machineId") String machineId);

	// @Query( value =  "select (*) from seller_machinery_details where seller_id = :sellerId and machine_id = :machineId", nativeQuery = true)
	// public SellerMachineryDetails findBySellerIdAndMachineId(@Param("sellerId") Long sellerId, @Param("machineId")String machineId);
	public SellerMachineryDetails findBySellerIdAndMachineryId(Long sellerId, String machineId);

}
