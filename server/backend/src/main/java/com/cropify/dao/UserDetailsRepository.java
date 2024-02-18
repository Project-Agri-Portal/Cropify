package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

	@Query(value = "select * from user_details where user_type = :userType", nativeQuery = true)
	List<UserDetails> findUser(@Param("userType") String userType);

}
