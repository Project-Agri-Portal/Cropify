package com.cropify.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.MachineryRepository;
import com.cropify.dao.OrderMachineDetailsRepository;
import com.cropify.dao.SellerMachineryDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.entity.Machinery;
import com.cropify.entity.OrderMachineDetails;
import com.cropify.entity.UserDetails;
import com.cropify.services.CartMachineryService;
import com.cropify.services.OrderMachineryDetailsService;

@Service
@Transactional
public class OrderMachineDetailsServiceImpl implements OrderMachineryDetailsService{

    @Autowired
    private OrderMachineDetailsRepository orderMachineDetailsRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CartMachineryService cartMachineryService;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private MachineryRepository machineryRepository;

    @Autowired
    private SellerMachineryDetailsRepository sellerMachineryDetailsRepository;

    private String generatedId;

    public String customeIdGenerationForMachineOrders(){
        int count = orderMachineDetailsRepository.findDistinctOrderIdForIdGeneration();
        generatedId = "OM"+count+1;
        return generatedId;
    }

    public Long MachineCartToOrder(Long farmerId, Double totalPrice){
        List<CartMachineryDTO> farmerCart = cartMachineryService.getAllCartMachineByFarmerId(farmerId);
        List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
        customeIdGenerationForMachineOrders();

        for(CartMachineryDTO cartMachineryDTO : farmerCart){
            OrderMachineDetails machineDetails = new OrderMachineDetails();
            UserDetails farmer = userDetailsRepository.getReferenceById(farmerId);
            UserDetails seller = userDetailsRepository.getReferenceById(cartMachineryDTO.getSellerId());
            Machinery machinery = machineryRepository.getReferenceById(cartMachineryDTO.getMachineId());

            // machineDetails.setId(1L);
            machineDetails.setOrderId(generatedId);
            machineDetails.setFarmerId(farmer);
            machineDetails.setSellerId(seller);
            machineDetails.setMachineId(machinery);

            machineDetails.setRentDuration(3);
            machineDetails.setOrderDate(LocalDate.now());
            machineDetails.setDeliveryDate(LocalDate.now().plusDays(4));
            machineDetails.setQuantity(cartMachineryDTO.getQuantity());
            machineDetails.setTotalPrice(totalPrice);
            machineDetails.setOrderStatus("PLACED");

            orderMachineDetailsRepository.save(machineDetails);
            cartMachineryService.deleteCartMachineById(cartMachineryDTO.getCid());
        }

        return farmerId;

    }

}
