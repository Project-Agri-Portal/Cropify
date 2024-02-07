package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.Machinery;
import com.cropify.entity.OrderAgricultureProductDetails;

public interface OrderAgricultureProductDetailsRepository extends JpaRepository<OrderAgricultureProductDetails, Long> {

	public Optional<OrderAgricultureProductDetails> findByOrderId(Long orderId);

	public List<OrderAgricultureProductDetails> findAll();

//	@Query // used to specify a custom SQL or HQL query that should be executed by the
			// associated method.
	public void deleteByOrderId(Long orderId);

}
