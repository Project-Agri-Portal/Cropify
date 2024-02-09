package com.cropify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cropify.entity.FarmProducts;

public interface FarmProductsService {
	List<FarmProducts> getAllFarmProducts();
	
	Optional<FarmProducts> getFarmProductById(String pid); 
	String deleteFarmProduct(String pid);
	FarmProducts fetchFarmProductDetails(String pid);
	FarmProducts addFarmProduct(FarmProducts farmProducts);
}
