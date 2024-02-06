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
	
	//-----------------------------Getter and Setters--------------------

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	public UserDetails getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UserDetails customerId) {
		this.customerId = customerId;
	}

	public FarmProducts getFarmProductId() {
		return farmProductId;
	}

	public void setFarmProductId(FarmProducts farmProductId) {
		this.farmProductId = farmProductId;
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

	public FarmOrderStatus getFarmOrderStatus() {
		return farmOrderStatus;
	}

	public void setFarmOrderStatus(FarmOrderStatus farmOrderStatus) {
		this.farmOrderStatus = farmOrderStatus;
	}
	
	
}
