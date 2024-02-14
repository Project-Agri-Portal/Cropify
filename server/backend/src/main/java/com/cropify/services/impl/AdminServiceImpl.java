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
		Admin admin=this.modelMapper.map(adminDto, Admin.class);
		Admin addedAdmin = adminRepository.save(admin);
		AdminDTO adminDTO=this.modelMapper.map(addedAdmin, AdminDTO.class);
		return adminDTO;
	}

	@Override
	public void deleteAdmin(Long adminId) {
		Admin admin=this.adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException(errorMessage.append(adminId).toString()));
		adminRepository.delete(admin);
	}

	@Override
	public AdminDTO getAdmin(Long adminId) {
		Admin admin= this.adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("Admin Not Found"));
		
		return this.modelMapper.map(admin, AdminDTO.class);
	}

	@Override
	public List<AdminDTO> getAllAdmins() {
		List<Admin> admins= this.adminRepository.findAll();
		List<AdminDTO> adminsDTO=admins.stream().map((admin1)-> this.modelMapper.map(admin1, AdminDTO.class)).collect(Collectors.toList());
		
		return adminsDTO;
	}

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDto, Long adminId) {
		Admin admin= this.adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("Admin Not Found"));
		Admin savedadmin= this.adminRepository.save(admin);

		return this.modelMapper.map(savedadmin, AdminDTO.class);
	}
	
	


}
