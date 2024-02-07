package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.SellerAgricultureProductDetails;

public interface SellerAgricultureProductDetailsRepository
		extends JpaRepository<SellerAgricultureProductDetails, Long> {
	@Query
	public Optional<SellerAgricultureProductDetails> findById(Long sellerAgricultureProductId);

	public List<SellerAgricultureProductDetails> findAllById(Long sellerAgricultureProductId);

	@Query
	public void deleteById(Long sellerAgricultureProductId);
	
	public List<SellerAgricultureProductDetails> findAll();

}
