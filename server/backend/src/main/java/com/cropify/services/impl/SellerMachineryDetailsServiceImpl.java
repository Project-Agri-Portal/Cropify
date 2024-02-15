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
import com.cropify.dto.CartMachineryDTO;
import com.cropify.dto.SellerMachineryDetailsDTO;
import com.cropify.entity.CartMachinery;
import com.cropify.entity.Machinery;
import com.cropify.entity.OrderMachineDetails;
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

	@Autowired
	private SellerMachineryDetailsRepository sellerMachineryDetailsRepository;
	
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
	public int modifyingSoldQuantity(CartMachineryDTO cartMachineryDTO) {
		SellerMachineryDetails sellerMachineryDetails = 
								sellerMachineryDetailsRepository
								.findBySellerIdAndMachineryId
								(cartMachineryDTO.getSellerId(), 
								cartMachineryDTO.getMachineId());

		// System.out.println(cartMachineryDTO.getSellerId());
		// System.out.println(cartMachineryDTO.getMachineId());
		// int quantity = sellerMachineryDetails.getQuantity();

		int availQuantity = sellerMachineryDetails.getAvailQuantity();
		if(availQuantity== 0 || cartMachineryDTO.getQuantity() > availQuantity){
			throw new RuntimeException("stock not available");
		}else{
			// sellerMachineryDetails.setAvailQuantity(availQuantity - cartMachineryDTO.getQuantity());
			// sellerMachineryDetailsRepository.save(sellerMachineryDetails);
			sellerMachineryDetailsRepository.updateAvailableMachineQuantity(availQuantity, cartMachineryDTO.getSellerId(), cartMachineryDTO.getMachineId());
			return 1;
		}
	}

	@Override
	public SellerMachineryDetailsDTO getSellerMachineryDetailsById(Long id) {
		return mapper.map(repository.findById(id), SellerMachineryDetailsDTO.class);
	}

	// ----------------- POST operations ----------------------------
	@Override
	public Long addSellerMachineryDetails(Long id, SellerMachineryDetailsDTO smDto) {
		// Retrieving the Seller proxy
		UserDetails seller = sellerRepo.getReferenceById(id);
		
		// Retrieving machine ID to get machine proxy
		String machineId = smDto.getMachineryId();
		Machinery machine = machineRepo.getReferenceById(machineId);
		
		SellerMachineryDetails detail = mapper.map(smDto, SellerMachineryDetails.class);
		
		// Calling the dependencies helper methods
		seller.addSellerMachineryDetails(detail);
		machine.addSellerMachineryDetails(detail);
		
		// saving the sellerMachineryDetail
		SellerMachineryDetails savedDetail = repository.save(detail);
		
		return savedDetail.getSellerMachineryId();
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
