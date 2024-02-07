package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.OrderFarmProductDetails;

public interface OrderFarmProductDetailsRepository extends JpaRepository<OrderFarmProductDetails, Long> {

	public Optional<OrderFarmProductDetails> findByOrderId(Long customerId);

	public List<OrderFarmProductDetails> findAllByOrderId(Long orderId);

	public void deleteByOrderId(Long orderId);

	public List<OrderFarmProductDetails> findAllBy();

}
