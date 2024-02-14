package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.CartMachinery;

public interface CartMachineryRepository extends JpaRepository<CartMachinery, Long> {

    List<CartMachinery> findByFarmerId(Long farmerId);

    @Query(value = "select * from cart_machinery where farmer_id = :id", nativeQuery = true)
    List<CartMachinery> findCartByFarmerId(@Param(value = "id") Long farmerId);

    int deleteByMachineId(String machineId);

}
