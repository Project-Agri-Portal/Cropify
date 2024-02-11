package com.cropify.services;

import java.util.List;

import com.cropify.dto.AgricultureProductsDTO;

public interface AgricultureProductsService {
	// Create operations
	AgricultureProductsDTO addAgricultureProduct(AgricultureProductsDTO productDto);
	
	// Read operations
	List<AgricultureProductsDTO> getAllAgricultureProducts();
	
	
	AgricultureProductsDTO getAgricultureProductById(String productId);
	
	// Delete operations
	void deleteAgricultureProductById(String productId);
}
