package com.cropify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartMachineryDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long cid;
	private String machineId;
	private Long farmerId;
	private Long sellerId;
	private int quantity;
	private double totalAmount;

	public CartMachineryDTO() {}
	public CartMachineryDTO(Long cid) {
		this.cid = cid;
	}
	public CartMachineryDTO(Long cid, String machineId, Long farmerId, Long sellerId, int quantity,
			double totalAmount) {
		this.cid = cid;
		this.machineId = machineId;
		this.farmerId = farmerId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public void setFarmerId(UserDetailsDTO detailsDTO){
		this.farmerId = detailsDTO.getId();
	}

	public void setMachineId(MachineryDTO dto){
		this.machineId = dto.getMachineId();
	}

	public void setSellerId(UserDetailsDTO detailsDTO){
		this.sellerId = detailsDTO.getId();
	}

	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getMachineId() {
		return machineId;
	}
	public Long getFarmerId() {
		return farmerId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
