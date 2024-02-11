package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.SellerAgricultureProductDetails;
import com.cropify.entity.UserDetails;

public class OrderAgricultureProductDetailsDTO {

	private UserDetails farmerId;
	private UserDetails sellerId;
	private AgricultureProducts agricultureProductId;
	private LocalDate orderDate;
	
	@Future
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;

	// -------------Getters and Setters--------------------

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
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

	public AgricultureProducts getAgricultureProductId() {
		return agricultureProductId;
	}

	public void setAgricultureProductId(AgricultureProducts agricultureProductId) {
		this.agricultureProductId = agricultureProductId;
	}

	@Override
	public String toString() {
		return "OrderAgricultureProductDetailsDTO [farmerId=" + farmerId + ", sellerId=" + sellerId
				+ ", agricultureProductId=" + agricultureProductId + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}

}
