package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.cropify.entity.FarmProducts;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmOrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


public class OrderFarmProductDetailsDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long oid;
	private String orderId;
	private Long customerId;
	private Long farmerId;
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	private String farmProdId;
	private LocalDate orderDate;
	
	@Future
	private LocalDate deliveryDate;
	private int quantity;
	private double totalPrice;
	private FarmOrderStatus farmOrderStatus;

	//-------------Getters and Setters--------------------
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UserDetails customerId) {
		this.customerId = customerId.getId();
	}

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId.getId();
	}

	public String getFarmProdId() {
		return farmProdId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public void setFarmProdId(FarmProducts farmProdId) {
		this.farmProdId = farmProdId.getFarmProductId();
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
		return "OrderFarmProductDetailsDTO [customerId=" + customerId + ", farmerId=" + farmerId + ", farmProdId="
				+ farmProdId + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", farmOrderStatus=" + farmOrderStatus + "]";
	}
}
