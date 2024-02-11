package com.cropify.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.entity.FarmProducts;
import com.cropify.services.FarmProductsService;

@Service
@Transactional
public class FarmProductsServiceImpl implements FarmProductsService {
	
	@Autowired
	private FarmProductsRepository farmProductsRepository;
	
	//working
	@Override
	public List<FarmProducts> getAllFarmProducts() {
		return farmProductsRepository.findAll();
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


	@Override
	public FarmProducts getFarmProductById(String pid) {
		return farmProductsRepository.findByfarmProductId(pid).orElseThrow(() -> new RuntimeException("NotFound"));
	}


//	not working
	@Override
	public FarmProducts addFarmProduct(FarmProducts farmProducts) {
		return farmProductsRepository.save(farmProducts);
	}
}
