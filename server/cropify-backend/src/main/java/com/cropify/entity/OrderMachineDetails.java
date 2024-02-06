package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class OrderMachineDetails extends OrderBaseClass{
	
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
	
	@JoinColumn(name = "machine_id", nullable = false)
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
