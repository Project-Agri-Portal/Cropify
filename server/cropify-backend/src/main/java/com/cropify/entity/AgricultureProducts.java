package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class AgricultureProducts {
	@Id
	@Column(name = "agri_prod_id")
	private String agriProductId;
	
	@Column(name = "agri_prod_name")
	private String agriProductName;
	
	@Column(name = "agri_prod_type")
	@Enumerated(EnumType.STRING)
	private AgriProductType agriProductType;
}
