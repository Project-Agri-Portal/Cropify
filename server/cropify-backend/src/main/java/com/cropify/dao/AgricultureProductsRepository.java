package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.AgricultureProducts;

public interface AgricultureProductsRepository extends JpaRepository<AgricultureProducts, String> {
	@Query
	Optional<AgricultureProducts> findById(String id);
	
//	AgricultureProducts save(AgricultureProducts agricultureProducts);
	
	List<AgricultureProducts> findAll();
	
//	If you give @Query annotation then STS will not throw any error
//	It is an IDE(STS) error it does not recognize JPA methods
	@Query
	void deleteById(String agriProductId);
//	void delete(String agriProductId);
}
