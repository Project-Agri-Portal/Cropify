package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderAgricultureProductDetails extends OrderBaseClass {

	public OrderAgricultureProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderAgricultureProductDetails(UserDetails farmerId,
			SellerAgricultureProductDetails sellerAgricultureProductId, LocalDate orderDate, LocalDate deliveryDate,
			int quantity, double totalPrice) {
		super();
		this.farmerId = farmerId;
		this.sellerAgricultureProductId = sellerAgricultureProductId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;

	/*
	 * @JoinColumn(name = "seller_id", nullable = false) private UserDetails
	 * sellerId;
	 * 
	 * @JoinColumn(name = "agri_prod_id", nullable = false) private
	 * AgricultureProducts agricultureProductId;
	 */
	@ManyToOne // owning
	@JoinColumn(name = "seller_agri_product_id", nullable = false)
	private SellerAgricultureProductDetails sellerAgricultureProductId;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "delivery_date")
	private LocalDate deliveryDate;

	@Column
	private int quantity;

	@Column(name = "total_amount")
	private double totalPrice;

	// -----------------------------Getter and Setters--------------------

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	/*
	 * public UserDetails getSellerId() { return sellerId; } public void
	 * setSellerId(UserDetails sellerId) { this.sellerId = sellerId; } public
	 * AgricultureProducts getAgricultureProductId() { return agricultureProductId;
	 * } public void setAgricultureProductId(AgricultureProducts
	 * agricultureProductId) { this.agricultureProductId = agricultureProductId; }
	 */
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

}
