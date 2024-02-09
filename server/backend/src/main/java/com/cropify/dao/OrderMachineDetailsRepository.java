package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.OrderMachineDetails;

public interface OrderMachineDetailsRepository extends JpaRepository<OrderMachineDetails, Long>{

//	public Optional<OrderMachineDetails> findByOrderId(Long orderId);
//	
//	public List<OrderMachineDetails> findAllById(Long orderId);
//	
//
//	public void deleteByOrderId(Long orderId);
//	
//	public List<OrderMachineDetails> findAllBy();
}
