package com.cropify.services;

import java.util.List;

import com.cropify.dto.SellerMachineryDetailsDTO;

public interface SellerMachineryDetailsService {
	// Read operations
	List<SellerMachineryDetailsDTO> getAllSellerMachineryDetails();
	SellerMachineryDetailsDTO getSellerMachineryDetailsById(Long id);
	
	// Create operations
	SellerMachineryDetailsDTO addSellerMachineryDetails(Long id, SellerMachineryDetailsDTO smDto);
	
	// Update operations
	SellerMachineryDetailsDTO updateSellerMachineryDetails(SellerMachineryDetailsDTO smDto, Long id);
	
	// Delete operations
	void deleteSellerMachineryDetailsById(Long id);
}
