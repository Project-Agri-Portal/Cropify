package com.cropify.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.CartFarmProductRepository;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.dao.FarmerProductDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.CartDTO;
import com.cropify.dto.CartFarmProductDTO;
import com.cropify.entity.CartFarmProduct;
import com.cropify.entity.FarmProducts;
import com.cropify.entity.FarmerProductDetails;
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
    private FarmerProductDetailsRepository farmerProductDetailsRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Long addFarmerProductToCart(Long farmerId, CartFarmProductDTO cartFarmProductDTO) {
        UserDetails farmer = userDetailsRepository.findById(cartFarmProductDTO.getFarmerId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
        UserDetails customer = userDetailsRepository.findById(cartFarmProductDTO.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
        FarmProducts farmProducts = farmProductsRepository.findById(cartFarmProductDTO.getFarmProdId()).orElseThrow(() -> new ResourceNotFoundException("not found"));

        CartFarmProduct cartFarmProduct = mapper.map(cartFarmProductDTO, CartFarmProduct.class);

        cartFarmProduct.setFarmerId(farmer);
        cartFarmProduct.setCustomerId(customer);
        cartFarmProduct.setFarmProdId(farmProducts);

        CartFarmProduct farmProduct  = cartFarmProductRepository.save(cartFarmProduct);

        // FarmerProductDetails farmerProductDetails = farmerProductDetailsRepository.findByFarmProductIdAndFarmerId(cartFarmProductDTO.getFarmProdId(), farmer.getId());
        // int quantity = farmerProductDetails.getQuantity() - cartFarmProduct.getQuantity();
        // farmerProductDetails.setQuantity(quantity);
        farmerProductDetailsRepository.decreaseQuantity(cartFarmProductDTO.getFarmerId(), cartFarmProductDTO.getFarmProdId(), cartFarmProductDTO.getQuantity());

        return farmProduct.getCid();
    }

    @Override
    public List<CartDTO> getAllCartById(Long customerId) {
        List<Object[]> resultList = cartFarmProductRepository.findByCustomerId(customerId);
        List<CartDTO> cartDTOs = new ArrayList<>();
        for (Object[] result : resultList) {
            CartFarmProduct cartFarmProduct = (CartFarmProduct) result[0];
            FarmProducts farmProducts = (FarmProducts) result[1];

            CartDTO cartDTO = new CartDTO();

            cartDTO.setCid(cartFarmProduct.getCid());
            cartDTO.setFarmProductName(farmProducts.getFarmProductName());
            cartDTO.setQuantity(cartFarmProduct.getQuantity());
            cartDTO.setTotalAmount(cartFarmProduct.getTotalAmount());
            cartDTO.setCustomerId(customerId);
            cartDTO.setFarmProductId(farmProducts.getFarmProductId());
            cartDTO.setFarmerId(cartFarmProduct.getFarmerId().getId());
            cartDTO.setDeliveryDate(LocalDateTime.now()
                                                .plusHours(4).toLocalDate());
            cartDTOs.add(cartDTO);

        }
        return cartDTOs;
    }

    @Override
    public Long deleteCartById(Long cartId) {
        CartFarmProduct cartFarmProduct = cartFarmProductRepository.findById(cartId).orElseThrow(() -> new RuntimeException("found"));
        farmerProductDetailsRepository.increaseQuantity(cartFarmProduct.getFarmerId().getId(), cartFarmProduct.getFarmProdId().getFarmProductId(), cartFarmProduct.getQuantity());
        cartFarmProductRepository.deleteById(cartId);
        return cartId;
    }

}
