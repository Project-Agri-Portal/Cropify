package com.cropify.services;

import java.util.List;

import com.cropify.dto.UserDetailsDTO;

public interface UserDetailsService {
	// Read operations
	List<UserDetailsDTO> getAllUsers();
	UserDetailsDTO getUserById(Long userId);
	
	// Create operations
	UserDetailsDTO createUser(UserDetailsDTO userDto);
	
	// Update operations
	UserDetailsDTO updateUser(UserDetailsDTO userDto, Long userId);
	
	// Delete operations
	void deleteUser(Long userId);
}
