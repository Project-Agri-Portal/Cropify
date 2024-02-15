package com.cropify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cropify.dto.FarmProductsDTO;
import com.cropify.entity.FarmProducts;

public interface FarmProductsService {
	// Get operations
	List<FarmProductsDTO> getAllFarmProducts();
	FarmProductsDTO getFarmProductById(String pid); 
	
	// Post operations
	String addFarmProduct(FarmProductsDTO farmProducts);

	// Update operations
	String updateFarmProduct(String fpId, FarmProductsDTO farmProductsDTO);
	
	// Delete operations
	void deleteFarmProduct(String pid);
}
