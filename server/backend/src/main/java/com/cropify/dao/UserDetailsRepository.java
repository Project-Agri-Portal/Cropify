package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Modifying
	@Query("update UserDetails set firstName=:firstName, lastName=:lastName, mobileNo=:mobileNo, email=:email where id=:id")
	int updateUserDetails(
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("mobileNo") String mobileNo,
			@Param("email") String email,
			@Param("id") Long id);

	@Modifying
    @Query("UPDATE UserDetails u SET u.status = :newStatus WHERE u.id = :userId")
    void updateStatusById(@Param("userId") Long userId, @Param("newStatus") String newStatus);

}
