package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderMachineDetails extends OrderBaseClass{
	
	@Column(name = "farmer_id")
	private UserDetails farmerId;
	
	@Column(name = "seller_id")
	private UserDetails sellerId;
	
	@Column(name = "machine_id")
	private Machinery machineId;
	
	@Column(name = "rent_duration")
	private int rentDuration;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalPrice;
}
