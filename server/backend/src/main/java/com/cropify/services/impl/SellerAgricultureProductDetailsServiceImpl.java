package com.cropify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cropify.dao.AgricultureProductsRepository;
import com.cropify.dao.SellerAgricultureProductDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.SellerAgricultureProductDetailsDTO;
import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.SellerAgricultureProductDetails;
import com.cropify.entity.UserDetails;
import com.cropify.services.SellerAgricultureProductDetailsService;

public class SellerAgricultureProductDetailsServiceImpl implements SellerAgricultureProductDetailsService {

	@Autowired
	private SellerAgricultureProductDetailsRepository repository;
	@Autowired
	private UserDetailsRepository sellerRepo;
	@Autowired
	private AgricultureProductsRepository agriProdRepo;
	@Autowired
	private ModelMapper mapper;
	
//  ---------------- Get operations ----------------
	@Override
	public List<SellerAgricultureProductDetailsDTO> getAllAgricultureProducts() {
		List<SellerAgricultureProductDetailsDTO> list = repository.findAll()
				.stream()
				.map(product -> mapper.map(product, SellerAgricultureProductDetailsDTO.class))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public SellerAgricultureProductDetailsDTO getAgricultureProductById(Long sapId) {
		SellerAgricultureProductDetails product = repository.findById(sapId).orElseThrow(
				() -> new RuntimeException("Agriculture product not found"));
		return mapper.map(product, SellerAgricultureProductDetailsDTO.class);
	}

//  ---------------- Create operations ----------------
	@Override
	public Long addAgricultureProduct(Long sellerId, SellerAgricultureProductDetailsDTO sapDto) {
		// Retrieving the seller proxy
		UserDetails seller = sellerRepo.getReferenceById(sellerId);
		
		// Retrieving the agriProduct proxy using agriProd ID
		String agriProductId = sapDto.getAgriProductId();
		AgricultureProducts agriProduct = agriProdRepo.getReferenceById(agriProductId);
		
		SellerAgricultureProductDetails productEnt = mapper.map(sapDto, SellerAgricultureProductDetails.class);
		
		// Calling the dependencies helper methods
		seller.addSellerAgricultureProductDetails(productEnt);
		agriProduct.addSellerAgricultureProductDetails(productEnt);
		
		// Saving the agriProduct
		SellerAgricultureProductDetails savedAgriProduct = repository.save(productEnt);
		
		return savedAgriProduct.getSellerAgricultureProductId();
	}

//  ---------------- Update operations ----------------
	@Override
	public SellerAgricultureProductDetailsDTO updateAgricultureProduct(Long sapId,
			SellerAgricultureProductDetailsDTO sapDto) {
		// TODO Auto-generated method stub
		return null;
	}

//  ---------------- Delete operations ----------------
	@Override
	public void deleteAgricultureProduct(Long sapId) {
		boolean productExists = repository.existsById(sapId);
		if (productExists)
			repository.deleteById(sapId);
		else
			throw new RuntimeException("Agriculture product not found");
	}

}
