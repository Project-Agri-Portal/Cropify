package com.cropify.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.UserDetailsDTO;
import com.cropify.entity.UserDetails;
import com.cropify.services.UserDetailsService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepository userRepo;
	@Autowired
	private ModelMapper mapper;
	
	// Custom error message for user not found by ID
	private StringBuilder errorMessage = new StringBuilder("User Not found for ID = ");
	
	// ---------------- Service Interface Methods ---------------------------
	//  ---------------- Get operations ----------------
	@Override
	public List<UserDetailsDTO> getAllUsers() {
		List<UserDetails> users = userRepo.findAll();
		List<UserDetailsDTO> userDtos = users.stream().map(
				user -> mapper.map(user, UserDetailsDTO.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDetailsDTO getUserById(Long userId) {
//		UserDetails user = userRepo.getReferenceById(userId);
		UserDetails user = userRepo.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException(errorMessage.append(userId).toString()));
		UserDetailsDTO userDto = mapper.map(user, UserDetailsDTO.class);			
		return userDto;
	}

	// ---------------- Create operations ----------------
	@Override
	public UserDetailsDTO createUser(UserDetailsDTO userDto) {
		UserDetails user = mapper.map(userDto, UserDetails.class);
		UserDetails savedUser = userRepo.save(user);
		return mapper.map(savedUser, UserDetailsDTO.class);
	}

	// ---------------- Update operations ----------------
	@Override
	public UserDetailsDTO updateUser(UserDetailsDTO userDto, Long userId) {
		UserDetails user = userRepo.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException(errorMessage.append(userId).toString()));
		user = mapper.map(userDto, UserDetails.class);
		UserDetails savedUser = userRepo.save(user);
		return mapper.map(savedUser, UserDetailsDTO.class);
	}

	// ---------------- Delete operations ----------------
	@Override
	public void deleteUser(Long userId) {
		boolean userExists = userRepo.existsById(userId);
		if (userExists)
			userRepo.deleteById(userId);
		else
			throw new ResourceNotFoundException(errorMessage.append(userId).toString());
	}
	
	
	//Download Image
	
	@Override
	public byte[] downloadImage(Long userId) throws IOException {
		UserDetails userDetails= userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not Found"));

		return userDetails.getImgPath();
	}

	//Upload Image
	
	@Override
	public Long uploadImage(Long userId, MultipartFile userImage) throws IOException {
		UserDetails userDetails= userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not Found"));
		userDetails.setImgPath(userImage.getBytes());
		return userDetails.getId();
	}

}
