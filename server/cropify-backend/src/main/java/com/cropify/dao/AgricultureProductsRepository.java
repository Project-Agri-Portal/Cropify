package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.AgricultureProducts;

public interface AgricultureProductsRepository extends JpaRepository<AgricultureProducts, String> {
	
	Optional<AgricultureProducts> findByAgriProductId(String id);
	
//	AgricultureProducts save(AgricultureProducts agricultureProducts);
	
	List<AgricultureProducts> findAll();
	
//	If you give @Query annotation then STS will not throw any error
//	It is an IDE(STS) error it does not recognize JPA methods
	void deleteByAgriProductId(String agriProductId);
}
