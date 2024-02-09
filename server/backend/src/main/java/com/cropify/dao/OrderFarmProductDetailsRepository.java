package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.OrderFarmProductDetails;

public interface OrderFarmProductDetailsRepository extends JpaRepository<OrderFarmProductDetails, Long> {
	
//	public Optional<OrderFarmProductDetails> findByOrderId(Long orderId);
//
//	public List<OrderFarmProductDetails> findAll();
//
////	@Query // used to specify a custom SQL or HQL query that should be executed by the
//			// associated method.
//	public void deleteByOrderId(Long orderId);
}
