package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
//	// --- Find user methods ---
//	List<UserDetails> findAll();
//	List<UserDetails> findAllById(Long userId);
//	Optional<UserDetails> findById(Long userId);
//	
//	// --- Delete a user by ID ---
//	void deleteById(Long userId);
	
	Optional<UserDetails> findByEmailAndPassword(String email, String password);
}
