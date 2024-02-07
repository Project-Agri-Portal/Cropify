package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.OrderFarmProductDetails;

public interface OrderFarmProductDetailsRepository extends JpaRepository<OrderFarmProductDetails, Long> {

	@Query
	public Optional<OrderFarmProductDetails> findById(Long customerId);

	public List<OrderFarmProductDetails> findAllById(Long orderId);

	@Query
	public void deleteById(Long orderId);

	public List<OrderFarmProductDetails> findAllBy();

}
