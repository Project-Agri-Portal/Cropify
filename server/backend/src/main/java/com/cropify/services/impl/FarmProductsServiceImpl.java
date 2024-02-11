package com.cropify.services.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.dto.FarmProductsDTO;
import com.cropify.entity.FarmProducts;
import com.cropify.services.FarmProductsService;

@Service
@Transactional
public class FarmProductsServiceImpl implements FarmProductsService {
	
	@Autowired
	private FarmProductsRepository farmProductsRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	//working
	@Override
	public List<FarmProductsDTO> getAllFarmProducts() {
		List<FarmProducts> products = farmProductsRepository.findAll();
		List<FarmProductsDTO> productsDTO = products.stream()
				.map(rpod -> mapper.map(rpod, FarmProductsDTO.class))
				.collect(Collectors.toList());
		return productsDTO;
	}
	
	
	@Override
	public FarmProductsDTO getFarmProductById(String farmProductId) {
		FarmProducts farmProducts = farmProductsRepository.findByfarmProductId(farmProductId)
									.orElseThrow(() -> new RuntimeException("NotFound"));
		FarmProductsDTO farmProductsDTO = mapper.map(farmProducts, FarmProductsDTO.class);
		return farmProductsDTO;
		
	}
	
	@Override
	public FarmProductsDTO addFarmProduct(FarmProductsDTO farmProductsDTO) {
		FarmProducts products = mapper.map(farmProductsDTO, FarmProducts.class);
		products =  farmProductsRepository.save(products);
		return mapper.map(products, FarmProductsDTO.class);
	}
	
	
	


	//not working
	@Override
	public String deleteFarmProduct(@NonNull String pid) {
		farmProductsRepository.deleteById(pid);
		return "farm product " + pid + " delete";
	}

	//working
	@Override
	public FarmProducts fetchFarmProductDetails(String pid) {
//		Optional<FarmProducts> optional = farmProductsRepository.findById(pid);
//		return optional.orElseThrow(() -> new ResourceNotFoundException("emp id " + pid));
		
		return farmProductsRepository.findById(pid).orElseThrow(()-> new ResourceNotFoundException(pid));
	}	
}
