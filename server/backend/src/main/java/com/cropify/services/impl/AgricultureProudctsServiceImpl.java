package com.cropify.services.impl;

import java.io.IOException;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.AgricultureProductsRepository;
import com.cropify.dto.AgricultureProductsDTO;
import com.cropify.entity.AgricultureProducts;
import com.cropify.services.AgricultureProductsService;

@Service
@Transactional
public class AgricultureProudctsServiceImpl implements AgricultureProductsService {

	@Autowired
	private AgricultureProductsRepository productRepo;
	@Autowired
	ModelMapper mapper;
	
	// --------------- POST operation ---------------------
	@Override
	public AgricultureProductsDTO addAgricultureProduct(AgricultureProductsDTO productDto) {
		AgricultureProducts product = mapper.map(productDto, AgricultureProducts.class);
		AgricultureProducts savedProduct = productRepo.save(product);
		return mapper.map(savedProduct, AgricultureProductsDTO.class);
	}
	// ---- upload image ----
	@Override
	public String uploadImage(String apId, MultipartFile apImage) throws IOException {
		AgricultureProducts agriProduct = productRepo.findById(apId).orElseThrow(
				() -> new ResourceNotFoundException("No agriculture product found"));
		agriProduct.setImgPath(apImage.getBytes());
		return agriProduct.getAgriProductId();
	}
	
	// --------------- GET operation ---------------------
	@Override
	public List<AgricultureProductsDTO> getAllAgricultureProducts() {
		
		List<AgricultureProducts> agricultureProducts = productRepo.findAll();
		List<AgricultureProductsDTO> agricultureProductsDTOs = agricultureProducts
				.stream()
				.map(agriprod -> mapper.map(agriprod, AgricultureProductsDTO.class))
				.collect(Collectors.toList());
		return agricultureProductsDTOs;
	}
	
	@Override
	public AgricultureProductsDTO getAgricultureProductById(String productId) {
		AgricultureProducts product = productRepo.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("product not found"));
		
		return mapper.map(product, AgricultureProductsDTO.class);
	}
	// ---- download image ----
	@Override
	public byte[] downloadImage(String apId) throws IOException {
		AgricultureProducts agriProduct = productRepo.findById(apId).orElseThrow(
				() -> new ResourceNotFoundException("No agriculture product found"));
		return agriProduct.getImgPath();
	}

	// --------------- DELETE operation ---------------------
	@Override
	public void deleteAgricultureProductById(String productId) {
		boolean productExists = productRepo.existsById(productId);
		if (productExists)
			productRepo.deleteById(productId);
		else
			throw new ResourceNotFoundException("product not found");
	}
}
