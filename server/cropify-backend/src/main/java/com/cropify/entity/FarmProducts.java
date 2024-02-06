package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class FarmProducts {
	@Id
	@Column(name = "farm_prod_id")
	private String farmProductId;
	
	@Column(name = "farm_prod_name")
	private String farmProductName;
	
	@Column(name = "farm_prod_type")
	@Enumerated(EnumType.STRING)
	private FarmProductType farmProductType;
}
