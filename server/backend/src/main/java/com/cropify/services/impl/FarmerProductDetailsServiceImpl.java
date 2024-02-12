package com.cropify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.FarmerProductDetailsRepository;
import com.cropify.dto.FarmerProductDetailsDTO;
import com.cropify.entity.FarmerProductDetails;
import com.cropify.services.FarmerProductDetailsService;

@Service
@Transactional
public class FarmerProductDetailsServiceImpl implements FarmerProductDetailsService{

	@Autowired
	private FarmerProductDetailsRepository detailsRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<FarmerProductDetailsDTO> getAllFarmProductDetails() {
		List<FarmerProductDetails> details = detailsRepository.findAll();
		List<FarmerProductDetailsDTO> detailsDTOs = details.stream().
													map(prod -> mapper.map(details, FarmerProductDetailsDTO.class))
													.collect(Collectors.toList());
		return detailsDTOs;
	}

	@Override
	public FarmerProductDetailsDTO addFarmerProductDetails(FarmerProductDetailsDTO detailsDTO) {
		FarmerProductDetails details = mapper.map(detailsDTO, FarmerProductDetails.class);
  		 FarmerProductDetails details2 = detailsRepository.save(details);
		return mapper.map(details2, FarmerProductDetailsDTO.class);
	}
	
}
