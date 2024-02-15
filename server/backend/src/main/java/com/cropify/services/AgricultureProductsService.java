package com.cropify.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.AgricultureProductsDTO;

public interface AgricultureProductsService {
	// Create operations
	AgricultureProductsDTO addAgricultureProduct(AgricultureProductsDTO productDto);
	String uploadImage(String apId, MultipartFile apImage) throws IOException;
	
	// Read operations
	List<AgricultureProductsDTO> getAllAgricultureProducts();
	byte[] downloadImage(String apId) throws IOException;
	
	//Read Single Operation By Id
	AgricultureProductsDTO getAgricultureProductById(String productId);
	
	// Delete operations
	void deleteAgricultureProductById(String productId);
}
