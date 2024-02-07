package com.cropify.dto;

import java.time.LocalDate;

import com.cropify.entity.FarmOrderStatus;
import com.cropify.entity.FarmerProductDetails;
import com.cropify.entity.UserDetails;


public class OrderFarmProductDetailsDTO {
	
private UserDetails customerId;
	
	private FarmerProductDetails farmerProductDetails;
	
	private LocalDate orderDate;
	
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

	public FarmerProductDetails getFarmerProductDetails() {
		return farmerProductDetails;
	}

	public void setFarmerProductDetails(FarmerProductDetails farmerProductDetails) {
		this.farmerProductDetails = farmerProductDetails;
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

	@Override
	public String toString() {
		return "OrderFarmProductDetailsDTO [customerId=" + customerId + ", farmerProductDetails=" + farmerProductDetails
				+ ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", farmOrderStatus=" + farmOrderStatus + "]";
	}
	
	

}
