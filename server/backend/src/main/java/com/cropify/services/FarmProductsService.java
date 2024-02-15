package com.cropify.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.FarmProductsDTO;
import com.cropify.entity.FarmProducts;

public interface FarmProductsService {
	// Get operations
	List<FarmProductsDTO> getAllFarmProducts();
	FarmProductsDTO getFarmProductById(String pid);
	// Get image operation
	byte[] downloadImage(String fpId) throws IOException;
	
	// Post operations
	String addFarmProduct(FarmProductsDTO farmProducts);
	// Post image operation
	String uploadImage(String fpId, MultipartFile fpImage) throws IOException;

	// Update operations
	String updateFarmProduct(String fpId, FarmProductsDTO farmProductsDTO);
	
	// Delete operations
	void deleteFarmProduct(String pid);
}
