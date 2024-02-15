package com.cropify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cropify.dao.AgricultureProductsRepository;
import com.cropify.dao.SellerAgricultureProductDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.SellerAgricultureProductDetailsDTO;
import com.cropify.dto.UserDetailsDTO;
import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.SellerAgricultureProductDetails;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmProductsStatus;
import com.cropify.services.SellerAgricultureProductDetailsService;

@Service
@Transactional
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
		
		SellerAgricultureProductDetailsDTO agriDto = mapper.map(product, SellerAgricultureProductDetailsDTO.class);
//		agriDto.setSellerId(product.getSellerId().getId());
//		return mapper.map(product, SellerAgricultureProductDetailsDTO.class);
		return agriDto;
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
//		SellerAgricultureProductDetailsDTO agriDto = mapper.map(savedAgriProduct, SellerAgricultureProductDetailsDTO.class);
		
		return savedAgriProduct.getSellerAgricultureProductId();
	}

//  ---------------- Update operations ----------------
	@Override
	public int updateSellerAgriucltureProductDetails(Long sapId, SellerAgricultureProductDetailsDTO sapDto) {
		int quantity = sapDto.getQuantity();
		double price = sapDto.getPrice();
		String description = sapDto.getDescription();
		FarmProductsStatus sellerProductStatus = sapDto.getSellerProductStatus();
		
		int rowsAffected = repository.updateSellerAgriucltureProductDetails(quantity, price, description, sellerProductStatus, sapId);
		return rowsAffected;
	}
	
	/*
	@Override
	public SellerAgricultureProductDetailsDTO updateAgricultureProduct(Long sapId,
			SellerAgricultureProductDetailsDTO sapDto) {
		boolean sapExists = repository.existsById(sapId);
		
		Long sellerId = sapDto.getSellerId();
		UserDetails seller = sellerRepo.getReferenceById(sellerId);
		String agriProdId = sapDto.getAgriProductId();
		AgricultureProducts agriProduct = agriProdRepo.getReferenceById(agriProdId);
		
		if (sapExists) {
			SellerAgricultureProductDetails productEnt = mapper.map(sapDto, SellerAgricultureProductDetails.class);
			
//			seller.addSellerAgricultureProductDetails(productEnt);
//			agriProduct.addSellerAgricultureProductDetails(productEnt);
			
			SellerAgricultureProductDetails updatedProductEnt = repository.save(productEnt);
			return mapper.map(updatedProductEnt, SellerAgricultureProductDetailsDTO.class);
		}
		return null;
	}
	*/
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
