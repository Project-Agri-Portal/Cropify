package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cropify.entity.OrderMachineDetails;

public interface OrderMachineDetailsRepository extends JpaRepository<OrderMachineDetails, Long>{

	@Query
	public Optional<OrderMachineDetails> findById(Long orderId);
	
	public List<OrderMachineDetails> findAllById(Long orderId);
	
	@Query
	public void deleteById(Long orderId);
	
	public List<OrderMachineDetails> findAllBy();
}
