package com.cropify.dto;

public class NewFarmProductDTO {
	private Long farmProductDetailsId;
	private String farmProductId;
	private String farmProductName;
	private int quantity;
	private double price;
	private String description;
	
	private int productCount;

	public NewFarmProductDTO() {}
	public NewFarmProductDTO(Long farmProductDetailsId, String farmProductId, String farmProductName, int quantity,
			double price, String description, int productCount) {
		super();
		this.farmProductDetailsId = farmProductDetailsId;
		this.farmProductId = farmProductId;
		this.farmProductName = farmProductName;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.productCount = productCount;
	}
	
	public Long getFarmProductDetailsId() {
		return farmProductDetailsId;
	}
	public void setFarmProductDetailsId(Long farmProductDetailsId) {
		this.farmProductDetailsId = farmProductDetailsId;
	}
	public String getFarmProductId() {
		return farmProductId;
	}
	public void setFarmProductId(String farmProductId) {
		this.farmProductId = farmProductId;
	}
	public String getFarmProductName() {
		return farmProductName;
	}
	public void setFarmProductName(String farmProductName) {
		this.farmProductName = farmProductName;
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
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
		
}
