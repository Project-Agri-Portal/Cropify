package com.cropify.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	

	// ------------- Get operation ------------------
	@Override
	public List<FarmProductsDTO> getAllFarmProducts() {
		List<FarmProductsDTO> list = farmProductsRepository.findAll()
				.stream()
				.map(product -> mapper.map(product, FarmProductsDTO.class))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public FarmProductsDTO getFarmProductById(String fpId) {
		FarmProducts product = farmProductsRepository.findById(fpId).orElseThrow(
				() -> new ResourceNotFoundException("Product not found"));
		return mapper.map(product, FarmProductsDTO.class);
	}
	// ---- get image ----
	@Override
	public byte[] downloadImage(String fpId) throws IOException
	{
		FarmProducts farmProduct = farmProductsRepository.findById(fpId).orElseThrow(
				() -> new ResourceNotFoundException("Product not found"));
		return farmProduct.getImgPath();
	}

	// ------------- Post operation ------------------
	@Override
	public String addFarmProduct(FarmProductsDTO farmProducts) {
		FarmProducts savedFarmProduct = mapper.map(farmProducts, FarmProducts.class);
		return farmProductsRepository.save(savedFarmProduct).getFarmProductId();
	}
	// ---- add image ----
	@Override
	public String uploadImage(String fpId, MultipartFile fpImage) throws IOException
	{
		FarmProducts farmProduct = farmProductsRepository.findById(fpId).orElseThrow(
				() -> new ResourceNotFoundException("No farm product found"));
		farmProduct.setImgPath(fpImage.getBytes());
		return farmProduct.getFarmProductId();
	}

	// ------------- Put operation ------------------
	@Override
	public String updateFarmProduct(String fpId, FarmProductsDTO farmProductsDTO) {
		boolean productExists = farmProductsRepository.existsById(fpId);
		if (productExists) {
			FarmProducts product = mapper.map(farmProductsDTO, FarmProducts.class);
			FarmProducts savedProduct = farmProductsRepository.save(product);
			return savedProduct.getFarmProductId();
		}
		return null;
	}

	// ------------- Delete operation ------------------
	@Override
	public void deleteFarmProduct(String pid) {
		boolean productExists = farmProductsRepository.existsById(pid);
		if (productExists)
			farmProductsRepository.deleteById(pid);
		else
			throw new ResourceNotFoundException("Invalid resource ID");
	}
}
