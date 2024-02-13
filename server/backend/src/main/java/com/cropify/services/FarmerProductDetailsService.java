package com.cropify.services;

import java.util.List;

import com.cropify.dto.FarmerProductDetailsDTO;

public interface FarmerProductDetailsService {
	
	List<FarmerProductDetailsDTO> getAllFarmProductDetails();
	
	Long addFarmerProductDetails(FarmerProductDetailsDTO detailsDTO, Long id);
	
}
