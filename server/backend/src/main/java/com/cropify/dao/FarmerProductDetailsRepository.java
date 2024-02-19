package com.cropify.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.FarmerProductDetails;

public interface FarmerProductDetailsRepository extends JpaRepository<FarmerProductDetails, Long> {	

    @Query(value =  "select * from farmer_product_details where farm_prod_id = :prodId", nativeQuery = true)
    List<FarmerProductDetails> getFarmerProductDetailsByProductId(@Param("prodId") String prodId);

    @Modifying
    @Query("UPDATE FarmerProductDetails SET quantity = quantity - :decreaseQuantity WHERE farmerId.id = :farmerId AND farmProductId.farmProductId = :farmProductId")
    void decreaseQuantity(@Param("farmerId") Long farmerId, @Param("farmProductId") String farmProductId, @Param("decreaseQuantity") int decreaseQuantity);

    @Modifying
@Query("UPDATE FarmerProductDetails SET quantity = quantity + :increaseQuantity WHERE farmerId.id = :farmerId AND farmProductId.farmProductId = :farmProductId")
void increaseQuantity(@Param("farmerId") Long farmerId, @Param("farmProductId") String farmProductId, @Param("increaseQuantity") int increaseQuantity);

}
