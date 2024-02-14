package com.cropify.services;

import com.cropify.dto.CartMachineryDTO;

public interface CartMachineryService {
	
	Long addMachineryIntoCart(Long farmerId, CartMachineryDTO cartMachineryDTO);
}
