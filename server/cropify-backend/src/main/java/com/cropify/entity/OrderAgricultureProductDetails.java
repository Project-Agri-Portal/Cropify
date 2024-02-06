package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class OrderAgricultureProductDetails extends OrderBaseClass {
	@Column(name = "farmer_id")
	private UserDetails farmerId;
	
	@Column(name = "seller_id")
	private UserDetails sellerId;
	
	@Column(name = "agri_prod_id")
	private AgricultureProducts agricultureProductId;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalPrice;
}
