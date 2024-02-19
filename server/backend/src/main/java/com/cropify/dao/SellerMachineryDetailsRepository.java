package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.Machinery;
import com.cropify.entity.SellerMachineryDetails;
import com.cropify.entity.UserDetails;

public interface SellerMachineryDetailsRepository extends JpaRepository<SellerMachineryDetails, Long>{

	@Modifying
	// @Query(value = "update seller_machinery_details set avail_quantity = :availQuantity where seller_id = :sellerId and machine_id = :machineId", nativeQuery = true)
	@Query("update SellerMachineryDetails smd set smd.availQuantity = :availQuantity where smd.sellerId = :sellerId and smd.machineryId = :machineryId")
	int updateAvailableMachineQuantity(
		@Param("availQuantity") int availQuantity, 
		@Param("sellerId") Long sellerId,
		@Param("machineryId") String machineryId);

	// @Query("select (*) from seller_machinery_details where seller_id = :sellerId and machine_id = :machineId")
	// public SellerMachineryDetails findSellerMachinery(@Param("sellerId") Long sellerId, @Param("machineId") String machineId);

	// @Query( value =  "select (*) from seller_machinery_details where seller_id = :sellerId and machine_id = :machineId", nativeQuery = true)
	@Query("select smd from SellerMachineryDetails smd where smd.sellerId = :sellerId and smd.machineryId = :machineId")
	public SellerMachineryDetails findBySellerIdAndMachineId(@Param("sellerId") Long sellerId, @Param("machineId")String machineId);
	// SellerMachineryDetails findBySellerIdAndMachineryId(Long sellerId, String machineId);

	// --- Find entity methods ---
//	List<SellerMachineryDetails> findAll();
//	Optional<SellerMachineryDetails> findBySellerMachineryId(Long sellerMachineryId);
//	
//	// --- Delete entity by ID ---
//	void deleteBySellerMachineryId(Long sellerMachineryId);
	
	@Modifying
	@Query("update SellerMachineryDetails sm set sm.quantity=:quantity, sm.price=:price, sm.description=:description, sm.availQuantity=:availQuantity where sm.sellerMachineryId=:sellerMachineryId")
	int updateSellerMachineryDetails(
			@Param("quantity") int quantity,
			@Param("price") double price,
			@Param("description") String description,
			@Param("availQuantity") int availQuantity,
			@Param("sellerMachineryId") Long sellerMachineryId);
	
	
//	@Query(value="select * from seller_machinery_details where seller_id=:sellerId",nativeQuery = true)
//	List<SellerMachineryDetails> getsellerMachineries(
//			@Param("sellerId") 
//			);
	
	
	@Query(value="select * from seller_machinery_details where seller_id=:sellerId",nativeQuery = true)
	List<SellerMachineryDetails> getBySellerId(
			@Param ("sellerId") long sellerId
			);
	
	
	@Query(value="select count(*) from seller_machinery_details where seller_id=:sellerId",nativeQuery = true)
	int getCountBySellerId(
			@Param ("sellerId") long sellerId
			);
	
	@Modifying
    @Query("UPDATE SellerMachineryDetails s SET s.quantity = s.quantity + :quantity WHERE s.sellerId = :sellerId AND s.machineryId = :machineryId")
    void updateQuantityBySellerAndMachinery(
        @Param("quantity") int quantity,
        @Param("sellerId") UserDetails sellerId,
        @Param("machineryId") Machinery machineryId
    );
	
	
	

}
