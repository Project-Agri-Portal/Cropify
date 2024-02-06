package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

@Entity
public class OrderFarmProductDetails extends OrderBaseClass {
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	@JoinColumn(name = "customer_id", nullable = false)
	private UserDetails customerId;
	
	@JoinColumn(name = "farm_prod_id", nullable = false)
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
