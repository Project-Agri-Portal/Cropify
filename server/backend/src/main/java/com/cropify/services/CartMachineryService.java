package com.cropify.services;

import java.util.List;

import com.cropify.dto.CartMachineryDTO;

public interface CartMachineryService {
	
	CartMachineryDTO addMachineryIntoCart(CartMachineryDTO cartMachineryDTO);

	List<CartMachineryDTO> getAllCartMachineByFarmerId(Long farmerId);

	int deleteCartMachineById(String machineId);

	List<CartMachineryDTO> getAllCartMachine();
}
