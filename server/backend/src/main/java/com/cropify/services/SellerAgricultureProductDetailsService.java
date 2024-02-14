package com.cropify.services;

import java.util.List;

import com.cropify.dto.SellerAgricultureProductDetailsDTO;

public interface SellerAgricultureProductDetailsService {
	// Read operations
	List<SellerAgricultureProductDetailsDTO> getAllAgricultureProducts();
	SellerAgricultureProductDetailsDTO getAgricultureProductById(Long sapId);
	
	// Create operations
	Long addAgricultureProduct(Long sellerId, SellerAgricultureProductDetailsDTO sapDto);
	
	// Update operations
//	SellerAgricultureProductDetailsDTO updateAgricultureProduct(Long sapId, SellerAgricultureProductDetailsDTO sapDto);
	int updateSellerAgriucltureProductDetails(Long sapId, SellerAgricultureProductDetailsDTO sapDto);
	
	// Delete operations
	void deleteAgricultureProduct(Long sapId);
}
