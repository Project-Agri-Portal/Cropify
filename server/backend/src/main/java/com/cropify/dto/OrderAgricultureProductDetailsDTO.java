package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class OrderAgricultureProductDetailsDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long oid;
	private Long farmerId;
	private Long sellerId;
	private String agricultureProductId;
	private LocalDate orderDate;
	
	@Future
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;

	// -------------Getters and Setters--------------------
	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getAgricultureProductId() {
		return agricultureProductId;
	}

	public void setAgricultureProductId(String agricultureProductId) {
		this.agricultureProductId = agricultureProductId;
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
		return "OrderAgricultureProductDetailsDTO [farmerId=" + farmerId + ", sellerId=" + sellerId
				+ ", agricultureProductId=" + agricultureProductId + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
}
