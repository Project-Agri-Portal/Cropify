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

@Entity
public class SellerAgricultureProductDetails {

	public SellerAgricultureProductDetails() {
//		super();
		// TODO Auto-generated constructor stub
	}

	public SellerAgricultureProductDetails(Long sellerAgricultureProductId, AgricultureProducts agriProductId,
			UserDetails sellerId, int quantity, double price, String description, LocalDate expiryDate,
			FarmProductsStatus sellerProductStatus) {
//		super();
		this.sellerAgricultureProductId = sellerAgricultureProductId;
		this.agriProductId = agriProductId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.expiryDate = expiryDate;
		this.sellerProductStatus = sellerProductStatus;
	}

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

	@Column
	private double price;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "seller_prod_status")
	@Enumerated(EnumType.STRING)
	private FarmProductsStatus sellerProductStatus;

	@OneToMany(mappedBy = "sellerAgricultureProductId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderAgricultureProductDetails> orderAgricultureProductDetails = new ArrayList<>();

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
