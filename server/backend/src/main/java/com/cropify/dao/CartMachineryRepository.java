package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.CartMachinery;

public interface CartMachineryRepository extends JpaRepository<CartMachinery, Long>{

	@Query( nativeQuery = true, value = "select * from cart_machinery a where a.farmer_id = :id")
	List<CartMachinery> findCartMachineryById(@Param("id") Long id);
}
