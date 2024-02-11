package com.cropify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.AdminRepository;
import com.cropify.dto.AdminDTO;
import com.cropify.entity.Admin;
import com.cropify.services.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ModelMapper modelMapper;

	private StringBuilder errorMessage = new StringBuilder("Admin Not found for ID = ");

	@Override
	public AdminDTO addAdmin(AdminDTO adminDto) {
		Admin admin = this.modelMapper.map(adminDto, Admin.class);
		Admin createdAdmin = this.adminRepository.save(admin);

		return this.modelMapper.map(createdAdmin, AdminDTO.class);
	}

	@Override
	public void deleteAdmin(Long adminId) {
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException(errorMessage.append(adminId).toString()));
		this.adminRepository.delete(admin);
	}

	@Override
	public AdminDTO getAdmin(Long adminId) {
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException(errorMessage.append(adminId).toString()));

		return this.modelMapper.map(admin, AdminDTO.class);
	}

	@Override
	public List<AdminDTO> getAllAdmins() {
		List<Admin> admins = this.adminRepository.findAll();
		List<AdminDTO> adminDtos = admins.stream().map((admin) -> this.modelMapper.map(admin, AdminDTO.class))
				.collect(Collectors.toList());
		return adminDtos;
	}

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDto, Long adminId) {
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException(errorMessage.append(adminId).toString()));
		admin.setAdminMobile(adminDto.getAdminMobile());
		admin.setEmail(adminDto.getAdminMobile());
		admin.setFirstName(adminDto.getFirstName());
		admin.setJoinDate(adminDto.getJoinDate());
		admin.setLastName(adminDto.getLastName());
		admin.setPassword(adminDto.getPassword());
		admin.setRootAdmin(adminDto.isRootAdmin());
		Admin updatedAdmin = this.adminRepository.save(admin);

		return this.modelMapper.map(updatedAdmin, AdminDTO.class);
	}

}
