package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.cropify.entity.FarmProducts;
import com.cropify.entity.FarmerProductDetails;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmOrderStatus;


public class OrderFarmProductDetailsDTO {
	
	private UserDetails customerId;
	private UserDetails farmerId;
	private FarmProducts farmProdId;
	private LocalDate orderDate;
	
	@Future
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;
	private FarmOrderStatus farmOrderStatus;
	
	//-------------Getters and Setters--------------------


	public UserDetails getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UserDetails customerId) {
		this.customerId = customerId;
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

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	public FarmProducts getFarmProdId() {
		return farmProdId;
	}

	public void setFarmProdId(FarmProducts farmProdId) {
		this.farmProdId = farmProdId;
	}

	@Override
	public String toString() {
		return "OrderFarmProductDetailsDTO [customerId=" + customerId + ", farmerId=" + farmerId + ", farmProdId="
				+ farmProdId + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", farmOrderStatus=" + farmOrderStatus + "]";
	}

}
