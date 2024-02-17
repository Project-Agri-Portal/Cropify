package com.cropify.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.cropify.dto.SellerMachineDTO;
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
	private MachineryRepository machineryRepository;
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
		Long sid = cartMachineryDTO.getSellerId();
		String mid = cartMachineryDTO.getMachineId();
		SellerMachineryDetails sellerMachineryDetails = 
								sellerMachineryDetailsRepository
								.findBySellerIdAndMachineId(sid, mid);
								// (cartMachineryDTO.getSellerId(), 
								// cartMachineryDTO.getMachineId());
		
								// sellerMachineryDetails.get

		// System.out.println(cartMachineryDTO.getSellerId());
		// System.out.println(cartMachineryDTO.getMachineId());
		// int quantity = sellerMachineryDetails.getQuantity();

		int availQuantity = sellerMachineryDetails.getAvailQuantity();

		// sellerMachineryDetails.setAvailQuantity(availQuantity - cartMachineryDTO.getQuantity());
		// sellerMachineryDetailsRepository.save(sellerMachineryDetails);
		int rows = sellerMachineryDetailsRepository.updateAvailableMachineQuantity(availQuantity, sellerMachineryDetails.getSellerId().getId(), sellerMachineryDetails.getMachineryId().getMachineId());
		return rows;
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
	public int updateSellerMachineryDetails(SellerMachineryDetailsDTO smDto, Long smId) {
		int quantity = smDto.getQuantity();
		double price = smDto.getPrice();
		String description = smDto.getDescription();
		int availQuantity = smDto.getAvailQuantity();

		int rowsAffected = repository.updateSellerMachineryDetails(quantity, price, description, availQuantity, smId);
		return rowsAffected;
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
	
	//method for SellerMachineDTO

		@Override
		public List<SellerMachineDTO> getAllMachineIntoNewDTO(Long sellerId) {
//			List<Machinery> machineries= machineryRepository.findAll();
			List<SellerMachineryDetails> details= sellerMachineryDetailsRepository.getBySellerId(sellerId);
			System.out.println(sellerId + " " + details.size());
			List<SellerMachineDTO> sellerMachinedtos= new ArrayList<SellerMachineDTO>();
			
			for(SellerMachineryDetails machineries : details) {
				Machinery machinery = machineRepo.findById(machineries.getMachineryId().getMachineId()).orElseThrow(()-> new ResourceNotFoundException("Machine not found"));
				 
				SellerMachineDTO dto= new SellerMachineDTO();
				dto.setMachineId(machinery.getMachineId());
				dto.setMachineName(machinery.getMachineName());
				dto.setQuantity(machineries.getQuantity());
				dto.setAvailQuantity(machineries.getAvailQuantity());
				dto.setDescription(machineries.getDescription());
				dto.setPrice(machineries.getPrice());
				
				dto.setSellerMachineDetailsId(machineries.getSellerMachineryId());
				
				sellerMachinedtos.add(dto);
			}
			return sellerMachinedtos;
		}
}
