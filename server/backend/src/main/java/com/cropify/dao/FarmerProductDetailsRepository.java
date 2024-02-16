package com.cropify.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.FarmerProductDetails;

public interface FarmerProductDetailsRepository extends JpaRepository<FarmerProductDetails, Long> {	

    @Query(value =  "select * from farmer_product_details where farm_prod_id = :prodId", nativeQuery = true)
    List<FarmerProductDetails> getFarmerProductDetailsByProductId(@Param("prodId") String prodId);

}
