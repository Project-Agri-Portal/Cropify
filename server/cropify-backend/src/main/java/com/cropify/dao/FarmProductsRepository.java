package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.FarmProducts;

public interface FarmProductsRepository extends JpaRepository<FarmProducts, String> {
	
	@Query
	FarmProducts findAllId(String id);
	
	@Query
	void deleteById(String id);
	
	List<FarmProducts> findAll();
}
