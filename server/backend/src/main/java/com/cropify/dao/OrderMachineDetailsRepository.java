package com.cropify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.entity.OrderMachineDetails;

public interface OrderMachineDetailsRepository extends JpaRepository<OrderMachineDetails, Long>{

    // public int findDistinctByOrderId();
    @Query(value = "select count(distinct order_id) from order_machine_details", nativeQuery = true)
    public int findDistinctOrderIdForIdGeneration();

    // Order list of Machinery

    @Query(value = "select * from order_machine_details where seller_id=:sellerId", nativeQuery = true)
    public List<OrderMachineDetails> getByUserId(
    		@Param("sellerId") long sellerId
    		);
}
