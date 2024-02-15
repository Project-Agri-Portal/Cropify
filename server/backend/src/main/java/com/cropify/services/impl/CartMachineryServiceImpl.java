package com.cropify.services.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.CartMachineryRepository;
import com.cropify.dao.MachineryRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.entity.CartMachinery;
import com.cropify.entity.Machinery;
import com.cropify.entity.UserDetails;
import com.cropify.services.CartMachineryService;

@Service
@Transactional
public class CartMachineryServiceImpl implements CartMachineryService {

	@Autowired
	private CartMachineryRepository cartMachineryRepository;
	@Autowired
	private UserDetailsRepository userRepo;
	@Autowired
	private MachineryRepository machineRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Long addMachineryIntoCart(Long farmerId, CartMachineryDTO cartMachineryDTO) {
		UserDetails farmer = userRepo.getReferenceById(farmerId); // It retrieves a reference to a UserDetails entity
		// it returns a proxy (a lightweight placeholder) for the entity.
		UserDetails seller = userRepo.getReferenceById(cartMachineryDTO.getSellerId());
		Machinery machine = machineRepo.getReferenceById(cartMachineryDTO.getMachineId());
		CartMachinery cartMachinery = mapper.map(cartMachineryDTO, CartMachinery.class);
		
		cartMachinery.setFarmerId(farmer);
		cartMachinery.setSellerId(seller);
		cartMachinery.setMachineId(machine);
		
		CartMachinery savedCart = cartMachineryRepository.save(cartMachinery);

		return savedCart.getCid();
	}
	
}
