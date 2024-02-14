package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.SellerAgricultureProductDetails;
import com.cropify.entity.enums.FarmProductsStatus;

public interface SellerAgricultureProductDetailsRepository
		extends JpaRepository<SellerAgricultureProductDetails, Long> {

//	public Optional<SellerAgricultureProductDetails> findBySellerAgricultureProductId(Long sellerAgricultureProductId);
//
//	public List<SellerAgricultureProductDetails> findAllById(Long sellerAgricultureProductId);
//
//	public void deleteBySellerAgricultureProductId(Long sellerAgricultureProductId);
//
//	public List<SellerAgricultureProductDetails> findAll();
	@Modifying
	@Query("update SellerAgricultureProductDetails s set s.quantity=:quantity, s.price=:price, s.description=:description, s.sellerProductStatus=:sellerProductStatus where s.sellerAgricultureProductId = :sellerAgricultureProductId")
	int updateSellerAgriucltureProductDetails(
			@Param("quantity") int quantity, 
			@Param("price") double price, 
			@Param("description") String description, 
			@Param("sellerProductStatus") FarmProductsStatus sellerProductStatus,
			@Param("sellerAgricultureProductId") Long agriProductId);
}
