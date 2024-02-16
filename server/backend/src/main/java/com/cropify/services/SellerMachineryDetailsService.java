package com.cropify.services;

import java.util.List;

import com.cropify.dto.CartMachineryDTO;
import com.cropify.dto.SellerMachineryDetailsDTO;
import com.cropify.entity.CartMachinery;
import com.cropify.entity.OrderMachineDetails;
import com.cropify.entity.SellerMachineryDetails;

public interface SellerMachineryDetailsService {
	// Read operations
	List<SellerMachineryDetailsDTO> getAllSellerMachineryDetails();
	SellerMachineryDetailsDTO getSellerMachineryDetailsById(Long id);

	// SellerMachineryDetails findSellerMachiery();

	int modifyingSoldQuantity(CartMachineryDTO cartMachineryDTO);
	
	// Create operations
	Long addSellerMachineryDetails(Long id, SellerMachineryDetailsDTO smDto);
	
	// Update operations
//	SellerMachineryDetailsDTO updateSellerMachineryDetails(SellerMachineryDetailsDTO smDto, Long id);
	int updateSellerMachineryDetails(SellerMachineryDetailsDTO smDto, Long id);
	
	// Delete operations
	void deleteSellerMachineryDetailsById(Long id);
}
