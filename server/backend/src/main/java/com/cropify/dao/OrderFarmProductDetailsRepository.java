package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.OrderFarmProductDetails;

public interface OrderFarmProductDetailsRepository extends JpaRepository<OrderFarmProductDetails, Long> {

	@Query(value = "select count(distinct order_id) from order_farm_product_details", nativeQuery = true)
    public int findDistinctOrderIdForIdGeneration();

}
