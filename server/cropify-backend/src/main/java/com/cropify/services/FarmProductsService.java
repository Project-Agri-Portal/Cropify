package com.cropify.services;

import java.util.List;
import java.util.Optional;


import com.cropify.entity.FarmProducts;

public interface FarmProductsService {
	List<FarmProducts> getAllFarmProducts();
	Optional<FarmProducts> getFarmProductById(String pid); 
}
