package com.cropify.services.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public AgricultureProductsDTO addAgricultureProduct(AgricultureProductsDTO productDto) {
		AgricultureProducts product = mapper.map(productDto, AgricultureProducts.class);
		AgricultureProducts savedProduct = productRepo.save(product);
		return mapper.map(savedProduct, AgricultureProductsDTO.class);
	}

	@Override
	public List<AgricultureProductsDTO> getAllAgricultureProducts() {
		
		List<AgricultureProducts> agricultureProducts = productRepo.findAll();
		System.out.println(agricultureProducts);
		List<AgricultureProductsDTO> agricultureProductsDTOs = agricultureProducts.stream()
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

	@Override
	public void deleteAgricultureProductById(String productId) {
		boolean productExists = productRepo.existsById(productId);
		if (productExists)
			productRepo.deleteById(productId);
		else
			throw new ResourceNotFoundException("product not found");
	}

}
