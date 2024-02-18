package com.cropify.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.CartFarmProductRepository;
import com.cropify.dao.FarmProductsRepository;
import com.cropify.dao.FarmerProductDetailsRepository;
import com.cropify.dao.OrderFarmProductDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.OrderDTO;
import com.cropify.dto.OrderFarmProductDetailsDTO;
import com.cropify.entity.CartFarmProduct;
import com.cropify.entity.FarmProducts;
import com.cropify.entity.OrderFarmProductDetails;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmOrderStatus;
import com.cropify.entity.enums.FarmProductType;
import com.cropify.services.OrderFarmProductDetailsService;

@Service
@Transactional
public class OrderFarmProductDetailsServiceImpl implements OrderFarmProductDetailsService {

    @Autowired
    private OrderFarmProductDetailsRepository orderFarmProductDetailsRepository;

    @Autowired
    private CartFarmProductRepository cartFarmProductRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private FarmProductsRepository farmProductsRepository;

    @Autowired
    private FarmerProductDetailsRepository farmerProductDetailsRepository;

    private String customGeneratedId;

    public String customeIdGenerationForFarmProductOrders() {
        int count = orderFarmProductDetailsRepository.findDistinctOrderIdForIdGeneration() + 1;
        customGeneratedId = "of" + count;
        return customGeneratedId;
    }

    @Override
    public String addFarmProductToCart(Long customerId, Double totalPrice) {
        List<CartFarmProduct> cartFarmProducts = cartFarmProductRepository
                .findCartProductByCustomerId(customerId);

        customeIdGenerationForFarmProductOrders();

        for (CartFarmProduct cartProduct : cartFarmProducts) {
            OrderFarmProductDetails orderFarmProductDetails = new OrderFarmProductDetails();

            orderFarmProductDetails.setOrderId(customGeneratedId);

            UserDetails customer = userDetailsRepository.findById(cartProduct.getCustomerId().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("user not found"));
            UserDetails farmer = userDetailsRepository.findById(cartProduct.getFarmerId().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("seller not found"));
            FarmProducts farmProducts = farmProductsRepository.findById(cartProduct.getFarmProdId().getFarmProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("seller not found"));

            orderFarmProductDetails.setCustomerId(customer);
            orderFarmProductDetails.setFarmerId(farmer);
            orderFarmProductDetails.setFarmProdId(farmProducts);

            orderFarmProductDetails.setOrderDate(LocalDate.now());

            orderFarmProductDetails.setDeliveryDate(LocalDateTime.now()
                    .plusHours(4).toLocalDate());

            orderFarmProductDetails.setQuantity(cartProduct.getQuantity());
            orderFarmProductDetails.setTotalPrice(totalPrice);
            orderFarmProductDetails.setFarmOrderStatus(FarmOrderStatus.PLACED);

            orderFarmProductDetailsRepository.save(orderFarmProductDetails);

            cartFarmProductRepository.deleteById(cartProduct.getCid());

        }
        return customGeneratedId;
    }

    @Override
    public List<OrderDTO> getAllOrder(Long customerId) {
        List<Object[]> result = orderFarmProductDetailsRepository.findByCustomerIdAndStatus(customerId);
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Object[] objects : result) {
            Long oid = (Long) objects[0];
            String orderId = (String) objects[1];
            UserDetails customer = (UserDetails) objects[2];
            UserDetails farmer = (UserDetails) objects[3];
            FarmProducts farmProduct = (FarmProducts) objects[4];
            LocalDate orderDate = (LocalDate) objects[5];
            LocalDate deliveryDate = (LocalDate) objects[6];
            int quantity = (int) objects[7];
            double totalPrice = (double) objects[8];
            FarmOrderStatus farmOrderStatus = (FarmOrderStatus) objects[9];
            String farmProductId = (String) objects[10];
            String farmProductName = (String) objects[11];
            FarmProductType farmProductType = (FarmProductType) objects[12];

            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setOid(oid);
            orderDTO.setOrderId(orderId);
            orderDTO.setFarmProductName(farmProductName);
            orderDTO.setOrderDate(orderDate);
            orderDTO.setDeliveryDate(deliveryDate);
            orderDTO.setQuantity(quantity);
            orderDTO.setTotalPrice(totalPrice);
            orderDTO.setFarmOrderStatus(farmOrderStatus);

            orderDTOs.add(orderDTO);

            // Now you can use the extracted fields as needed
        }
        return orderDTOs;
    }

    @Override
    public Long deleteOrderById(Long cid) {
        OrderFarmProductDetails orderFarmProductDetails = orderFarmProductDetailsRepository.findById(cid).orElseThrow(() -> new RuntimeException("found"));
        farmerProductDetailsRepository.increaseQuantity(orderFarmProductDetails.getFarmerId().getId(), orderFarmProductDetails.getFarmProdId().getFarmProductId(), orderFarmProductDetails.getQuantity());
        orderFarmProductDetailsRepository.deleteById(cid);
        return cid;
    }

}
