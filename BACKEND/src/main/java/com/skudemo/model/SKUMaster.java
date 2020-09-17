package com.skudemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;


@Entity
public class SKUMaster {
	@Id
	@GeneratedValue
	private Long skuId;
	private String skuName;
	private Double price;
	@Transient
	private Integer quantity;
	
	
	@ManyToMany(mappedBy = "skus")
    private Set<CartMaster> carts = new HashSet<>();
	 
	 

//	public PromotionRule getRule() {
//		return rule;
//	}
//
//	public void setRule(PromotionRule rule) {
//		this.rule = rule;
//	}
//


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SKUMaster() {
		super();
	}

	public Set<CartMaster> getCarts() {
		return carts;
	}

	public void setCarts(Set<CartMaster> carts) {
		this.carts = carts;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}



	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	
}
