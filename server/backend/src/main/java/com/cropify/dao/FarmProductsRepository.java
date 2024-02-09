package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.FarmProducts;

public interface FarmProductsRepository extends JpaRepository<FarmProducts, String> {
	
//	FarmProducts findByFarmProductId(String id);
//	
//	void deleteByFarmProductId(String id);
//	
//	List<FarmProducts> findAll();
	
	Optional<FarmProducts> findByfarmProductId(String id);
}
