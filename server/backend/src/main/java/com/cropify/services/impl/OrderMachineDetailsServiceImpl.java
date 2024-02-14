package com.cropify.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.OrderMachineDetailsRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.entity.CartMachinery;
import com.cropify.entity.OrderMachineDetails;
import com.cropify.services.CartMachineryService;
import com.cropify.services.OrderMachineDetailsService;

@Service
@Transactional
public class OrderMachineDetailsServiceImpl implements OrderMachineDetailsService{

    @Autowired
    private OrderMachineDetailsRepository orderMachineDetailsRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CartMachineryService cartMachineryService;

    private String generatedId;

    public String customeIdGenerationForMachineOrders(){
        int count = orderMachineDetailsRepository.findDistinctByOrderId();
        generatedId = "OM"+count+1;
        return generatedId;
    }

    public List<CartMachinery> MachineCartToOrder(Long FarmerId){
        List<CartMachineryDTO> farmerCart = cartMachineryService.getAllCartMachineByFarmerId(FarmerId);
        List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
        customeIdGenerationForMachineOrders();

        for(CartMachineryDTO cartMachineryDTO : farmerCart){
            OrderMachineDetails machineDetails = new OrderMachineDetails();
            machineDetails.setOrderId(generatedId);
        }

    }

}
