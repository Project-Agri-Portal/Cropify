package com.cropify.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.mapping.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.dao.FarmerProductDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.FarmerProductDetailsDTO;
import com.cropify.dto.NewFarmProductDTO;
import com.cropify.dto.SellerMachineDTO;
import com.cropify.dto.ShopDTO;
import com.cropify.entity.FarmProducts;
import com.cropify.entity.FarmerProductDetails;
import com.cropify.entity.Machinery;
import com.cropify.entity.SellerMachineryDetails;
import com.cropify.entity.UserDetails;
import com.cropify.services.FarmerProductDetailsService;

@Service
@Transactional
public class FarmerProductDetailsServiceImpl implements FarmerProductDetailsService{

	@Autowired
	private FarmerProductDetailsRepository detailsRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private FarmProductsRepository farmProductsRepository;
	
	@Override
	public List<FarmerProductDetailsDTO> getAllFarmProductDetails() {
		List<FarmerProductDetails> details = detailsRepository.findAll();
		// List<FarmerProductDetailsDTO> detailsDTOs = details.stream().
		// 											map(prod -> mapper.map(prod, FarmerProductDetailsDTO.class))
		// 											.collect(Collectors.toList());

		List<FarmerProductDetailsDTO> detailsDTOs = new ArrayList<>();
		for(FarmerProductDetails farmDetails : details){
	// 		private String farmProductId;
	// private Long farmerId;
	// private int quantity;
	// private double price;
	// private String description;
	// private String verified;
			FarmerProductDetailsDTO detailsDTO = mapper.map(farmDetails, FarmerProductDetailsDTO.class);
			System.out.println(detailsDTO);
			detailsDTOs.add(detailsDTO);
		}
		return detailsDTOs;
	}

	@Override
	public Long addFarmerProductDetails(FarmerProductDetailsDTO detailsDTO, Long id) {
		UserDetails farmer = userDetailsRepository.getReferenceById(id);
		String cropId = detailsDTO.getFarmProductId();
		FarmProducts farmProducts = farmProductsRepository.getReferenceById(cropId);

		FarmerProductDetails details = mapper.map(detailsDTO, FarmerProductDetails.class);
		farmProducts.addFarmProductDetails(details);
		farmer.addFarmerProductDetails(details);
  		FarmerProductDetails saveDetails = detailsRepository.save(details);
		// return mapper.map(saveDetails, FarmerProductDetailsDTO.class);
		return saveDetails.getFarmerProductDetailsId();
	}

	@Override
	public List<ShopDTO> getAllList() {
		List<FarmProducts> farmProducts = farmProductsRepository.findAll();
		List<ShopDTO> shopDTOs = new ArrayList<>();
		for(FarmProducts products : farmProducts){
			List<FarmerProductDetails> farmerProductDetails = detailsRepository.getFarmerProductDetailsByProductId(products.getFarmProductId());
			for(FarmerProductDetails productDetails : farmerProductDetails){
				ShopDTO shopDTO = new ShopDTO();
				shopDTO.setFarmProdId(productDetails.getFarmProductId().getFarmProductId());
				shopDTO.setFarmerId(productDetails.getFarmerId().getId());
				shopDTO.setFarmProdName(products.getFarmProductName());
				shopDTO.setDescription(productDetails.getDescription());
				shopDTO.setExpiryDate(productDetails.getExpiryDate());
				shopDTO.setPrice(productDetails.getPrice());
				shopDTO.setQuantity(productDetails.getQuantity());
				UserDetails details = userDetailsRepository.findById(productDetails.getFarmerId().getId()).orElseThrow(() -> new RuntimeException());
				shopDTO.setFirstName(details.getFirstName());
				shopDTO.setImg(products.getImgPath());
				shopDTOs.add(shopDTO);
			}
		}
		Collections.shuffle(shopDTOs);
		return shopDTOs;
	}

	@Override
	public List<NewFarmProductDTO> getAllProductIntoNewDTO(Long farmerId) {
		List<FarmerProductDetails> details= detailsRepository.getByFarmerId(farmerId);
		System.out.println(farmerId + " " + details.size());
		List<NewFarmProductDTO> newFarmProductDtos= new ArrayList<>();
		int count=detailsRepository.getCountByFarmerId(farmerId);
		
		for(FarmerProductDetails products : details) {
			FarmProducts product = farmProductsRepository.findById(products.getFarmProductId().getFarmProductId()).orElseThrow(
					()-> new ResourceNotFoundException("Machine not found"));
			
			NewFarmProductDTO dto= new NewFarmProductDTO();
			dto.setFarmProductId(product.getFarmProductId());
			dto.setFarmProductName(product.getFarmProductName());
			dto.setQuantity(products.getQuantity());
			dto.setDescription(products.getDescription());
			dto.setPrice(products.getPrice());
			dto.setProductCount(count);
			
			dto.setFarmProductDetailsId(products.getFarmerProductDetailsId());
			
			newFarmProductDtos.add(dto);
		}
		return newFarmProductDtos;
	}

	@Override
	public void deleteFarmProductDetailsById(Long fpdId) {
		boolean detailExists = detailsRepository.existsById(fpdId);
		if (detailExists)
			detailsRepository.deleteById(fpdId);
		else
			throw new RuntimeException("seller machinery detail not found");
	}
	
	
}
