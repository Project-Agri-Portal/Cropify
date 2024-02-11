package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderAgricultureProductDetails extends OrderBaseClass {
	// Mapped with user_details for farmer
	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;

	// Mapped with user_details for seller
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false) 
	private UserDetails sellerId;
	
	// Mapped with agri_products
	@ManyToOne
	@JoinColumn(name = "agri_prod_id", nullable = false) 
	private AgricultureProducts agricultureProductId;

//	@ManyToOne // owning
//	@JoinColumn(name = "seller_agri_product_id", nullable = false)
//	private SellerAgricultureProductDetails sellerAgricultureProductId;

	@Column(name = "order_date", nullable = false)
	private LocalDate orderDate;

	@Column(name = "delivery_date", nullable = false)
	private LocalDate deliveryDate;

	@Column
	private int quantity;

	@Column(name = "total_amount", nullable = false)
	private double totalPrice;

	// ------------------ Constructors ----------------------------------
	public OrderAgricultureProductDetails() {
		super();
	}
	
	public OrderAgricultureProductDetails(UserDetails farmerId, UserDetails sellerId,
			AgricultureProducts agricultureProductId, LocalDate orderDate, LocalDate deliveryDate, int quantity,
			double totalPrice) {
		super();
		this.farmerId = farmerId;
		this.sellerId = sellerId;
		this.agricultureProductId = agricultureProductId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	// -----------------------------Getter and Setters--------------------
	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}
	 
//	public SellerAgricultureProductDetails getSellerAgricultureProductId() {
//		return sellerAgricultureProductId;
//	}
//
//	public void setSellerAgricultureProductId(SellerAgricultureProductDetails sellerAgricultureProductId) {
//		this.sellerAgricultureProductId = sellerAgricultureProductId;
//	}

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
