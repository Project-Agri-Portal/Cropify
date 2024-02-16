package com.cropify.services;

import java.util.List;

import com.cropify.dto.CartFarmProductDTO;

public interface CartFarmerProductService {

    Long addFarmerProductToCart(Long farmerId, CartFarmProductDTO cartFarmProductDTO);
 
}
