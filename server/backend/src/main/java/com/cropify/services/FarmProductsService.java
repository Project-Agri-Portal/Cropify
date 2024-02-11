package com.cropify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cropify.dto.FarmProductsDTO;
import com.cropify.entity.FarmProducts;

public interface FarmProductsService {
	List<FarmProductsDTO> getAllFarmProducts();
	
	FarmProductsDTO getFarmProductById(String farmProductId); 
	
	FarmProductsDTO addFarmProduct(FarmProductsDTO farmProductsDTO);
	
	String deleteFarmProduct(String pid);
	FarmProducts fetchFarmProductDetails(String pid);
}
