package com.cropify.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	// ---------------- Service Interface Methods ---------------------------
	@Override
	public List<UserDetailsDTO> getAllUsers() {
		List<UserDetails> users = userRepo.findAll();
		List<UserDetailsDTO> userDtos = users.stream().map(user -> mapper.map(user, UserDetailsDTO.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDetailsDTO getUserById(Long userId) {
		
		return null;
	}

	@Override
	public UserDetailsDTO createUser(UserDetailsDTO userDto) {
		UserDetails user = mapper.map(userDto, UserDetails.class);
		UserDetails savedUser = userRepo.save(user);
		return mapper.map(savedUser, UserDetailsDTO.class);
	}

	@Override
	public UserDetailsDTO updateUser(UserDetailsDTO userDto, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub

	}

}
