package com.cropify.services;

import java.util.List;

import com.cropify.dto.UserDetailsDTO;

public interface UserDetailsService {
	List<UserDetailsDTO> getAllUsers();
	UserDetailsDTO getUserById(Long userId);
	UserDetailsDTO createUser(UserDetailsDTO userDto);
	UserDetailsDTO updateUser(UserDetailsDTO userDto, Long userId);
	void deleteUser(Long userId);
}
