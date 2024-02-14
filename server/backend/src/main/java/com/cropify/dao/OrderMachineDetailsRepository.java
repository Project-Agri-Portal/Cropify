package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.OrderMachineDetails;

public interface OrderMachineDetailsRepository extends JpaRepository<OrderMachineDetails, Long>{

    public int findDistinctByOrderId();

}
