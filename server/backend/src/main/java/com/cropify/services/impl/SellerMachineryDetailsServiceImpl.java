package com.cropify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.MachineryRepository;
import com.cropify.dao.SellerMachineryDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.SellerMachineryDetailsDTO;
import com.cropify.entity.Machinery;
import com.cropify.entity.SellerMachineryDetails;
import com.cropify.entity.UserDetails;
import com.cropify.services.SellerMachineryDetailsService;

@Service
@Transactional
public class SellerMachineryDetailsServiceImpl implements SellerMachineryDetailsService {

	@Autowired
	private SellerMachineryDetailsRepository repository;
	@Autowired
	private UserDetailsRepository sellerRepo;
	@Autowired
	private MachineryRepository machineRepo;
	@Autowired
	private ModelMapper mapper;
	
	// --------------- GET operations ----------------------------
	@Override
	public List<SellerMachineryDetailsDTO> getAllSellerMachineryDetails() {
		List<SellerMachineryDetailsDTO> list = repository.findAll()
				.stream()
				.map(detail -> mapper.map(detail, SellerMachineryDetailsDTO.class))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public SellerMachineryDetailsDTO getSellerMachineryDetailsById(Long id) {
		return mapper.map(repository.findById(id), SellerMachineryDetailsDTO.class);
	}

	// ----------------- POST operations ----------------------------
	@Override
	public SellerMachineryDetailsDTO addSellerMachineryDetails(Long id, SellerMachineryDetailsDTO smDto) {
		UserDetails seller = sellerRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("seller not found"));
		SellerMachineryDetails detail = mapper.map(smDto, SellerMachineryDetails.class);
		// calling helper method of seller
		seller.addSellerMachineryDetails(detail);
		
		String machineId = detail.getMachineryId().getMachineId();
		Machinery machine = machineRepo.findById(machineId).orElseThrow(
				() -> new RuntimeException("Machine not found"));
		machine.addSellerMachineryDetails(detail);
		
		// saving the sellerMachineryDetail
		SellerMachineryDetails savedDetail = repository.save(detail);
		return mapper.map(savedDetail, SellerMachineryDetailsDTO.class);
	}

	// ----------------- PUT operations ----------------------------
	@Override
	public SellerMachineryDetailsDTO updateSellerMachineryDetails(SellerMachineryDetailsDTO smDto, Long id) {
		SellerMachineryDetails detail = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("seller machinery detail not found"));
		detail = mapper.map(smDto, SellerMachineryDetails.class);
		SellerMachineryDetails savedDetail =  repository.save(detail);
		return mapper.map(savedDetail, SellerMachineryDetailsDTO.class);
	}

	// ----------------- DELETE operations ----------------------------
	@Override
	public void deleteSellerMachineryDetailsById(Long id) {
		boolean detailExists = repository.existsById(id);
		if (detailExists)
			repository.deleteById(id);
		else
			throw new RuntimeException("seller machinery detail not found");
	}

}
