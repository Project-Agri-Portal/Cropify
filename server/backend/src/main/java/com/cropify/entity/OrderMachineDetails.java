package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderMachineDetails extends OrderBaseClass {

	// Mapped with UserDetails table
	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false) 
	private UserDetails sellerId;
	
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false) 
	private Machinery machineId;

	/* Mapped with SellerMachinery table
	@ManyToOne // owning
	@JoinColumn(name = "seller_machine_id", nullable = false)
	private SellerMachineryDetails sellerMachineryId;
	 */

	@Column(name = "rent_duration", nullable = false)
	private int rentDuration;

	@Column(name = "order_date", nullable = false)
	private LocalDate orderDate;

	@Column(name = "delivery_date", nullable = false)
	private LocalDate deliveryDate;

	@Column
	private int quantity;

	@Column(name = "total_amount", nullable = false)
	private double totalPrice;

	// ---------- Constructors --------------------------
	public OrderMachineDetails() {
		super();
	}
	
	public OrderMachineDetails(UserDetails farmerId, UserDetails sellerId, Machinery machineId, int rentDuration,
			LocalDate orderDate, LocalDate deliveryDate, int quantity, double totalPrice) {
		super();
		this.farmerId = farmerId;
		this.sellerId = sellerId;
		this.machineId = machineId;
		this.rentDuration = rentDuration;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
/*	public OrderMachineDetails(UserDetails farmerId, SellerMachineryDetails sellerMachineryId, int rentDuration,
//			LocalDate orderDate, LocalDate deliveryDate, int quantity, double totalPrice) {
//		super();
//		this.farmerId = farmerId;
////		this.sellerMachineryId = sellerMachineryId;
//		this.rentDuration = rentDuration;
//		this.orderDate = orderDate;
//		this.deliveryDate = deliveryDate;
//		this.quantity = quantity;
//		this.totalPrice = totalPrice;
	}*/
	
	// -----------------------------Getter and Setters--------------------
	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	/*
	public SellerMachineryDetails getSellerMachineryId() {
		return sellerMachineryId;
	}
	public void setSellerMachineryId(SellerMachineryDetails sellerMachineryId) {
		this.sellerMachineryId = sellerMachineryId;
	}
	*/
	
	public int getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserDetails getSellerId() {
		return sellerId;
	}

	public void setSellerId(UserDetails sellerId) {
		this.sellerId = sellerId;
	}

	public Machinery getMachineId() {
		return machineId;
	}

	public void setMachineId(Machinery machineId) {
		this.machineId = machineId;
	}

}
