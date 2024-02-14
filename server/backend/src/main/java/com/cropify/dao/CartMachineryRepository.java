package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.CartMachinery;

public interface CartMachineryRepository extends JpaRepository<CartMachinery, Long> {
	
}
