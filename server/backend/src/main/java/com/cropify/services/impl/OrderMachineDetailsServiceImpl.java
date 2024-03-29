package com.cropify.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropify.customexception.ResourceNotFoundException;
import com.cropify.dao.CartMachineryRepository;
import com.cropify.dao.MachineryRepository;
import com.cropify.dao.OrderMachineDetailsRepository;
import com.cropify.dao.SellerMachineryDetailsRepository;
import com.cropify.dao.UserDetailsRepository;
import com.cropify.dto.CartMachineryDTO;
import com.cropify.dto.OrderMachineDetailsDTO;
import com.cropify.entity.Machinery;
import com.cropify.entity.OrderMachineDetails;
import com.cropify.entity.UserDetails;
import com.cropify.services.CartMachineryService;
import com.cropify.services.OrderMachineryDetailsService;
import com.cropify.services.SellerMachineryDetailsService;

@Service
@Transactional
public class OrderMachineDetailsServiceImpl implements OrderMachineryDetailsService{

    @Autowired
    private OrderMachineDetailsRepository orderMachineDetailsRepository;

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private SellerMachineryDetailsRepository sellerMachineryDetailsRepository;

    @Autowired
    private CartMachineryService cartMachineryService;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private MachineryRepository machineryRepository;

    @Autowired
    private SellerMachineryDetailsService sellerMachineryDetailsService;

    @Autowired
    private CartMachineryRepository cartMachineryRepository;
    
    @Autowired
    private OrderMachineDetailsRepository machineDetails;

    private String generatedId;

    public String customeIdGenerationForMachineOrders(){
        int count = orderMachineDetailsRepository.findDistinctOrderIdForIdGeneration() + 1;
        generatedId = "om"+count;
        return generatedId;
    }

    public Long MachineCartToOrder(Long farmerId, Double totalPrice){
        List<CartMachineryDTO> farmerCart = cartMachineryService.getAllCartMachineByFarmerId(farmerId);
        // List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();
        customeIdGenerationForMachineOrders();

        for(CartMachineryDTO cartMachineryDTO : farmerCart){
            OrderMachineDetails machineDetails = new OrderMachineDetails();
            UserDetails farmer = userDetailsRepository.findById(farmerId).orElseThrow(() -> new ResourceNotFoundException("user not found"));
            UserDetails seller = userDetailsRepository.findById(cartMachineryDTO.getSellerId()).orElseThrow(() -> new ResourceNotFoundException("seller not found"));
            Machinery machinery = machineryRepository.findById(cartMachineryDTO.getMachineId()).orElseThrow(() -> new ResourceNotFoundException("machine not found"));

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

            // sellerMachineryDetailsService.modifyingSoldQuantity(cartMachineryDTO);

            orderMachineDetailsRepository.save(machineDetails);
            // cartMachineryService.deleteCartMachineById(cartMachineryDTO.getCid());
            cartMachineryRepository.deleteById(cartMachineryDTO.getCid());
        }

        return farmerId;

    }
    
    @Override
    public Long deleteOrderByOID(Long oid) {
    	OrderMachineDetails orderMachineDetails = orderMachineDetailsRepository.findById(oid).orElseThrow(() -> new RuntimeException("Found"));
    	
    	UserDetails sellerId = userDetailsRepository.findById(orderMachineDetails.getSellerId().getId()).orElseThrow();
    	Machinery machinery = machineryRepository.findById(orderMachineDetails.getMachineId().getMachineId()).orElseThrow();
    	
    	sellerMachineryDetailsRepository.updateQuantityBySellerAndMachinery
    									(orderMachineDetails.getQuantity(),
    									sellerId
    									, machinery);
    	orderMachineDetailsRepository.deleteById(oid);
    	return oid;
    }
	
    // Order list of Machinery	
	@Override
	public List<OrderMachineDetailsDTO> getTotalOrders(Long sellerId) {
		List<OrderMachineDetails> details = orderMachineDetailsRepository.getByUserId(sellerId);
//		List<OrderMachineDetails> details = orderMachineDetailsRepository.findBySellerId(sellerId);
		
		List<OrderMachineDetailsDTO> detailsDTOs = details
				.stream()
				.map(item -> mapper.map(item, OrderMachineDetailsDTO.class))
				.collect(Collectors.toList());
//			
//		}
		return detailsDTOs;	
	}

}
