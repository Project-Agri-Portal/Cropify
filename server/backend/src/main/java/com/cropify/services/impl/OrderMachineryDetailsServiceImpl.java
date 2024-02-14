package com.cropify.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.dao.OrderMachineDetailsRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.services.OrderMachineryDetailsService;

@Service
@Transactional
public class OrderMachineryDetailsServiceImpl implements OrderMachineryDetailsService{
    
    @Autowired
    private OrderMachineDetailsRepository detailsRepository;

    public Long addMachineryCartIntoOrder(List<CartMachineryDTO> CartMachineryDTO){
        return 10L;
    }

}
