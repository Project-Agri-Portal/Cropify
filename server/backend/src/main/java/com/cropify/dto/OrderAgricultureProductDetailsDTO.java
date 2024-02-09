package com.cropify.dto;

import java.time.LocalDate;

import com.cropify.entity.SellerAgricultureProductDetails;
import com.cropify.entity.UserDetails;

public class OrderAgricultureProductDetailsDTO {

	private UserDetails farmerId;

	private SellerAgricultureProductDetails sellerAgricultureProductId;

	private LocalDate orderDate;

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

	public SellerAgricultureProductDetails getSellerAgricultureProductId() {
		return sellerAgricultureProductId;
	}

	public void setSellerAgricultureProductId(SellerAgricultureProductDetails sellerAgricultureProductId) {
		this.sellerAgricultureProductId = sellerAgricultureProductId;
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

	@Override
	public String toString() {
		return "OrderAgricultureProductDetailsDTO [farmerId=" + farmerId + ", sellerAgricultureProductId="
				+ sellerAgricultureProductId + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}

}
