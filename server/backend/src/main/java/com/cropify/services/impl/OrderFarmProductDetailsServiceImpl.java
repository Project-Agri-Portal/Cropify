package com.cropify.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.CartFarmProductRepository;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.dao.OrderFarmProductDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.entity.CartFarmProduct;
import com.cropify.entity.FarmProducts;
import com.cropify.entity.OrderFarmProductDetails;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmOrderStatus;
import com.cropify.services.OrderFarmProductDetailsService;

@Service
@Transactional
public class OrderFarmProductDetailsServiceImpl implements OrderFarmProductDetailsService{

    @Autowired
    private OrderFarmProductDetailsRepository orderFarmProductDetailsRepository;

    @Autowired
    private CartFarmProductRepository cartFarmProductRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private FarmProductsRepository farmProductsRepository;

    private String customGeneratedId;

    public String customeIdGenerationForFarmProductOrders(){
        int count = orderFarmProductDetailsRepository.findDistinctOrderIdForIdGeneration() + 1;
        customGeneratedId = "of"+count;
        return customGeneratedId;
    }

    @Override
    public String addFarmProductToCart(Long customerId, Double totalPrice) {
        List<CartFarmProduct> cartFarmProducts = 
                                            cartFarmProductRepository
                                            .findCartProductByCustomerId(customerId);
                        
        customeIdGenerationForFarmProductOrders();
                                
        for(CartFarmProduct cartProduct : cartFarmProducts){
            OrderFarmProductDetails orderFarmProductDetails = new OrderFarmProductDetails();

            orderFarmProductDetails.setOrderId(customGeneratedId);
            
            UserDetails customer = userDetailsRepository.findById(cartProduct.getCustomerId().getId()).orElseThrow(() -> new ResourceNotFoundException("user not found"));
            UserDetails farmer = userDetailsRepository.findById(cartProduct.getFarmerId().getId()).orElseThrow(() -> new ResourceNotFoundException("seller not found"));
            FarmProducts farmProducts = farmProductsRepository.findById(cartProduct.getFarmProdId().getFarmProductId()).orElseThrow(() -> new ResourceNotFoundException("seller not found"));

            orderFarmProductDetails.setCustomerId(customer);
            orderFarmProductDetails.setFarmerId(farmer);
            orderFarmProductDetails.setFarmProdId(farmProducts);

            orderFarmProductDetails.setOrderDate(LocalDate.now());

            orderFarmProductDetails.setDeliveryDate
                                                (LocalDateTime.now()
                                                .plusHours(4).toLocalDate());
                                    
            orderFarmProductDetails.setQuantity(cartProduct.getQuantity());
            orderFarmProductDetails.setTotalPrice(totalPrice);
            orderFarmProductDetails.setFarmOrderStatus(FarmOrderStatus.PLACED);

            orderFarmProductDetailsRepository.save(orderFarmProductDetails);

            cartFarmProductRepository.deleteById(cartProduct.getCid());

        }
        return customGeneratedId;
    }

}
