package com.cropify.services;

import java.util.List;

import com.cropify.dto.FarmerProductDetailsDTO;
import com.cropify.dto.NewFarmProductDTO;
import com.cropify.dto.OrderDTO;
import com.cropify.dto.SellerMachineDTO;
import com.cropify.dto.ShopDTO;

public interface FarmerProductDetailsService {
	
	List<FarmerProductDetailsDTO> getAllFarmProductDetails();
	
	Long addFarmerProductDetails(FarmerProductDetailsDTO detailsDTO, Long id);

	List<ShopDTO> getAllList();
	
	// ----------------------
	List<NewFarmProductDTO> getAllProductIntoNewDTO(Long farmerId);
	void deleteFarmProductDetailsById(Long fpdId);
}
