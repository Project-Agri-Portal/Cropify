package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.dto.CartDTO;
import com.cropify.entity.CartFarmProduct;

public interface CartFarmProductRepository extends JpaRepository<CartFarmProduct, Long>{

    @Query(value =  "select * from cart_farm_product where customer_id = :customerId", nativeQuery = true)
    List<CartFarmProduct> findCartProductByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT cfp, fp FROM CartFarmProduct cfp JOIN cfp.farmProdId fp WHERE cfp.customerId.id = :customerId")
    List<Object[]> findByCustomerId(@Param("customerId") Long customerId);

}
