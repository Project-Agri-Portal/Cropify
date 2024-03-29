package com.cropify.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cropify.dto.UserDetailsDTO;

public interface UserDetailsService {
	// Read operations
	List<UserDetailsDTO> getAllUsers();
	UserDetailsDTO getUserById(Long userId);
	
	// Login operation
	UserDetailsDTO loginCustomer(String email, String password);

	List<UserDetailsDTO> getUser(String userType);
	
	// Create operations
	UserDetailsDTO createUser(UserDetailsDTO userDto);

	void updateStatusById(Long id, String status);
	
	// Update operations
	int updateUser(UserDetailsDTO userDto, Long userId);
	
	// Delete operations
	void deleteUser(Long userId);
	
	//Download image
	byte[] downloadImage(Long userId) throws IOException;
		
	//Upload image
	Long uploadImage(Long userId,MultipartFile userImage) throws IOException;
}
