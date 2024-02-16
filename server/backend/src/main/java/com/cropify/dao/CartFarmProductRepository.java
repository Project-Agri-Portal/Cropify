package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.CartFarmProduct;

public interface CartFarmProductRepository extends JpaRepository<CartFarmProduct, String>{
    
}
