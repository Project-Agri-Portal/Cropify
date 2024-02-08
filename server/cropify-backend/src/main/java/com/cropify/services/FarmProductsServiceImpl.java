package com.cropify.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cropify.dao.FarmProductsRepository;
import com.cropify.entity.FarmProducts;

@Service
@Transactional
public class FarmProductsServiceImpl implements FarmProductsService {
	
	@Autowired
	private FarmProductsRepository farmProductsRepository;
	
	@Override
	@GetMapping
	public List<FarmProducts> getAllFarmProducts() {
		return farmProductsRepository.findAll();
	}
	
	@GetMapping("/{pid}")
	public Optional<FarmProducts> getFarmProductById(@PathVariable String pid) {
		return Optional.of(farmProductsRepository.findById(pid));
	}
}
