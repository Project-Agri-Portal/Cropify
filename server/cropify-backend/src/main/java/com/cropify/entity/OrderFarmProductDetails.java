package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class OrderFarmProductDetails extends OrderBaseClass {
	@Column(name = "farmer_id")
	private UserDetails farmerId;
	
	@Column(name = "customer_id")
	private UserDetails customerId;
	
	@Column(name = "farm_prod_id")
	private FarmProducts farmProductId;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalPrice;
	
	@Column(name = "farm_order_status")
	@Enumerated(EnumType.STRING)
	private FarmOrderStatus farmOrderStatus;
}
