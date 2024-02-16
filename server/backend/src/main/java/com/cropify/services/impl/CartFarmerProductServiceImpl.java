package com.cropify.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.CartFarmProductRepository;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.CartFarmProductDTO;
import com.cropify.entity.CartFarmProduct;
import com.cropify.entity.FarmProducts;
import com.cropify.entity.UserDetails;
import com.cropify.services.CartFarmerProductService;

@Service
@Transactional
public class CartFarmerProductServiceImpl implements CartFarmerProductService{
    
    @Autowired
    private FarmProductsRepository farmProductsRepository;

    @Autowired
    private CartFarmProductRepository cartFarmProductRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Long addFarmerProductToCart(Long farmerId, CartFarmProductDTO cartFarmProductDTO) {
        UserDetails farmer = userDetailsRepository.findById(farmerId).orElseThrow(() -> new ResourceNotFoundException("not found"));
        UserDetails customer = userDetailsRepository.findById(cartFarmProductDTO.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
        FarmProducts farmProducts = farmProductsRepository.findById(cartFarmProductDTO.getFarmProdId()).orElseThrow(() -> new ResourceNotFoundException("not found"));

        CartFarmProduct cartFarmProduct = mapper.map(cartFarmProductDTO, CartFarmProduct.class);

        cartFarmProduct.setFarmerId(farmer);
        cartFarmProduct.setCustomerId(customer);
        cartFarmProduct.setFarmProdId(farmProducts);

        CartFarmProduct farmProduct  = cartFarmProductRepository.save(cartFarmProduct);

        return farmProduct.getCid();
    }

}
