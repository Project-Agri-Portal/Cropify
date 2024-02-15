package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.OrderMachineDetails;

public interface OrderMachineDetailsRepository extends JpaRepository<OrderMachineDetails, Long>{

    // public int findDistinctByOrderId();
    @Query(value = "select count(distinct order_id) from order_machine_details", nativeQuery = true)
    public int findDistinctOrderIdForIdGeneration();

}
