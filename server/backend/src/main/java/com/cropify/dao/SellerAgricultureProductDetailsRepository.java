package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.SellerAgricultureProductDetails;

public interface SellerAgricultureProductDetailsRepository
		extends JpaRepository<SellerAgricultureProductDetails, Long> {

//	public Optional<SellerAgricultureProductDetails> findBySellerAgricultureProductId(Long sellerAgricultureProductId);
//
//	public List<SellerAgricultureProductDetails> findAllById(Long sellerAgricultureProductId);
//
//	public void deleteBySellerAgricultureProductId(Long sellerAgricultureProductId);
//
//	public List<SellerAgricultureProductDetails> findAll();

	
}
