package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.CartFarmProduct;

public interface CartFarmProductRepository extends JpaRepository<CartFarmProduct, Long>{

    @Query(value =  "select * from cart_farm_product where customer_id = :customerId", nativeQuery = true)
    List<CartFarmProduct> findCartProductByCustomerId(@Param("customerId") Long customerId);

}
