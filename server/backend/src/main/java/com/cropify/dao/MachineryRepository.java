package com.cropify.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.Machinery;

public interface MachineryRepository extends JpaRepository<Machinery, String>{
	
//	public Optional<Machinery> findByMachineId(String machineId);
//	
//	public List<Machinery> findAll();
//	
////	public Machinery save(Machinery mech);
//	
////	@Query // used to specify a custom SQL or HQL  query that should be executed by the associated method.
//	public void deleteByMachineId(String machineId);
//	
	
//	this method causing error
//	@Modifying
//	@Query("update machine_name = :name from Machinery where machine_id = :id")
//	public void UpdateMachine(@Param("name") String name, @Param("id") String id);
	
//	public Optional<Machinery> findByMachineId(String id);
//	
//	public void deleteByMachineId(String id);
	
//	
}
