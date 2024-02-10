package com.cropify.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cropify.entity.enums.FarmProductsStatus;

@Entity
public class SellerAgricultureProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_agri_product_id")
	private Long sellerAgricultureProductId;

	@ManyToOne
	@JoinColumn(name = "seller_prod_id", nullable = false)
	private AgricultureProducts agriProductId;

	@ManyToOne // owning
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;

	@Column
	private int quantity;

	@Column(nullable = false)
	private double price;

	@Column
	private String description;

	@Column(name = "expiry_date", nullable = false)
	private LocalDate expiryDate;

	@Column(name = "seller_prod_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private FarmProductsStatus sellerProductStatus;

	// ------------ Relationship Mapping ------------------------------
	@OneToMany(mappedBy = "sellerAgricultureProductId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderAgricultureProductDetails> orderAgricultureProductDetails = new ArrayList<>();

	// -------------------------- Constructors ---------------------------
	public SellerAgricultureProductDetails() {}

	public SellerAgricultureProductDetails(Long sellerAgricultureProductId, AgricultureProducts agriProductId,
			UserDetails sellerId, int quantity, double price, String description, LocalDate expiryDate,
			FarmProductsStatus sellerProductStatus) {
		this.sellerAgricultureProductId = sellerAgricultureProductId;
		this.agriProductId = agriProductId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.expiryDate = expiryDate;
		this.sellerProductStatus = sellerProductStatus;
	}
	
	// -----------------------------Getter and Setters--------------------
	public UserDetails getSellerId() {
		return sellerId;
	}

	public void setSellerId(UserDetails sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerAgricultureProductId() {
		return sellerAgricultureProductId;
	}

	public void setSellerAgricultureProductId(Long sellerAgricultureProductId) {
		this.sellerAgricultureProductId = sellerAgricultureProductId;
	}

	public AgricultureProducts getAgriProductId() {
		return agriProductId;
	}

	public void setAgriProductId(AgricultureProducts agriProductId) {
		this.agriProductId = agriProductId;
	}

	public List<OrderAgricultureProductDetails> getOrderAgricultureProductDetails() {
		return orderAgricultureProductDetails;
	}

	public void setOrderAgricultureProductDetails(List<OrderAgricultureProductDetails> orderAgricultureProductDetails) {
		this.orderAgricultureProductDetails = orderAgricultureProductDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public FarmProductsStatus getSellerProductStatus() {
		return sellerProductStatus;
	}

	public void setSellerProductStatus(FarmProductsStatus sellerProductStatus) {
		this.sellerProductStatus = sellerProductStatus;
	}

	// -------------- Helper Methods for: --------------------
	public void addOrderAgricultureProductDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductDetails.add(productDetails);
		productDetails.setSellerAgricultureProductId(this);
	}

	public void removeOrderAgricultureProductDetails(OrderAgricultureProductDetails productDetails) {
		orderAgricultureProductDetails.remove(productDetails);
		productDetails.setSellerAgricultureProductId(null);
	}
}
